package org.example.teamshortner.controller;

import org.example.teamshortner.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MainController {

    @Autowired
    LinkService linkService;

    @PostMapping(value = "add_link", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getLink(@RequestBody BaseUrl baseUrl) {
        final var link = linkService.shortenUrl(baseUrl.url());
        return ResponseEntity.ok(link);
    }

    @GetMapping("{uid}")
    public RedirectView getOriginalLink(@PathVariable("uid") String uid) {
        final var originalUrl = linkService.getOriginalUrl(uid);
        // TODO implement not found
        return new RedirectView(originalUrl);
    }

    record BaseUrl(String url) {}

}
