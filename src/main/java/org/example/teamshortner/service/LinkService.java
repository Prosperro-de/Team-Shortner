package org.example.teamshortner.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class LinkService {

    @Value("${short-url.base-url}")
    private String baseUrl;

    @Value("${short-url.length}")
    private String length;

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
        String shortUrl = baseUrl + UUID.randomUUID().toString().substring(0, Integer.parseInt(length));
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
