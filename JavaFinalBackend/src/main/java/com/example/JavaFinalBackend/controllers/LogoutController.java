package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.dto.LogoutRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @CrossOrigin()
    @DeleteMapping("/logout/{id}")
    public static void logout(@PathVariable int id) {
        LogoutRequest.logout(id);

    }
}
