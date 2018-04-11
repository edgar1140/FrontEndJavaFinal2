package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.Repositories.siteUsersRepositories;
import com.example.JavaFinalBackend.core.Signup;
import com.example.JavaFinalBackend.core.siteUsers;
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
    public Signup Signup(@RequestBody Signup newsiteUsers) {
        String hashedPassword = BCrypt.hashpw(newsiteUsers.password, salt);

        String sessionKey = createSessionKey();

        siteUsers newuser = siteUsersRepositories.insertsiteUsers(
                newsiteUsers.name,
                hashedPassword,
                sessionKey);

        if (newsiteUsers != null) {
            return newsiteUsers;
        } else {
            System.out.println("sorry please try again");
            return null;
        }
    }
}