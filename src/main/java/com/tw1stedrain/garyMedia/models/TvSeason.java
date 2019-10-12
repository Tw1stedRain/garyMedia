package com.tw1stedrain.garyMedia.models;


import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.Set;

@Entity
public class TvSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String coverArt;

    @Nullable
    private int numOfEpisodes;
    @Nullable
    private String genre;
    @Nullable
    private String rating;
    @Nullable
    private String dvdOrBluRay;
    @Nullable
    private int releaseDate;
    @Nullable
    private String imdbLink;
    @Nullable
    private double rottenTomatoes;
    private boolean loaned = false;
    private String loanedTo;

    @ManyToMany
    @JoinTable(
            name = "tv_actors",
            joinColumns = @JoinColumn(name = "tv_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> tvActors;

    // **************************************************
    // Constructors
    // **************************************************

    public TvSeason(){}

    public TvSeason(String title, String coverArt, int numOfEpisodes, String genre, String rating, int releaseDate, String imdbLink, double rottenTomatoes){
        this.title = title;
        this.coverArt = coverArt;
        this.numOfEpisodes = numOfEpisodes;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.imdbLink = imdbLink;
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

    public String getDvdOrBluRay() {
        return dvdOrBluRay;
    }

    public void setDvdOrBluRay(String dvdOrBluRay) {
        this.dvdOrBluRay = dvdOrBluRay;
    }

    public Set<Actor> getTvActors() {
        return tvActors;
    }

    public void setTvActors(Set<Actor> tvActors) {
        this.tvActors = tvActors;
    }

    public void addTvActor(Actor tvActor){
        tvActors.add(tvActor);
    }

    public void removeTvActor(Actor tvActor){
        if (tvActors.contains(tvActor)) {
            tvActors.remove(tvActor);
        }
    }
}
