package com.example.JavaFinalBackend.core;

public class Game {
    public Integer home_id;
    public String home_team;
    public Integer home_score;
    public String home_img_url;
    public Integer away_id;
    public String away_team;
    public Integer away_score;
    public String away_img_url;

    public Game() {}

    public Game(Integer home_id,
                String home_team,
                Integer home_score,
                String home_img_url,
                Integer away_id,
                String away_team,
                Integer away_score,
                String away_img_url) {

        this.home_id = home_id;
        this.home_team = home_team;
        this.home_score = home_score;
        this.home_img_url = home_img_url;
        this.away_id = away_id;
        this.away_team = away_team;
        this.away_score = away_score;
        this.away_img_url = away_img_url;
    }

}
