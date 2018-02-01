package com.eci.cosw.springbootsecureapi.model;

public class Todo {

    private String description;
    private int priority = 1;
    private boolean completed = false;

    public Todo(String description, int priority, boolean completed){
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }
}
