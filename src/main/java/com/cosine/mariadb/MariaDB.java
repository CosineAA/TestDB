package com.cosine.mariadb;

import org.bukkit.plugin.java.JavaPlugin;

public final class MariaDB extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("1").setExecutor(new Command());
        new Event();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
