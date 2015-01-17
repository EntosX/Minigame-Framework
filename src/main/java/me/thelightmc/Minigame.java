package me.thelightmc;

import me.thelightmc.commands.StartGame;
import me.thelightmc.game.GameManager;
import me.thelightmc.game.TestGame;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Minigame extends JavaPlugin {
    @Override
    public void onEnable() {
        GameManager.getInstance().createGame(new TestGame(Bukkit.getWorlds().get(1).getSpawnLocation()));
        getCommand("StartGame").setExecutor(new StartGame());
    }
}
