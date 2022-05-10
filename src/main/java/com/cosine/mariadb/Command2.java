package com.cosine.mariadb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

public class Command2 implements CommandExecutor {

    MariaDB plugin;

    public Command2(MariaDB plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.get().getConfig().set("테스트", 1);
        plugin.get().saveConfig();
        plugin.get2().getConfig().set("아아", 1029320);
        plugin.get2().saveConfig();
        return false;
    }
}
