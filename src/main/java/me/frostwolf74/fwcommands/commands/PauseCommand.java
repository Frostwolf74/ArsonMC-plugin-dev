package me.frostwolf74.fwcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static java.lang.Thread.sleep;

public class PauseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender.isOp()){
            try {
                commandSender.sendMessage("Pausing for " + strings[0] + " seconds");
                sleep(Integer.parseInt(strings[0]) * 1000L);
                commandSender.sendMessage("Done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
