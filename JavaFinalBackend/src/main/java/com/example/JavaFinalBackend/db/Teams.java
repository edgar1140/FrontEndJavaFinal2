package com.example.JavaFinalBackend.db;

import com.example.JavaFinalBackend.core.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Teams {
    ///    GETS THE CONNECTION
    private static Connection connect() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql:main", "basecamp", "pgpass");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }

    ////    GETTING ALL THE TEAMS
    public static List<Team> all() {
        try {
            Connection c = connect();
            PreparedStatement st = c.prepareStatement("SELECT * FROM Teams;");
            ResultSet rs = st.executeQuery();
            ArrayList<Team> allTeams = new ArrayList<Team>();
            while (rs.next()) {
                allTeams.add(new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("img_url")

                ));
            }
            return allTeams;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }

    }

}

