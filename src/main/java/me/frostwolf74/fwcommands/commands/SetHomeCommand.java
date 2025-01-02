package me.frostwolf74.fwcommands.commands;

import me.frostwolf74.fwcommands.FWCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player){
            FileConfiguration config = FWCommands.getInstance().getConfig();

            FWCommands.getInstance().getLogger().info("Wrote coordinates: " + player.getUniqueId() + "," + player.getWorld().getName() + "," + player.getLocation().getBlockX() + (",") + player.getLocation().getBlockY() + (",") + (Objects.requireNonNull(player.getPlayer())).getLocation().getBlockZ());

            FWCommands.getInstance().getLogger().info("world:" + player.getWorld().getName());
            config.set("homes." + player.getUniqueId() + ".world", player.getWorld().getName());
            config.set("homes." + player.getUniqueId() + ".BlockX", player.getLocation().getX());
            config.set("homes." + player.getUniqueId() + ".BlockY", player.getLocation().getY());
            config.set("homes." + player.getUniqueId() + ".BlockZ", player.getLocation().getZ());

            commandSender.sendMessage("You have successfully set your home");

            FWCommands.getInstance().saveConfig();
            return true;
        }

        return false;
    }
}
