package com.cosine.mariadb;

import org.bukkit.configuration.file.FileConfiguration;

import java.sql.*;

public class DataBase {

    FileConfiguration config = MariaDB.getInstance().getConfig();

    final String ip = config.getString("MySQL.주소");
    final String id = config.getString("MySQL.아이디");
    final String password = config.getString("MySQL.비밀번호");

    final String url = "jdbc:mysql://" + ip + "/test";

    public void Create_DataBase(String db) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, id, password);

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

            connection = DriverManager.getConnection(url, id, password);

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
