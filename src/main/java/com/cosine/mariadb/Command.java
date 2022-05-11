package com.cosine.mariadb;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Command implements CommandExecutor {

    FileConfiguration config = MariaDB.getInstance().getConfig();

    final String ip = config.getString("MySQL.주소");
    final String id = config.getString("MySQL.아이디");
    final String password = config.getString("MySQL.비밀번호");

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player player = (Player) sender;
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(this::check);
        service.submit(this::check2);
        service.shutdown();
        return false;
    }
    public void check() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + ip + "/test";
            connection = DriverManager.getConnection(url, id, password);

            String sql2 = "select * from test2";
            pstmt = connection.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Bukkit.getLogger().info("1:" + rs.getString(1));
                Bukkit.getLogger().info("2:" + rs.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) connection.close();
                if (pstmt != null && !pstmt.isClosed()) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void check2() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + ip + "/test";
            connection = DriverManager.getConnection(url, id, password);

            String sql2 = "select * from test2";
            pstmt = connection.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Bukkit.getLogger().info("3:" + rs.getString(1));
                Bukkit.getLogger().info("4:" + rs.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) connection.close();
                if (pstmt != null && !pstmt.isClosed()) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
