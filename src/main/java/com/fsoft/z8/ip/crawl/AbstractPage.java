package com.fsoft.z8.ip.crawl;

import org.jsoup.nodes.Document;

/**
 * An abstract class that represents a web page.
 */
public abstract class AbstractPage {
    private String url;
    private Document doc;

    public AbstractPage(String url, Document doc) {
        this.url = url;
        this.doc = doc;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return this.doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public abstract Object getEntityFromDoc();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !AbstractPage.class.isInstance(obj)) {
            return false;
        }
        AbstractPage page = (AbstractPage) obj;
        return page.getUrl().equals(this.getUrl());
    }

}
