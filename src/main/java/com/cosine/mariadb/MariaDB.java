package com.cosine.mariadb;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MariaDB extends JavaPlugin {

    private Config config;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
        getCommand("1").setExecutor(new Command());
        getCommand("2").setExecutor(new Command2());

        config = new Config(this, "test");

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
