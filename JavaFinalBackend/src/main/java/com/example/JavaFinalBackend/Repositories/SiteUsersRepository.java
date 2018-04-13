package com.example.JavaFinalBackend.Repositories;

import com.example.JavaFinalBackend.core.SiteUser;
import com.example.JavaFinalBackend.db.GetConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SiteUsersRepository {

    public static ArrayList<SiteUser> allsiteUsers() {

        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM siteUsers");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<SiteUser> allsiteUsers = new ArrayList<SiteUser>();
            while (resultSet.next()) {
                allsiteUsers.add(new
                        SiteUser(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("sessionKey")));
            }
            conn.close();
            return allsiteUsers;
        } catch (
                SQLException e)

        {
            return null;
        }
    }

    public static SiteUser insertsiteUsers(String name, String passwordHash, String sessionKey) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO siteUsers(name, password, sessionKey) VALUES (?, ?, ?) RETURNING *");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passwordHash);
            preparedStatement.setString(3, sessionKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new SiteUser(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("sessionKey"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static SiteUser deleteSessionKey(Integer id) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE siteUsers SET sessionKey = null WHERE id = ? RETURNING *");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new
                    SiteUser(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("sessionKey"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static SiteUser issiteUsers(String sessionKey, String name, String password) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE siteUsers SET sessionKey = ? WHERE name = ? AND password = ? RETURNING *");
            System.out.println(sessionKey);
            System.out.println(name);
            System.out.println(password);
            preparedStatement.setString(1, sessionKey);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            SiteUser siteuser = new SiteUser(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("sessionKey")
            );
            return siteuser;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static boolean deletesiteUsers(Integer id) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM siteUsers WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




