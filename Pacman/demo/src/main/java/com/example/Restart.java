package com.example;

public class Restart {

    public static void resetBoard(Board board){                      
        board.restart();
    }

    public static void resetGamestate(GameState gamestate, boolean resetall, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){

        if (resetall){
            gamestate.setLife(2);
            gamestate.setScore(0);

        }
        
        UpdateGameState.ToNormalState(gamestate, redghost, blueghost, pinkghost, orangeghost);
    }


    public static void  resetPosition(MovingObject pacman, MovingObject redghost, MovingObject blueghost, MovingObject pinkghost, MovingObject orangeghost, int tile_size){

        pacman.setPosition(new int[]{tile_size * 14, tile_size * 9});

        redghost.setPosition(new int[]{tile_size * 15, tile_size * 13});
        blueghost.setPosition(new int[]{tile_size * 14, tile_size * 13}); 
        pinkghost.setPosition(new int[]{tile_size * 14, tile_size * 14});
        orangeghost.setPosition(new int[]{tile_size * 15, tile_size * 14});
    }
}
