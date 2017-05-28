package com.fsoft.z8.ip.crawl;

public final class CrawlerFactory {
    private static CrawlerFactory INSTANCE = new CrawlerFactory();

    private CrawlerFactory() {
    }

    public static CrawlerFactory getInstance() {
        return CrawlerFactory.INSTANCE;
    }

    public Crawler createCrawler(CrawlerConfiguration config) {
        return new Crawler(config);
    }
}
