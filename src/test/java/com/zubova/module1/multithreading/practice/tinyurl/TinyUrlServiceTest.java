package com.zubova.module1.multithreading.practice.tinyurl;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TinyUrlServiceTest {

    private static final String BASE_URL = "http://tiny.url/";

    @Test
    void encode_returnsUrlWithBaseAndSevenCharHash() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());

        String tinyUrl = tinyUrlService.encode("https://example.com/very/long/path");

        assertTrue(tinyUrl.startsWith(BASE_URL));
        assertEquals(7, tinyUrl.substring(BASE_URL.length()).length());
    }

    @Test
    void encode_isIdempotent_forSameUrl() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());
        String longUrl = "https://example.com/page";

        assertEquals(tinyUrlService.encode(longUrl), tinyUrlService.encode(longUrl));
    }

    @Test
    void decode_returnsOriginalUrl_afterEncode() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());
        String longUrl = "https://example.com/page";

        String tinyUrl = tinyUrlService.encode(longUrl);

        assertEquals(longUrl, tinyUrlService.decode(tinyUrl));
    }

    @Test
    void decode_throwsException_forUnknownTinyUrl() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());

        assertThrows(UnknownTinyUrlException.class, () -> tinyUrlService.decode(BASE_URL + "zzzzzzz"));
    }

    @Test
    void decode_throwsException_forWrongBaseUrl() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());

        assertThrows(InvalidUrlException.class, () -> tinyUrlService.decode("http://other.base/abc1234"));
    }

    @Test
    void encode_throwsException_forNullOrBlankUrl() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());

        assertThrows(InvalidUrlException.class, () -> tinyUrlService.encode(null));
        assertThrows(InvalidUrlException.class, () -> tinyUrlService.encode("   "));
    }

    @Test
    void encode_throwsException_forMalformedUrl() {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());

        assertThrows(InvalidUrlException.class, () -> tinyUrlService.encode("ht!tp://bad uri"));
    }

    @Test
    void encode_resolvesCollision_viaOpenAddressing() {
        HashGenerator colliding = (input, attempt) -> attempt == 0 ? "AAAAAAA" : "BBBBBBB" + attempt;
        var tinyUrlService = new TinyUrlService(BASE_URL, colliding);

        String tiny1 = tinyUrlService.encode("https://example.com/first");
        String tiny2 = tinyUrlService.encode("https://example.com/second");

        assertNotEquals(tiny1, tiny2);
        assertEquals("https://example.com/first", tinyUrlService.decode(tiny1));
        assertEquals("https://example.com/second", tinyUrlService.decode(tiny2));
    }

    @Test
    void encode_throwsHashSpaceExhausted_whenGeneratorAlwaysCollides() {
        HashGenerator alwaysSame = (input, attempt) -> "SAME000";
        var tinyUrlService = new TinyUrlService(BASE_URL, alwaysSame);
        tinyUrlService.encode("https://example.com/first");

        assertThrows(HashSpaceExhaustedException.class,
                () -> tinyUrlService.encode("https://example.com/second"));
    }

    @Test
    void encode_isThreadSafe_forConcurrentCallsWithSameUrl() throws Exception {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());
        String longUrl = "https://example.com/concurrent";
        int threads = 50;
        Set<String> distinct = new HashSet<>();
        try (ExecutorService executor = Executors.newFixedThreadPool(threads)) {
            CountDownLatch start = new CountDownLatch(1);
            List<Future<String>> results = IntStream.range(0, threads)
                    .mapToObj(i -> executor.submit(() -> {
                        start.await();
                        return tinyUrlService.encode(longUrl);
                    }))
                    .toList();
            start.countDown();

            for (Future<String> result : results) {
                distinct.add(result.get());
            }
        }

        assertEquals(1, distinct.size());
    }

    @Test
    void encode_isThreadSafe_forConcurrentCallsWithDifferentUrls() throws Exception {
        var tinyUrlService = new TinyUrlService(BASE_URL, new Sha256Base62HashGenerator());
        int urlCount = 100;
        Set<String> distinct = new HashSet<>();
        try (ExecutorService executor = Executors.newFixedThreadPool(20)) {
            CountDownLatch start = new CountDownLatch(1);
            List<Future<String>> results = IntStream.range(0, urlCount)
                    .mapToObj(i -> {
                        String url = "https://example.com/" + i;
                        return executor.submit(() -> {
                            start.await();
                            return tinyUrlService.encode(url);
                        });
                    })
                    .toList();
            start.countDown();
            for (Future<String> f : results) {
                distinct.add(f.get());
            }
        }

        assertEquals(urlCount, distinct.size());
    }

}