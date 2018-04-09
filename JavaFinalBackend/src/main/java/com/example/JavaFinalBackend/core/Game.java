package com.example.JavaFinalBackend.core;

public class Game {
    public Integer home_id;
    public Integer home_score;
    public Integer away_id;
    public Integer away_score;

    public Game() {}

    public Game(Integer home_id,
                Integer home_score,
                Integer away_id,
                Integer away_score) {

        this.home_id = home_id;
        this.home_score = home_score;
        this.away_id = away_id;
        this.away_score = away_score;
    }

}
