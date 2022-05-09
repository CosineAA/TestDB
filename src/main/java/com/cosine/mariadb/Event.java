package com.cosine.mariadb;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;

public class Event implements Listener {

    @EventHandler
    public void onChat(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }
}
