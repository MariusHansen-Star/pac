package com.example;

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
            

            UpdateGameState.ToPowerState(gamestate, redghost, blueghost, pinkghost, orangeghost);


        }



        //checking collision with ghost

        if (Collision.ghost_collision(pacman, redghost, tile_size, gamestate)){

            if (gamestate.getGameState() == 1){
                gamestate.setScore(gamestate.getScore() + 50);
                redghost.setPosition(new int[] {15*tile_size,15*tile_size});

            }
            else{ 
                gamestate.setLife(gamestate.getLife() - 1);
                pacman.setPosition(new int[] {tile_size * 6, tile_size * 6});
            }

        }


        //If in power state

        if(gamestate.getGameState() == 1){
                gamestate.setTimer(gamestate.getTimer() - 1); 

                if(gamestate.getTimer() == 0){
                
                    UpdateGameState.ToNormalState(gamestate, redghost, blueghost, pinkghost, orangeghost);




                }

        }
   


        
        



    }



    
}
