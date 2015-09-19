package com.fsoft.z8.ip.crawl;

import java.util.Set;

public final class CrawlerConfiguration {
    
    private Set<String> visitedURLs;
    private int expectedNumberOfPages;
    private int maxDepth;
    private int maxURLFecthedPerPage;
    private String prefix;
    private String suffix;
    
    private int currentNumberOfPages;
    
    public CrawlerConfiguration() {
	this.currentNumberOfPages = 0;
    }

    public int getCurrentNumberOfPages() {
        return currentNumberOfPages;
    }

    /**
     * @return the expectedNumberOfPages
     */
    public int getExpectedNumberOfPages() {
        return expectedNumberOfPages;
    }
    
    /**
     * @return the maxDepth
     */
    public int getMaxDepth() {
        return maxDepth;
    }

    /**
     * @return the maxURLFecthedPerPage
     */
    public int getMaxURLFecthedPerPage() {
        return maxURLFecthedPerPage;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @return the visitedURLs
     */
    public Set<String> getVisitedURLs() {
        return visitedURLs;
    }

    public void increaseCurrentNumberOfPages() {
        this.currentNumberOfPages++;
    }

    /**
     * @param expectedNumberOfPages the expectedNumberOfPages to set
     */
    public void setExpectedNumberOfPages(int expectedNumberOfPages) {
        this.expectedNumberOfPages = expectedNumberOfPages;
    }

    /**
     * @param maxDepth the maxDepth to set
     */
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * @param maxURLFecthedPerPage the maxURLFecthedPerPage to set
     */
    public void setMaxURLFecthedPerPage(int maxURLFecthedPerPage) {
        this.maxURLFecthedPerPage = maxURLFecthedPerPage;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    /**
     * @param suffix the suffix to set
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * @param visitedURLs the visitedURLs to set
     */
    public void setVisitedURLs(Set<String> visitedURLs) {
        this.visitedURLs = visitedURLs;
    }
}
