package com.udemy.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtil {
    // hits the given url and returns the HTTP response code
    public static int getResponseCode(String link) {
        URL url;
        HttpURLConnection con = null;
        Integer responsecode = 0;
        try {
            url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            responsecode = con.getResponseCode();
        } catch (Exception e) {
            // skip
        } finally {
            if (null != con)
                con.disconnect();
        }
        return responsecode;
    }

    public static int getResponseCodeImproved(String link) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); // faster than GET for checking availability
            connection.setConnectTimeout(3000);  // short timeout for responsiveness
            connection.setReadTimeout(3000);
            connection.connect();

            return connection.getResponseCode();

        } catch (Exception e) {
            return -1; // Treat any error as broken
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
