package com.echo.url.shortner.service;

import com.echo.url.shortner.entity.UrlMapping;
import com.echo.url.shortner.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String originalUrl) {

        String shortCode = generateShortCode();

        UrlMapping mapping = new UrlMapping();
        mapping.setShortCode(shortCode);
        mapping.setOriginalUrl(originalUrl);

        urlRepository.save(mapping);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {

        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"))
                .getOriginalUrl();
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0,6);
    }
}
