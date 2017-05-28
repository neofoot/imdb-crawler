package com.fsoft.z8.ip.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * An utility class has several methods that handle common tasks.
 */
public final class ImdbCommonUtils {
    private static final Logger LOGGER = Logger.getLogger(ImdbCommonUtils.class.getName());
    private static final ImdbCommonUtils INSTANCE = new ImdbCommonUtils();

    private ImdbCommonUtils() {
    }

    public static ImdbCommonUtils getInstance() {
        return ImdbCommonUtils.INSTANCE;
    }

    /**
     * Reference: https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
     *
     * @param url to visit
     * @return document corresponding to given url
     */
    public Document getDocument(String url) {
        try {
            URL link = new URL(url);
            URLConnection connection = link.openConnection();
            StringBuilder sourcePage = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sourcePage.append(inputLine);
                }
            } finally {
                in.close();
            }
            return Jsoup.parse(sourcePage.toString());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    /**
     * @param strDate An input string will be parsed.
     * @return Date parsed from given string <code>strDate</code>
     */
    public Date parseDateSimple(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ImdbConstants.DATE_FORMAT);
        Date date = null;
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException e) {
            LOGGER.info(e.getMessage());
        }
        return date;
    }
}
