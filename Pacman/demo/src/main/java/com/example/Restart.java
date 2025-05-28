package com.example;

public class Restart {

    public static void resetBoard(Board board){                      
        board.restart();
    }

    public static void resetGamestate(GameState gamestate){
        gamestate.setLife(2);
        gamestate.setScore(0);
        gamestate.setGameState(0);

    }


    public static void  resetPosition(MovingObject pacman, MovingObject redghost, MovingObject blueghost, MovingObject pinkghost, MovingObject orangeghost, int tile_size){

        pacman.setPosition(new int[]{tile_size * 6, tile_size * 6});

        redghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
        blueghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
        pinkghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
        orangeghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
    }
}
