package com.example;

import java.util.Random;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Update {

    public static void updateGame(Board board, Pacman pacman, int tile_size, GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){

        // Pac movement
        if (!Collision.wall_collision(pacman, board, tile_size)) {
            pacman.move();
            }


        //ghost movement
        GhostAI.chase(redghost, pacman, board, tile_size);
        GhostAI.chase(blueghost, pacman, board, tile_size);
        GhostAI.chase(pinkghost, pacman, board, tile_size);
        GhostAI.chase(orangeghost, pacman, board, tile_size);


        

        //Checks collisions
        if (Collision.sfood_collision(pacman, board, tile_size, gamestate)){

            board.set_tile(pacman.position[0] /tile_size, pacman.position[1] / tile_size, 'n');
            gamestate.setScore(gamestate.getScore() + 10);

        }

        if (Collision.bfood_collision(pacman, board, tile_size, gamestate)){

            board.set_tile(pacman.position[0] / tile_size, pacman.position[1] / tile_size, 'n');
            gamestate.setScore(gamestate.getScore() + 50);
            gamestate.setGameState(1); // 1 is ghost scared
            pacman.image.setImage(new Image ("handsome_squidward.png"));

        }



        //checking collision with all ghosts;

        if (Collision.ghost_collision(pacman, redghost, tile_size, gamestate)){

            if (gamestate.getGameState() == 1){
                gamestate.setScore(gamestate.getScore() + 50);

            }
            else{ 
                gamestate.setLife(gamestate.getLife() - 1);
                pacman.setPosition(new int[] {tile_size * 6, tile_size * 6});
            }

        }





    }



    
}
