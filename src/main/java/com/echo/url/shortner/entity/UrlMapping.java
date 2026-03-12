package com.echo.url.shortner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "url_mapping")
@Getter
@Setter
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String shortCode;

    @Column(length = 2048)
    private String originalUrl;
}
