package com.tw1stedrain.garyMedia.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int yearsRunStart;
    private int yearsRunEnd;

    @Column(columnDefinition = "TEXT")
    private String coverArt;

    private String imdbUrl;

    @OneToMany
    private Set<Movie> movies;

    @OneToMany
    private Set<TvSeason> tvSeasons;


    //TODO: one to many lists of movies or tv series'
//    private List<String> sequence;

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

    public Set<TvSeason> getTvSeasons() {
        return tvSeasons;
    }

    public void setTvSeasons(Set<TvSeason> tvSeasons) {
        this.tvSeasons = tvSeasons;
    }

//    public List<String> getSequence() {
//        return sequence;
//    }
//
//    public void setSequence(List<String> sequence) {
//        this.sequence = sequence;
//    }
}
