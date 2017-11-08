package com.example.lili.emptyactivity.BaseDonne;

/**
 * Created by lili on 07/11/2017.
 */

public class Movie {
    private Long id;
    private String title;
    public Movie(String movie) {
        this.title = movie;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
