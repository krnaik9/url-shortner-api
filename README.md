# URL Shortener - Spring Boot

A simple URL shortening service built using Spring Boot and MySQL.

## Features

- Create short URL
- Redirect to original URL
- MySQL persistence
- REST API

## API

POST /shorten

Body:
{
  "url": "https://google.com"
}

GET /{shortCode}

Redirects to original URL.
