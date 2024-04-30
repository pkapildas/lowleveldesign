package tictoc;

import tictoc.model.Game;

public class TicTocGame {
    public static void main(String args[]) {
        Game game = new Game();

        System.out.println("game winner is: " + game.startGame());
    }

}
