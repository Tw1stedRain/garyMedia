package com.tw1stedrain.garyMedia.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class TvSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String coverArt;
    private int numOfEpisodes;
    private String genre;
    private String rating;
    private int releaseDate;
    private String indbLink;
    private double rottenTomatoes;
    private boolean loaned;

    //TODO: implement actors
//    @ManyToMany
//    private List<Actor> actors;

    // TODO: many to one series

    // **************************************************
    // Constructors
    // **************************************************

    public TvSeason(){}

    public TvSeason(String title, String coverArt, int numOfEpisodes, String genre, String rating, int releaseDate, String indbLink, double rottenTomatoes){
        this.title = title;
        this.coverArt = coverArt;
        this.numOfEpisodes = numOfEpisodes;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.indbLink = indbLink;
        this.rottenTomatoes = rottenTomatoes;
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

    public int getNumOfEpisodes() {
        return numOfEpisodes;
    }

    public void setNumOfEpisodes(int numOfEpisodes) {
        this.numOfEpisodes = numOfEpisodes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIndbLink() {
        return indbLink;
    }

    public void setIndbLink(String indbLink) {
        this.indbLink = indbLink;
    }

    public double getRottenTomatoes() {
        return rottenTomatoes;
    }

    public void setRottenTomatoes(double rottenTomatoes) {
        this.rottenTomatoes = rottenTomatoes;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }
}
