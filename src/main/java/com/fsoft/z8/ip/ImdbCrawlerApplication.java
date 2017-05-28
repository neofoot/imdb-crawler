package com.fsoft.z8.ip;

import com.fsoft.z8.ip.common.ImdbConstants;
import com.fsoft.z8.ip.crawl.Crawler;
import com.fsoft.z8.ip.crawl.CrawlerConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public final class ImdbCrawlerApplication {

    private final CrawlerConfiguration configuration;
    private int numberOfCrawler = ImdbConstants.MAX_THREAD;

    private void loadSystemProperties() {
        // LOGGER.info("Consider setting username and password for proxy in config.properties");
        InputStream inputStream = ImdbCrawlerApplication.class.getResourceAsStream(ImdbConstants.PROXY_SETTINGS);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            Iterator<Object> iterator = properties.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                System.setProperty(key.toString(), properties.get(key.toString()).toString());
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private void setNumberOfCrawler(int maxThread) {
        this.numberOfCrawler = maxThread;
    }

    public ImdbCrawlerApplication(CrawlerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void run() {
        // Load some configuration from file (proxy server, proxy-user,
        // proxy-password)
    /*LOGGER.info("Consider setting username and password for proxy in config.properties");
	InputStream inputStream = ImdbCrawlerApplication.class
		.getResourceAsStream(ImdbConstants.PROXY_SETTINGS);
	Properties properties = new Properties();
	try {
	    properties.load(inputStream);
	    Iterator<Object> iterator = properties.keySet().iterator();
	    while (iterator.hasNext()) {
		Object key = iterator.next();
		System.setProperty(key.toString(),
			properties.get(key.toString()).toString());
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}*/

        // Execute some threads
        ExecutorService executorService = Executors
                .newFixedThreadPool(ImdbConstants.MAX_THREAD);
        for (int i = 0; i < ImdbConstants.MAX_THREAD; i++) {
            Runnable worker = new Crawler(this.configuration);
            executorService.execute(worker);
        }
        // Shutdown all tasks
        while (!executorService.isTerminated() || Thread.activeCount() > 0) {
            if (executorService.isTerminated()) {
                executorService.shutdown();
                break;
            }
        }
        LOGGER.info("Finish!");
    }

    private static final Logger LOGGER = Logger.getLogger(ImdbCrawlerApplication.class.getName());

    public static void main(String[] args) {

        CrawlerConfiguration configuration = new CrawlerConfiguration();
        configuration.setVisitedURLs(new HashSet<String>()); // TODO load visited urls from database
        // configuration.setFilmDao(new FilmDaoImpl());
        // configuration.setPersonDao(new PersonDaoImpl());
        configuration.setExpectedNumberOfPages(ImdbConstants.EXPECTED_RESULT_PAGE);

        ImdbCrawlerApplication app = new ImdbCrawlerApplication(configuration);
        app.setNumberOfCrawler(ImdbConstants.MAX_THREAD);
        app.run();

    }
}
