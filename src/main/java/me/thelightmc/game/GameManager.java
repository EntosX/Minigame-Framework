package me.thelightmc.game;

import me.thelightmc.Game;

import java.util.ArrayList;

public class GameManager {
    private static GameManager gameManager;
    private ArrayList<Game> games = new ArrayList<>();
    private int id = 1;
    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public void startGame() {
        getGame(1).startGame();
    }
    public Game getNextGame() {
        for (Game game : games) {
            if (!game.isRunning() && game.isJoinable()) {
                return game;
            }
        }
        return null;
    }

    public void createGame(Game game) {
        game.setId(id);
        game.setRunning(false);
        games.add(game);
        id++;
    }

    public Game getGame(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public Game getGame(String name) {
        for (Game game : games) {
            if (game.getGame_name().equalsIgnoreCase(name)) {
                return game;
            }
        }
        return null;
    }

    public Game getRunningGame() {
        for (Game game : games) {
            if (game.isRunning()) {
                return game;
            }
        }
        return null;
    }
}
