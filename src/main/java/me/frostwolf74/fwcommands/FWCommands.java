package me.frostwolf74.fwcommands;

import me.frostwolf74.fwcommands.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class FWCommands extends JavaPlugin {
    private static FWCommands instance;

    @Override
    public void onEnable() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        saveResource("config.yml", /* replace */ false);
        saveDefaultConfig();

        instance = this;

        FWCommands.getInstance().getLogger().info("FWCommands has loaded");

        getCommand("home").setExecutor(new HomeCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("enderchest").setExecutor(new EnderchestCommand());
        getCommand("readinventory").setExecutor(new ReadInventory());
        getCommand("pause").setExecutor(new PauseCommand());
    }

    @Override
    public void onDisable() {
        FWCommands.getInstance().getLogger().info("FWCommands has been unloaded");
    }

    public static FWCommands getInstance(){
        return instance;
    }
}
