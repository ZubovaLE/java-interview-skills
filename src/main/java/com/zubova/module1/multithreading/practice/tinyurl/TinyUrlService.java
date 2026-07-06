package com.zubova.module1.multithreading.practice.tinyurl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TinyUrlService implements UrlShortener {

    private static final int MAX_COLLISION_ATTEMPTS = 20;
    private final String baseUrl;
    private final HashGenerator hashGenerator;
    private final ConcurrentMap<String, String> hashToUrl = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, String> urlToHash = new ConcurrentHashMap<>();

    public TinyUrlService(String baseUrl, HashGenerator hashGenerator) {
        this.baseUrl = normalize(Objects.requireNonNull(baseUrl, "baseUrl must not be null"));
        this.hashGenerator = Objects.requireNonNull(hashGenerator, "hashGenerator must not be null");
    }

    @Override
    public String encode(String longUrl) {
        validate(longUrl);
        String hash = urlToHash.computeIfAbsent(longUrl, this::reserveHash);
        return baseUrl + hash;
    }

    @Override
    public String decode(String tinyUrl) {
        Objects.requireNonNull(tinyUrl, "tinyUrl must not be null");
        if (!tinyUrl.startsWith(baseUrl)) {
            throw new InvalidUrlException("Tiny URL does not match expected base: " + baseUrl);
        }
        String hash = tinyUrl.substring(baseUrl.length());
        String originalUrl = hashToUrl.get(hash);
        if (originalUrl == null) {
            throw new UnknownTinyUrlException("No URL registered for: " + tinyUrl);
        }
        return originalUrl;
    }

    private String normalize(String base) {
        return base.endsWith("/") ? base : base + "/";
    }

    private void validate(String longUrl) {
        if (longUrl == null || longUrl.isBlank()) {
            throw new InvalidUrlException("URL must not be null or blank");
        }
        try {
            new URI(longUrl);
        } catch (URISyntaxException e) {
            throw new InvalidUrlException("URL is not a syntactically valid URI: " + longUrl, e);
        }
    }

    private String reserveHash(String longUrl) {
        for (int attempt = 0; attempt < MAX_COLLISION_ATTEMPTS; attempt++) {
            String candidate = hashGenerator.generate(longUrl, attempt);
            if (hashToUrl.putIfAbsent(candidate, longUrl) == null) {
                return candidate;
            }
        }
        throw new HashSpaceExhaustedException("Could not find a free hash after " + MAX_COLLISION_ATTEMPTS + " attempts");
    }

}