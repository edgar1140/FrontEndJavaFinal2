package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.dto.DeleteRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DeleteAccount {
    @CrossOrigin()
    @DeleteMapping("/delete/{id}")
    public static void deleteAccount(@PathVariable int id) {
        DeleteRequest.deleteAccount(id);
    }
}
