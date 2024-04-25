package org.example.teamshortner.service;

import org.example.teamshortner.model.Link;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class LinkService {
    @Value("${short-url.base-url}")
    private String baseUrl;
    @Value("${short-url.length}")
    private String length;
    private Map<String, Link> context;
}
