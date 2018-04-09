package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.core.Team;
import com.example.JavaFinalBackend.db.Teams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @CrossOrigin()
    @GetMapping("/teams")
    public List<Team> all() {
        return Teams.all();

    }
}
