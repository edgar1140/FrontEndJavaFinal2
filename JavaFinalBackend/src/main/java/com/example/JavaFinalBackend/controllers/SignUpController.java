package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.Repositories.SiteUsersRepository;
import com.example.JavaFinalBackend.core.SiteUser;
import com.example.JavaFinalBackend.dto.SignUpRequest;
import com.example.JavaFinalBackend.dto.SignUpResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class SignUpController {

    @Value("${app.salt}")
    private String salt;

    String createSessionKey() {
        String alphabet= "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*();[]{}\\|,./<>?`~-=_+";
        String sessionKey = "";
        Random random = new Random();
        int randomLen = 11+random.nextInt(7);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            sessionKey+=c;
        }
        return sessionKey;
    }

    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PostMapping("/signup")
    public SignUpResponse Signup(@RequestBody SignUpRequest r) {
//        System.out.println(r.username);
        String hashedPassword = BCrypt.hashpw(r.password, salt);
        String sessionKey = createSessionKey();
        SiteUser newuser = SiteUsersRepository.insertsiteUsers(
                r.username,
                hashedPassword,
                sessionKey);
        if (newuser != null) {
            return new SignUpResponse(sessionKey);
        } else {
            return null;
        }
    }
}