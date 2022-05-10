package com.cosine.mariadb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

public class Command2 implements CommandExecutor {

    ConfigurationSection config = MariaDB.getInstance().getCustomConfig("test");
    ConfigurationSection config2 = MariaDB.getInstance().getCustomConfig("cos");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(String.valueOf(config.getInt("1.2.3")));
        sender.sendMessage(config2.getString("1"));
        config.set("아", "테스트");
        MariaDB.getInstance().saveCustomConfig("test");
        config2.set("1.아.야", "테스트22");
        MariaDB.getInstance().saveCustomConfig("test2");
        return false;
    }
}
