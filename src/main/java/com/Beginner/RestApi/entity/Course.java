package com.Beginner.RestApi.entity;

public class Course {
    private long id; // Made private for encapsulation
    private String name; // Made private for encapsulation
    private String description; // Made private for encapsulation

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

    // Optional: Setter for id (if deserialization is needed)
    public void setId(long id) {
        this.id = id;
    }

    // Optional: Setter for name (if deserialization is needed)
    public void setName(String name) {
        this.name = name;
    }

    // Optional: Setter for description (if deserialization is needed)
    public void setDescription(String description) {
        this.description = description;
    }
}