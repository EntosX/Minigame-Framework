package me.thelightmc;

import me.thelightmc.events.GameEndEvent;
import me.thelightmc.util.Lang;
import me.thelightmc.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class Game {
    private int id;
    private boolean running;
    private boolean joinable;
    private final String game_name;
    public Game(String game_name) {
        this.game_name = game_name;
    }
    public void startGame() {
        registerListeners();
        setRunning(true);
        setJoinable(false);
    }
    public boolean isJoinable() {
        return joinable;
    }
    private ArrayList<UUID> players = new ArrayList<>();

    public List<UUID> getPlayers() {
        return players;
    }


    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        HashMap<Lang.tag,String> hashMap = new HashMap<>();
        hashMap.put(Lang.tag.Game,this.game_name);
        Messages.getInstance().sendMessage(player,Lang.PlayerJoinGame,hashMap);
    }

    public boolean containsPlayer(Player player) {
        return players.contains(player.getUniqueId());
    }
    public abstract Location getSpawnPoint();
    public void endGame() {
        GameEndEvent gameEndEvent = new GameEndEvent(this);
        Bukkit.getPluginManager().callEvent(gameEndEvent);
        if (gameEndEvent.isCancelled()) {
            return;
        }
        setRunning(false);
        Location location = getSpawnPoint().getWorld().getSpawnLocation();
        for (UUID uuid : players) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) {
                Bukkit.getLogger().info(Bukkit.getOfflinePlayer(uuid).getName() + " ===     null");
                continue;
            }
            Bukkit.getLogger().info(player.getName());
            Messages.getInstance().sendMessage(player, Lang.GameForceEnd);
            player.teleport(location);
        }
        players.clear();
        unregisterListeners();
        setJoinable(true);
    }
    public abstract Listener[] getListeners();
    private void unregisterListeners() {
        for (Listener listener : getListeners()) {
            HandlerList.unregisterAll(listener);
        }
    }
    private void registerListeners() {
        for (Listener listener : getListeners()) {
            Bukkit.getPluginManager().registerEvents(listener, JavaPlugin.getProvidingPlugin(Minigame.class));
        }
    }

    public int getId() {
        return id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setJoinable(boolean joinable) {
        this.joinable = joinable;
    }
}
