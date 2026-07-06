package com.zubova.module1.multithreading.practice.tinyurl;

public interface UrlShortener {
    String encode(String longUrl);

    String decode(String tinyUrl);

}