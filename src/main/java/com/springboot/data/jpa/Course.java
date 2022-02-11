package com.springboot.data.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

    //@JsonIgnore
    @Id
    private int id;
    private String name;
    private String duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
