package com.zubova.module1.finalTopic;

public class Book {

    private static int booksCounter;
    final String author;

    public Book(String author) {
        this.author = author;
        booksCounter++;
    }

}