package com.example.JavaFinalBackend.Repositories;

import com.example.JavaFinalBackend.core.siteUsers;
import com.example.JavaFinalBackend.db.GetConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class siteUsersRepositories {

    public static ArrayList<siteUsers> allsiteUsers() {

        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM siteUsers");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<siteUsers> allsiteUsers = new ArrayList<siteUsers>();
            while (resultSet.next()) {
                allsiteUsers.add(new
                        siteUsers(resultSet.getInt("id"),
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

    public static siteUsers insertsiteUsers(String name, String password, String sessionKey) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO siteUsers (" +
                            "name, password, sessionKey) " +
                            "VALUES (?,?,?)" +
                            "RETURNING id");
            preparedStatement.setString(1, name);
            preparedStatement.setString(4, password);
            preparedStatement.setString(6, sessionKey);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new siteUsers(resultSet.getInt("id"), name, password, sessionKey);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static siteUsers deleteSessionKey(Integer id) {
        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE siteUsers SET sessionKey = null WHERE id = ? RETURNING *");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new
                    siteUsers(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("sessionKey"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static siteUsers issiteUsers(String sessionKey, String name, String password) {

        try {
            Connection conn = GetConnect.get();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE siteUsers SET sessionKey = ? WHERE name = ? and password = ? returning *"
            );
            preparedStatement.setString(1, sessionKey);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new siteUsers(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("sessionKey"));

        } catch (SQLException e) {
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




