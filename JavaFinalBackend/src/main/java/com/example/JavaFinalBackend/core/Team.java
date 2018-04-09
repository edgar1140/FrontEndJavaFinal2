package com.example.JavaFinalBackend.core;

public class Team {
    public Integer id;
    public String name;
    public String img_url;

    public Team() {
    }

    public Team(Integer id,
                String name,
                String img_url) {

        this.id = id;
        this.name = name;
        this.img_url = img_url;
    }


}

