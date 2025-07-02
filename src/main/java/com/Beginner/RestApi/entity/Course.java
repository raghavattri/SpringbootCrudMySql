package com.Beginner.RestApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private long id; // Primary key
    private String name;
    private String description;

    // Constructor with parameters
    public Course(String description, String name, long id) {
        super();
        this.description = description;
        this.name = name;
        this.id = id;
    }

    // Default constructor
    public Course() {
        super();
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}