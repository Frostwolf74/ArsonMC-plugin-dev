package me.frostwolf74.fwcommands.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            try{
                player.teleport(player.getServer().getWorld("world").getSpawnLocation());
            } catch (NullPointerException None) {
                player.sendMessage("Spawn is null");
            }

            return true;
        }
        return false;
    }
}
