package com.example.JavaFinalBackend.core;

public class SiteUser {
    public Integer id;
    public String name;
    public String password;
    public String sessionKey;

    public SiteUser(Integer id, String name, String password, String sessionKey) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sessionKey = sessionKey;
    }
}
