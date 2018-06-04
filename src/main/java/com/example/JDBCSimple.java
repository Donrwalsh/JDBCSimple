package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSimple {

    public static void main(String args[]) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/mtg?serverTimezone=UTC&useLegacyDatetimeCode=true&useSSL=false",
                "root",
                "Pack my box with five dozen liquor jugs"
        );

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cards LIMIT 10");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        System.out.println("How's it going, world?");
    }

}

