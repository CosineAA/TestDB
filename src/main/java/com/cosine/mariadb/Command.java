package com.cosine.mariadb;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.*;
import java.util.Random;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/test";
            connection = DriverManager.getConnection(url, "root", "qlalfqjsgh");

//            String sql = "INSERT INTO test2 VALUES (?, ?, ?)";
//            pstmt = connection.prepareStatement(sql);
//
//            Random random = new Random();
//
//            pstmt.setInt(1, random.nextInt());
//            pstmt.setString(2, "테스트임임");
//            pstmt.setDouble(3, 1.2);
//
//            int count = pstmt.executeUpdate();
//            if(count == 0) {
//                sender.sendMessage("데이터 삽입 실패");
//                return false;
//            }
//            sender.sendMessage("데이터 삽입 성공");
            String sql2 = "select * from test2";
            pstmt = connection.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt("int") == 1) {
                    sender.sendMessage("숫자:" + rs.getInt("int"));
                    sender.sendMessage("이름:" + rs.getString("string"));
                    sender.sendMessage("더블:" + rs.getDouble("double"));
                } else {
                    sender.sendMessage("값 없음");
                    break;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null && !connection.isClosed()) connection.close();
                if(pstmt != null && !pstmt.isClosed()) pstmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
