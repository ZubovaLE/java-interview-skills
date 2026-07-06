package com.zubova.module1.multithreading.practice.tinyurl;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Base62HashGenerator implements HashGenerator {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int HASH_LENGTH = 7;

    @Override
    public String generate(String input, int attempt) {
        String salted = attempt == 0 ? input : input + "#" + attempt;
        byte[] digest = sha256(salted);
        long value = ByteBuffer.wrap(digest, 0, Long.BYTES).getLong() & Long.MAX_VALUE;
        return toBase62(value, HASH_LENGTH);
    }

    private byte[] sha256(String value) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }

    private String toBase62(long value, int length) {
        StringBuilder sb = new StringBuilder(length);
        long n = value;
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt((int) (n % ALPHABET.length())));
            n /= ALPHABET.length();
        }
        return sb.reverse().toString();
    }

}