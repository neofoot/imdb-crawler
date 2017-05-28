package com.fsoft.z8.ip.crawl;

import com.fsoft.z8.ip.common.ImdbCommonUtils;
import org.jsoup.nodes.Document;

import java.util.Date;
import java.util.logging.Logger;

public final class FilmPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(FilmPage.class.getName());

    public FilmPage(String url, Document doc) {
        super(url, doc);
    }

    /**
     * @return a {@link Film} object base on <code>this.getDoc()</code>
     */
    @Override
    public Object getEntityFromDoc() {

        Document doc = this.getDoc();
        String title = doc.select("#overview-top h1.header span.itemprop").text();
        String date = doc.select("#overview-top div.infobar span.nobr a meta").attr("content");
        String rating = doc.select("#overview-top div.star-box .titlePageSprite").text();

        if (rating.isEmpty()) {
            rating = "-1";
        }

        Date releaseDate = ImdbCommonUtils.getInstance().parseDateSimple(date);
        double ratingValue = Double.parseDouble(rating);
        // return new Film(title, releaseDate, ratingValue, this.getUrl());
        return null;
    }
}
