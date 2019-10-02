package com.tw1stedrain.garyMedia.models;

import javax.persistence.*;

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
}
