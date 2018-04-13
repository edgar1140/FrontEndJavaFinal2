package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.Repositories.SiteUsersRepository;
import com.example.JavaFinalBackend.core.Login;
import com.example.JavaFinalBackend.core.SiteUser;
import com.example.JavaFinalBackend.dto.LoginRequest;
import com.example.JavaFinalBackend.dto.LoginResponse;
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
    public LoginResponse login(@RequestBody LoginRequest r) throws SQLException {
//        System.out.println(r.username);
        String hashedPassword = BCrypt.hashpw(r.password, salt);
//        System.out.println(hashedPassword);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sessionKey = "";
        Random random = new Random();
        int randomLen = 12 + random.nextInt(9);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            sessionKey += c;
        }
        SiteUser newsiteUser = SiteUsersRepository.issiteUsers(sessionKey,r.username,hashedPassword);
        if (newsiteUser != null) {
            return new LoginResponse(sessionKey);
        } else {
            System.out.println("JSON IS WRONG");
            return null;
        }
    }
}
