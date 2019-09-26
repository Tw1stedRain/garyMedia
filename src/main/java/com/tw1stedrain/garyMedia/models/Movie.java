package com.tw1stedrain.garyMedia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String coverArt;
    private int durationInMinutes;
    private int releaseDate;
    private List<String> actors;
    private String dvdOrBluRay;
    private String genre;
    private String rating;
    private String imdbLink;
    private double rottenTomatoes;
    private boolean loaned;

    // TODO: many to one series

    // **************************************************
    // Constructors
    // **************************************************

    public Movie(){}

    public Movie(String title, String coverArt, int durration, int releaseDate, List actors, String dvdOrBluRay, String genre, String rating, String indb, double tomatoes){
        this.title = title;
        this.coverArt = coverArt;
        this.durationInMinutes = durration;
        this.releaseDate = releaseDate;
        this.actors = actors;
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

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
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
