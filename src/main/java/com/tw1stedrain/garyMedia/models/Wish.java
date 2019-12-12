package com.tw1stedrain.garyMedia.models;


import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String coverArt; // form set to take in URL
    private String imdbLink; // form set to take in URL
    private String tvOrMovie;

    // **************************************************
    // Constructors
    // **************************************************

    public Wish(){}

    public Wish(String title, String coverArt, String imdbLink, String tvOrMovie) {
        this.title = title;
        this.coverArt = coverArt;
        this.imdbLink = imdbLink;
        this.tvOrMovie = tvOrMovie;
    }

    // **************************************************
    // Getters and Setters
    // **************************************************


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    public String getTvOrMovie() {
        return tvOrMovie;
    }

    public void setTvOrMovie(String tvOrMovie) {
        this.tvOrMovie = tvOrMovie;
    }
}
