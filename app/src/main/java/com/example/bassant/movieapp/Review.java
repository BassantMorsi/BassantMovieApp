package com.example.bassant.movieapp;

/**
 * Created by Bassant on 11/27/2016.
 */

public class Review {
    private String author ;
    private String content;
    public void Review(){}

    public void set(String a ,String c)
    {
        author = a;
        content = c;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
