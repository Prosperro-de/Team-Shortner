package org.example.teamshortner.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LinkService {

    private Map<String, String> context;

    public LinkService() {
        this.context = new HashMap<>();
    }

    /**
     * Creates a short URL for the given original URL and stores it in the map.
     * @param originalUrl the URL to be shortened
     * @return the shortened URL
     */
    public String shortenUrl(String originalUrl) {
        String shortUrl = UUID.randomUUID().toString().substring(0, 8);
        context.put(shortUrl, originalUrl);
        return shortUrl;
    }

    /**
     * Retrieves the original URL for the given short URL.
     * @param shortUrl the shortened URL
     * @return the original URL, or null if not found
     */
    public String getOriginalUrl(String shortUrl) {
        return context.get(shortUrl);
    }

}
