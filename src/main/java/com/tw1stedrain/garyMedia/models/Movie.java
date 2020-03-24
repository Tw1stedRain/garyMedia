package com.tw1stedrain.garyMedia.models;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String coverArt;  // form set to take in URL

    @Nullable
    private int durationInMinutes;
    @Nullable
    private int releaseDate;
    @Nullable
    private String dvdOrBluRay;
    @Nullable
    private String genre;
    @Nullable
    private String rating;
    @Nullable
    private String imdbLink; // form set to take in URL
    @Nullable
    private double rottenTomatoes;
    private boolean loaned = false;
    private String loanedTo;
    private boolean ownerChanged = false;
    private String newOwner;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> movieActors;


    // **************************************************
    // Constructors
    // **************************************************

    public Movie(){}

    public Movie(String title, String coverArt, int duration, int releaseDate, String dvdOrBluRay, String genre, String rating, String imdb, double tomatoes){
        this.title = title;
        this.coverArt = coverArt;
        this.durationInMinutes = duration;
        this.releaseDate = releaseDate;
        this.dvdOrBluRay = dvdOrBluRay;
        this.genre = genre;
        this.rating = rating;
        this.imdbLink = imdb;
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

    public String getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }

    public boolean isOwnerChanged() {
        return ownerChanged;
    }

    public void setOwnerChanged(boolean ownerChanged) {
        this.ownerChanged = ownerChanged;
    }

    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }

    public Set<Actor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(Set<Actor> movieActors) {
        this.movieActors = movieActors;
    }

    public void addMovieActor(Actor actor){
        movieActors.add(actor);
    }

    public void removeMovieActor(Actor movieActor){
        if (movieActors.contains(movieActor)){
            movieActors.remove(movieActor);
        }
    }
}
