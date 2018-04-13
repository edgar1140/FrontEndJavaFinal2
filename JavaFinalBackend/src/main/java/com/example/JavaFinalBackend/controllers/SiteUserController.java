package com.example.JavaFinalBackend.controllers;

import com.example.JavaFinalBackend.core.SiteUser;
import com.example.JavaFinalBackend.dto.SiteUserInformationRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteUserController {
    @CrossOrigin()
    @GetMapping("/account/{sessionKey}")
    public SiteUser accountInformation(@PathVariable String sessionKey){
        System.out.println(sessionKey);
        return SiteUserInformationRequest.getAccountInformation(sessionKey);
    }
}
