package com.cosine.mariadb;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MariaDB extends JavaPlugin {

    private Config config;
    private Config config2;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
        getCommand("1").setExecutor(new Command());
        getCommand("2").setExecutor(new Command2(this));

        config = new Config(this, "test.yml");
        config.saveDefaultConfig();

        config2 = new Config(this, "cos.yml");
        config2.saveDefaultConfig();

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }
    private static MariaDB instance;
    public MariaDB() {instance = this;}
    public static MariaDB getInstance() {return instance;}

    public Config get() {
        return this.config;
    }
    public Config get2() {
        return this.config2;
    }
}
