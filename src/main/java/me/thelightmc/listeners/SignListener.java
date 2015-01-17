package me.thelightmc.listeners;

import me.thelightmc.game.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK || !(event.getClickedBlock().getState() instanceof Sign)) {
            return;
        }
        Sign sign = (Sign) event.getClickedBlock().getState();
        String s = ChatColor.stripColor(sign.getLine(0));
        if (s == null) {
            return;
        }
        if (s.equalsIgnoreCase("[Join Game]")) {
            GameManager.getInstance().getNextGame().addPlayer(event.getPlayer());
        }
    }
}
