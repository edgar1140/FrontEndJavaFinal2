package com.example.JavaFinalBackend.core;

public class siteUsers {
    public Integer id;
    public static String name;
    public String password;
    public String sessionKey;

    public siteUsers(Integer id, String name, String password, String sessionKey) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.sessionKey = sessionKey;
    }
}
