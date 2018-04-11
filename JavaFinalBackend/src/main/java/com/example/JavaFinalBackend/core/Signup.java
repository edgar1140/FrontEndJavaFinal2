package com.example.JavaFinalBackend.core;

public class Signup {
    public String name;
    public String password;
    public String sessionKey;


    public Signup () {

    }

    public Signup (String name, String password, String sessionKey) {
        this.name = name;
        this.password = password;
        this.sessionKey = sessionKey;
    }


}
