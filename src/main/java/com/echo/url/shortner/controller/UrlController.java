package com.echo.url.shortner.controller;

import com.echo.url.shortner.ro.UrlRequest;
import com.echo.url.shortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlRequest urlRequest) {

        String code = urlService.shortenUrl(urlRequest.getUrl());

        return "http://localhost:8080/" + code;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {

        String originalUrl = urlService.getOriginalUrl(code);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
