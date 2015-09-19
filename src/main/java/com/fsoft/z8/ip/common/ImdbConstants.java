package com.fsoft.z8.ip.common;

public final class ImdbConstants {
    private ImdbConstants() {
    }

    public static final int TIME_OUT_VALUE 	 = 0; // millisecond
    public static final int ZERO_VALUE 		 = 0;
    public static final String BASE_URL 	 = "http://www.imdb.com";
    public static final String STARTING_POINT 	 = "http://www.imdb.com/chart/top?ref_=m_nv_mv_250";

    public static final class PREFIX {
	public static final String PERSON 	 = ImdbConstants.BASE_URL + "/name/";
	public static final String FILM 	 = ImdbConstants.BASE_URL + "/title/";
    };

    public static final int MAX_DEPTH 		 = 2;
    public static final int MAX_THREAD 		 = Runtime.getRuntime().availableProcessors();
    public static final int MAX_PAGE_FETCHED 	 = 5;
    public static final int EXPECTED_RESULT_PAGE = 100;
    public static final int EXPECTED_VISITED_URL = 100;
    
    public static final String DATE_FORMAT 	 = "yyyy-MM-dd";
    public static final String HIBERNATE_CONFIG	 = "hibernate.cfg.xml";
    public static final String PROXY_SETTINGS	 = "config.properties";
}
