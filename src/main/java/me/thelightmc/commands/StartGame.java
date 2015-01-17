package me.thelightmc.commands;

import me.thelightmc.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class StartGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        GameManager.getInstance().getGame(1).addPlayer((Player)commandSender);
        GameManager.getInstance().getGame(1).startGame();
        for (UUID p : GameManager.getInstance().getGame(1).getPlayers()) {
            Bukkit.getLogger().info(Bukkit.getOfflinePlayer(p).getName());
        }
        return true;
    }
}
