package com.cosine.mariadb;

import org.bukkit.plugin.java.JavaPlugin;

public final class MariaDB extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
        getCommand("1").setExecutor(new Command());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private static MariaDB instance;
    public MariaDB() {instance = this;}
    public static MariaDB getInstance() {return instance;}
}
