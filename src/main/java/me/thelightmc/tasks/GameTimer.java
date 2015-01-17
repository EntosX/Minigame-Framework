package me.thelightmc.tasks;

import me.thelightmc.Game;

public class GameTimer implements Runnable {
    private final Game game;

    public GameTimer(Game game) {
        this.game = game;

    }
    @Override
    public void run() {
        game.endGame();
    }
}
