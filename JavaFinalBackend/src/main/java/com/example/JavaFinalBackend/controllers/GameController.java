package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.core.Game;

import com.example.JavaFinalBackend.db.Games;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    @CrossOrigin()
    @GetMapping("/games")
    public List<Game> all() {
        return Games.all();

    }
}
