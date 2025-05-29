package com.example;



public class Update {

    public static void updateGame(Board board, Pacman pacman, int tile_size, GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){

        // Pac movement
    

        pacman.move(board);

            


        //ghost movement
        GhostAI.chase(redghost, board, tile_size);
        GhostAI.chase(blueghost, board, tile_size);
        GhostAI.chase(pinkghost, board, tile_size);
        GhostAI.chase(orangeghost, board, tile_size);  
        

        //Checks collisions
        if (Collision.sfood_collision(pacman, board, tile_size, gamestate)){

            board.set_tile(pacman.getPosition()[0] /tile_size, pacman.getPosition()[1] / tile_size, 'n');
            gamestate.setScore(gamestate.getScore() + 10);


                 //Win condition
            if (WinCondition.check(board)){
            gamestate.setGameState(5);

        }

        }

        if (Collision.bfood_collision(pacman, board, tile_size, gamestate)){

            board.set_tile(pacman.getPosition()[0] / tile_size, pacman.getPosition()[1] / tile_size, 'n');
            gamestate.setScore(gamestate.getScore() + 50);
            

            UpdateGameState.ToPowerState(gamestate, redghost, blueghost, pinkghost, orangeghost);

                 //Win condition
            if (WinCondition.check(board)){
            gamestate.setGameState(5);

        }


        }



        //checking collision with ghost

        Collision.ghost_collision(pacman, redghost, tile_size, gamestate);
        Collision.ghost_collision(pacman, blueghost, tile_size, gamestate);
        Collision.ghost_collision(pacman, pinkghost, tile_size, gamestate);
        Collision.ghost_collision(pacman, orangeghost, tile_size, gamestate);



       // power state counter

        if(gamestate.getGameState() == 1){
                gamestate.setTimer(gamestate.getTimer() - 1); 
                if(gamestate.getTimer() == 0){
                    UpdateGameState.ToNormalState(gamestate, redghost, blueghost, pinkghost, orangeghost);

                }
        }



   

        //lose condition
        if (gamestate.getLife() == 0){
            gamestate.setGameState(3);
        }
   
        



    }

    
}
