package me.thelightmc.game;

import me.thelightmc.Game;
import me.thelightmc.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;
import java.util.logging.Level;

public class TestGame extends Game {
    private final Location location;

    public TestGame(Location location) {
        super("Survival Games");
        this.location = location;
    }

    @Override
    public void startGame() {
        for (int i = 0; i < 1; i++) {
            for (UUID uuid : getPlayers()) {
                Player player = Bukkit.getPlayer(uuid);
                Bukkit.getLogger().info(player.getName() + " 1000 times");
                player.sendMessage(i + "");
            }
        }
        Bukkit.getLogger().info(" ending game size == " + getPlayers().size());
        endGame();
    }

    @Override
    public Location getSpawnPoint() {
        return location;
    }

    @Override
    public Listener[] getListeners() {
        return new Listener[0];
    }
}
