package me.frostwolf74.fwcommands.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getPlayer;

public class ReadInventory implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if(strings.length == 0){ // only current player
                player.openInventory(player.getInventory());
            }
            else{ // specified player
                if(player.isOp()) {
                    Player p = getPlayer(strings[0]);
                    if (p == null) {
                        player.sendMessage("Player not found or not online.");
                        return false;
                    }

                    player.openInventory(p.getInventory());
                    p.sendMessage(Component.text(player.name() + " is currently viewing your inventory", TextColor.color(255, 255, 0)));
                }
                else{
                    player.sendMessage("You are not a server operator.");
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}

