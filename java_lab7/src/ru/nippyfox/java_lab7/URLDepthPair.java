package ru.nippyfox.java_lab7;

import java.util.*;
import java.net.*;

public class URLDepthPair {
    public static final String URL_PREFIX = "<a href=\"http";

    public String URL;
    public int depth;

    public URLDepthPair (String URL, int depth){
        this.URL=URL;
        this.depth=depth;
    }

    public String getHost() throws MalformedURLException {
        URL host = new URL(URL);
        return host.getHost();
    }

    public String getPath() throws MalformedURLException {
        URL path = new URL(URL);
        return path.getPath();
    }

    public int getDepth() {
        return depth;
    }

    public String getURL() {
        return URL;
    }

    public static boolean check(LinkedList<URLDepthPair> findRef, URLDepthPair pair) {
        boolean isAlready = true;
        for (URLDepthPair i: findRef)
            if (i.getURL().equals(pair.getURL())) {
                isAlready = false;
                break;
            }
        return isAlready;
    }
}