package com.tw1stedrain.garyMedia.models;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Nullable
    private int yearsRunStart;
    @Nullable
    private int yearsRunEnd;

    @Column(columnDefinition = "TEXT")
    private String coverArt;

    @Nullable
    private String imdbUrl;

    @OneToMany
    private Set<Movie> movies;

    @OneToMany
    private Set<TvSeason> tvSeasons;


    // **************************************************
    // Constructors
    // **************************************************

    public Series(){}

    public Series(String name, int yearsRunStart, int yearsRunEnd, String coverArt, String imdbUrl) {
        this.name = name;
        this.yearsRunStart = yearsRunStart;
        this.yearsRunEnd = yearsRunEnd;
        this.coverArt = coverArt;
        this.imdbUrl = imdbUrl;
    }

    // **************************************************
    // Getters and Setters
    // **************************************************

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsRunStart() {
        return yearsRunStart;
    }

    public void setYearsRunStart(int yearsRunStart) {
        this.yearsRunStart = yearsRunStart;
    }

    public int getYearsRunEnd() {
        return yearsRunEnd;
    }

    public void setYearsRunEnd(int yearsRunEnd) {
        this.yearsRunEnd = yearsRunEnd;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        if (movies.contains(movie)){
            movies.remove(movie);
        }
    }

    public Set<TvSeason> getTvSeasons() {
        return tvSeasons;
    }

    public void setTvSeasons(Set<TvSeason> tvSeasons) {
        this.tvSeasons = tvSeasons;
    }

    public void addSeason(TvSeason season){
        tvSeasons.add(season);
    }

    public void removeSeason(TvSeason season){
        if (tvSeasons.contains(season)){
            tvSeasons.remove(season);
        }
    }

}
