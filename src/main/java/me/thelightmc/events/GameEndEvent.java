package me.thelightmc.events;

import me.thelightmc.Game;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEndEvent extends Event implements Cancellable {
    private final Game game;

    public GameEndEvent(Game game) {

        this.game = game;
    }
    boolean cancelled = false;
    private final HandlerList handlers = new HandlerList();

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Game getGame() {
        return game;
    }
}
