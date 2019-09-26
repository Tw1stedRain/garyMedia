package com.tw1stedrain.garyMedia.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    //TODO: make able to take longer lengths
    private String coverArt;  // form set to take in URL


    private int durationInMinutes;
    private int releaseDate;
    private String dvdOrBluRay;
    private String genre;
    private String rating;
    private String imdbLink; // form set to take in URL
    private double rottenTomatoes;
    private boolean loaned;

    //TODO: implement actors
//    @ManyToMany
//    private List<Actor> actors;

    // TODO: many to one series

    // **************************************************
    // Constructors
    // **************************************************

    public Movie(){}

    public Movie(String title, String coverArt, int durration, int releaseDate, String dvdOrBluRay, String genre, String rating, String indb, double tomatoes){
        this.title = title;
        this.coverArt = coverArt;
        this.durationInMinutes = durration;
        this.releaseDate = releaseDate;
        this.dvdOrBluRay = dvdOrBluRay;
        this.genre = genre;
        this.rating = rating;
        this.imdbLink = indb;
        this.rottenTomatoes = tomatoes;

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

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDvdOrBluRay() {
        return dvdOrBluRay;
    }

    public void setDvdOrBluRay(String dvdOrBluRay) {
        this.dvdOrBluRay = dvdOrBluRay;
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

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
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
