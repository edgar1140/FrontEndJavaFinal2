package com.example.JavaFinalBackend.dto;

import com.example.JavaFinalBackend.core.SiteUser;
import com.example.JavaFinalBackend.db.GetConnect;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteUserInformationRequest {
    public static SiteUser getAccountInformation(String sessionKey) {
        SiteUser userInformation = null;
        try {
            GetConnect connection = new GetConnect();
            Connection conn = connection.get();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM siteUsers WHERE sessionKey = ?");
            st.setString(1, sessionKey);
            ResultSet rs = st.executeQuery();
            rs.next();
            return new SiteUser(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("sessionKey"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInformation;
    }
}
