package com.tw1stedrain.garyMedia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    //TODO: implement many to many to the show/movie

    // **************************************************
    // Constructors
    // **************************************************

    public Actor(){}

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.firstName = lastName;
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
}
