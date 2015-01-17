package me.thelightmc.events;

import me.thelightmc.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerGameJoinEvent extends PlayerEvent implements Cancellable {
    private final Game game;

    public PlayerGameJoinEvent(Player who,Game game) {
        super(who);
        this.game = game;
    }
    private boolean cancelled;
    @Override
    public HandlerList getHandlers() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public Game getGame() {
        return game;
    }
}
