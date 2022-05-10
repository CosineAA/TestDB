package com.cosine.mariadb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;

public class Event implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/test";
            connection = DriverManager.getConnection(url, "root", "qlalfqjsgh");

            String sql2 = "select * from test2";
            pstmt = connection.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                if(rs.getString("uuid").equals(player.getUniqueId().toString())) {
                    MariaDB.getPlugin(MariaDB.class).getServer().getLogger().info("이미 존재하는 UUID");
                    return;
                }
            }

            String sql = "INSERT INTO test2 VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, player.getUniqueId().toString());
            pstmt.setString(2, player.getName());

            int count = pstmt.executeUpdate();
            if(count == 0) {
                MariaDB.getPlugin(MariaDB.class).getServer().getLogger().info("데이터 삽입 실패");
            } else {
                MariaDB.getPlugin(MariaDB.class).getServer().getLogger().info("데이터 삽입 성공");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
