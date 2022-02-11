package com.springboot.sample.model;

import java.util.Date;

public class Topic implements Cloneable{

    //@JsonIgnore
    private int id;
    private String name;
    private Date start;
    private Date end;
    private float duration;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Topic t = new Topic();
        t.setId(this.getId());
        t.setName(this.getName());
        t.setStart(this.getStart());
        t.setEnd(this.getEnd());
        t.setDuration(this.getDuration());
        return t;
    }
}
