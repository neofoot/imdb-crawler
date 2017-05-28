package com.fsoft.z8.ip.crawl;

import com.fsoft.z8.ip.common.ImdbCommonUtils;
import com.fsoft.z8.ip.common.ImdbConstants;
import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Set;

/**
 * A runnable class that represents a object which crawls web sites.
 */
public final class Crawler implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Crawler.class);

    private final CrawlerConfiguration config;

    public Crawler(CrawlerConfiguration config) {
        this.config = config;
    }

    public synchronized Set<String> getVisitedURLs() {
        return this.config.getVisitedURLs();
    }

    public synchronized int getNumberOfPages() {
        return this.config.getCurrentNumberOfPages();
    }

    public synchronized void increaseNumberOfPages() {
        this.config.increaseCurrentNumberOfPages();
    }

    @Override
    public void run() {
        try {
            // Retrieve document
            Document document = ImdbCommonUtils.getInstance().getDocument(ImdbConstants.STARTING_POINT);

            // Break the progress in case there is no document returned
            if (document == null) {
                return;
            }

            // Initialize the depth
            int depth = ImdbConstants.ZERO_VALUE;

            // web: .titleColumn
            // mobile: .media
            Elements anchors = document.select(".titleColumn a[href]");
            for (Element anchor : anchors) {
                // Break if reach the expected result
                if (this.getNumberOfPages() >= ImdbConstants.EXPECTED_RESULT_PAGE) {
                    break;
                }

                // Initialize next URL to be visited
                String url = ImdbConstants.BASE_URL + anchor.attr("href");

                // Only interesting URL should be visited
                if (!(url.startsWith(ImdbConstants.PREFIX.PERSON) || url.startsWith(ImdbConstants.PREFIX.FILM))) {
                    continue;
                }

                // Visit the next URL
                this.visitUrl(url.toString(), depth);
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } finally {
            ImdbHibernateUtil.getSessionFactory().close();
        }
    }

    /**
     * http://docs.oracle.com/cd/E17952_01/connector-j-relnotes-en/news-5-1-23.html
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                final Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (final SQLException e) {
                LOGGER.info("Unable to de-register driver");
            }
        }
        // Try to shutdown AbandonedConnectionCleanupThread
        try {
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private synchronized void visitUrl(String url, int depth)
            throws IOException {

	/*
     * if (this.getPages().size() >= ImdbConstants.EXPECTED_RESULT_PAGE) {
	 * return; }
	 */
        if (this.getNumberOfPages() >= ImdbConstants.EXPECTED_RESULT_PAGE) {
            return;
        }

        // LOGGER.info("Number of visted url(s): " +
        // this.getVisitedURLs().size());

        if (url.isEmpty() || depth > ImdbConstants.MAX_DEPTH) {
            return;
        }

        if (this.getVisitedURLs().contains(url)) {
            LOGGER.info("Already visited " + url);
            return;
        }

        this.addVisitedURL(url);

        Document doc = ImdbCommonUtils.getInstance().getDocument(url);
        if (doc == null) {
            return;
        }

        // Build CSS query for child links
        // Insert new film/person into database
        String cssQuery = "a[href]";
        if (url.startsWith(ImdbConstants.PREFIX.PERSON)) {
            // web: .filmo-category-section
            // mobile: #filmography
            cssQuery = ".filmo-category-section a[href]";
            PersonPage personPage = new PersonPage(url, doc);
	    /*
	     * Person person = (Person) personPage.getEntityFromDoc(); if
	     * (this.insertPerson(person)) {
	     * LOGGER.info("Successfully retrieve info from url[depth=" + depth
	     * + "] " + url); LOGGER.info("Insert person(name=" +
	     * person.getName() + ") sucessfully.");
	     * this.increaseNumberOfPages(); } else {
	     * LOGGER.info("Failed to insert person(name=" + person.getName() +
	     * ") into database."); }
	     */
            this.increaseNumberOfPages();
        } else if (url.startsWith(ImdbConstants.PREFIX.FILM)) {
            // web: .itemprop
            // mobile: .cast-and-crew
            cssQuery = ".itemprop a[href]";
            FilmPage filmPage = new FilmPage(url, doc);
	    /*
	     * Film film = (Film) filmPage.getEntityFromDoc(); if
	     * (this.insertFilm(film)) {
	     * LOGGER.info("Successfully retrieve info from url[depth=" + depth
	     * + "] " + url); LOGGER.info("Insert film(title=" + film.getTitle()
	     * + ") successfully."); this.increaseNumberOfPages(); } else {
	     * LOGGER.info("Failed to insert film(title=" + film.getTitle() +
	     * ") into database."); }
	     */
            this.increaseNumberOfPages();
        }

        LOGGER.info("Number of retrieved pages: " + this.getNumberOfPages());

        // Start visiting child links
        int pageCounter = ImdbConstants.ZERO_VALUE;
        Elements anchors = doc.select(cssQuery);
        for (Element anchor : anchors) {
            if (pageCounter >= ImdbConstants.MAX_PAGE_FETCHED) {
                break;
            }
            String childUrl = ImdbConstants.BASE_URL + anchor.attr("href");
            // Ignore uninteresting links
            if (!(childUrl.startsWith(ImdbConstants.PREFIX.PERSON) || childUrl
                    .startsWith(ImdbConstants.PREFIX.FILM))) {
                continue;
            }
            this.visitUrl(childUrl.toString(), depth + 1);
            pageCounter++;
        }
    }

    public synchronized void addVisitedURL(String url) {
        this.getVisitedURLs().add(url);
    }

    /*
     * private boolean insertFilm(Film film) { if (film == null) { return false;
     * } if (film.isValidated()) { this.config.getFilmDao().insert(film); return
     * true; } return false; }
     * 
     * private boolean insertPerson(Person person) { if (person == null) {
     * return false; } if (person.isValidated()) {
     * this.config.getPersonDao().insert(person); return true; } return false; }
     */

}
