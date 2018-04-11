package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.Repositories.siteUsersRepositories;
import com.example.JavaFinalBackend.core.Login;
import com.example.JavaFinalBackend.core.siteUsers;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Random;

@RestController
public class LoginController {
    @Value("${app.salt}")
    private String salt;
    @CrossOrigin()
    @PostMapping("/login")
    public siteUsers login(@RequestBody Login isUser) throws SQLException {
        System.out.println(isUser.name);
        String hashedPassword = BCrypt.hashpw(isUser.password, salt);
        System.out.println(hashedPassword);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sessionKey = "";
        Random random = new Random();
        int randomLen = 12 + random.nextInt(9);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            sessionKey += c;
        }
        siteUsers newsiteUsers = siteUsersRepositories.issiteUsers(sessionKey, isUser.name, hashedPassword);
        if (newsiteUsers != null) {
            return newsiteUsers;
        } else {
            System.out.println("JSON IS WRONG");
            return null;
        }
    }
}
