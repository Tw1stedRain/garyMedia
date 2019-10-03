package com.tw1stedrain.garyMedia.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int activeYearsStart;
    private int activeYearsEnd;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    private String imdbUrl;
    private boolean dead = false;
    private int yearDead;

    @ManyToMany(mappedBy = "movieActors")
    private List<Movie> movies;

    @ManyToMany(mappedBy = "tvActors")
    private List<TvSeason> tvSeasons;

    //TODO: implement many to many to the show/movie

    // **************************************************
    // Constructors
    // **************************************************

    public Actor(){}

    public Actor(String firstName, String lastName, int activeYearsStart, int activeYearsEnd, String imageUrl, String imdbUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeYearsStart = activeYearsStart;
        this.activeYearsEnd = activeYearsEnd;
        this.imageUrl = imageUrl;
        this.imdbUrl =imdbUrl;
    }

    // **************************************************
    // Getters and Setters
    // **************************************************

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActiveYearsStart() {
        return activeYearsStart;
    }

    public void setActiveYearsStart(int activeYearsStart) {
        this.activeYearsStart = activeYearsStart;
    }

    public int getActiveYearsEnd() {
        return activeYearsEnd;
    }

    public void setActiveYearsEnd(int getActiveYearsEnd) {
        this.activeYearsEnd = getActiveYearsEnd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getYearDead() {
        return yearDead;
    }

    public void setYearDead(int yearDead) {
        this.yearDead = yearDead;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<TvSeason> getTvSeasons() {
        return tvSeasons;
    }

    public void setTvSeasons(List<TvSeason> tvSeasons) {
        this.tvSeasons = tvSeasons;
    }
}
