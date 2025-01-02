package me.frostwolf74.fwcommands.commands;

import me.frostwolf74.fwcommands.FWCommands;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player){
            FileConfiguration config = FWCommands.getInstance().getConfig();

            String world = config.getString("homes." + player.getUniqueId() + ".world");

            double PosX = config.getDouble("homes." + player.getUniqueId() + ".BlockX");
            double PosY = config.getDouble("homes." + player.getUniqueId() + ".BlockY");
            double PosZ = config.getDouble("homes." + player.getUniqueId() + ".BlockZ");

            if(world == null){
                player.sendMessage("You do not have any saved homes, save one with /sethome.");
                return false;
            }

            Location location = new Location(Bukkit.getWorld(world), PosX, PosY, PosZ);
            player.teleport(location);
            return true;
        }
        return false;
    }
}
