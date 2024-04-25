package org.example.teamshortner.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MainController {

//    @Autowired
//    LinkService linkService;

    @PostMapping(value = "get-link", consumes = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getLink(@RequestBody String baseUrl) {
        // TODO call service
        final var link = "test shortened url";
        return ResponseEntity.ok(link);
    }

    @GetMapping("{uid}")
    public RedirectView getOriginalLink(@PathVariable("uid") String uid) {
        // TODO call service
        final var originalUrl = "http://example.com/";
        // TODO implement not found
        return new RedirectView(originalUrl);
    }

}
