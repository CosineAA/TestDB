package com.cosine.mariadb;

import java.sql.*;

public class DataBase {
    public void Create_DataBase(String db) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/test";
            connection = DriverManager.getConnection(url, "root", "qlalfqjsgh");

            pstmt = connection.prepareStatement(url);

            String exist = "DROP DATABASE IF EXISTS `" + db + "`;";
            String create = "CREATE DATABASE `" + db + "`";

            pstmt.executeUpdate(exist);
            pstmt.executeUpdate(create);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void Create_Table(String table) {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/cosine";
            connection = DriverManager.getConnection(url, "root", "qlalfqjsgh");

            stmt = connection.createStatement();

            StringBuilder sb = new StringBuilder();
            String create = sb.append("create table if not exists " + table + "(").append("number int,")
                    .append("uuid varchar(100),").append("money int").append(");").toString();
            stmt.execute(create);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
