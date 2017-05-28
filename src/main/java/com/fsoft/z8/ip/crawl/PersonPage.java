package com.fsoft.z8.ip.crawl;

import com.fsoft.z8.ip.common.ImdbCommonUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.logging.Logger;

public final class PersonPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PersonPage.class.getName());

    public PersonPage(String url, Document doc) {
        super(url, doc);
    }

    /**
     * @return an {@link Person} based on <code>this.getDoc()</code>
     */
    @Override
    public Object getEntityFromDoc() {
        Document doc = this.getDoc();
        String name = null;
        Elements elements = doc.select("table#name-overview-widget-layout "
                + "td#overview-top span.itemprop");
        if (!elements.isEmpty()) {
            name = elements.get(0).text();
        }

        Date dob = null;
        elements = doc.select("div#name-born-info time");
        if (!elements.isEmpty()) {
            String date = elements.get(0).attr("datetime").toString();
            dob = ImdbCommonUtils.getInstance().parseDateSimple(date);
        }

        String address = "n/a";
        elements = doc.select("div#name-born-info a");
        if (elements.isEmpty()) {
            // return new Person(name, address, dob, this.getUrl());
        }
        for (Element element : elements) {
            if (element.attr("href").contains("birth_place=")) {
                address = element.text();
            }
        }
        // return new Person(name, address, dob, this.getUrl());
        return null;
    }
}
