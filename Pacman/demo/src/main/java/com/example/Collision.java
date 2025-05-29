package com.example;

public class Collision {


    public static boolean wall_collision(MovingObject pacman,Board board, int tile_size){

        //calculate which value to get.

        int new_x = pacman.getPosition()[1];
        int new_y = pacman.getPosition()[0];

        if (pacman.getDirection().equals("UP")) {
            new_y = pacman.getPosition()[0] - pacman.getSpeed();
        }
       
        if (pacman.getDirection().equals("DOWN")) {
            new_y = pacman.getPosition()[0] + pacman.getSpeed() + (tile_size - 1);
        }

        if (pacman.getDirection().equals("LEFT")) {
            new_x = pacman.getPosition()[1] - pacman.getSpeed();
        }

        if (pacman.getDirection().equals("RIGHT")) {
            new_x = pacman.getPosition()[1] + pacman.getSpeed() + (tile_size - 1);
        }


        int position_in_matrix_x = (new_x  / tile_size);
        int position_in_matrix_y = (new_y  / tile_size);

        if (position_in_matrix_y < 0 || position_in_matrix_x < 0 || position_in_matrix_y >= board.getBoard().length || position_in_matrix_x >= board.getBoard()[0].length) {
            return true; // out-of-bounds treated as wall
        }

        return board.getBoard()[position_in_matrix_y][position_in_matrix_x] == 'w';

    }


    public static boolean wall_collision(Ghost pacman,Board board, int tile_size){

        //calculate which value to get.

        int new_x = pacman.getPosition()[1];
        int new_y = pacman.getPosition()[0];

        if (pacman.getDirection().equals("UP")) {
            new_y = pacman.getPosition()[0] - pacman.getSpeed();
        }
       
        if (pacman.getDirection().equals("DOWN")) {
            new_y = pacman.getPosition()[0] + pacman.getSpeed() + (tile_size - 1);
        }

        if (pacman.getDirection().equals("LEFT")) {
            new_x = pacman.getPosition()[1] - pacman.getSpeed();
        }

        if (pacman.getDirection().equals("RIGHT")) {
            new_x = pacman.getPosition()[1] + pacman.getSpeed() + (tile_size - 1);
        }


        int position_in_matrix_x = (new_x  / tile_size);
        int position_in_matrix_y = (new_y  / tile_size);

        if (position_in_matrix_y < 0 || position_in_matrix_x < 0 || position_in_matrix_y >= board.getBoard().length || position_in_matrix_x >= board.getBoard()[0].length) {
            return true; // out-of-bounds treated as wall
        }

        return board.getBoard()[position_in_matrix_y][position_in_matrix_x] == 'w';

    }






    public static boolean sfood_collision(Pacman pacman,Board board, int tile_size, GameState gamestate){

        int new_x = pacman.getPosition()[1] / tile_size; // x
        int new_y = pacman.getPosition()[0] / tile_size; // y

        if (board.getBoard()[new_y][new_x] == 's'){
            return true;
        }
        return false;
    }


    public static boolean bfood_collision(Pacman pacman,Board board, int tile_size, GameState gamestate){

        int new_x = pacman.getPosition()[1] / tile_size; // x
        int new_y = pacman.getPosition()[0] / tile_size; // y

        if (board.getBoard()[new_y][new_x] == 'b'){
            return true;
        }
        return false;
    }


    public static void ghost_collision(Pacman pacman, Ghost ghost, int tile_size, GameState gamestate){

        int pac_x = pacman.getPosition()[1] / tile_size; // x
        int pac_y = pacman.getPosition()[0] / tile_size; // y

        int ghost_x = ghost.getPosition()[1] / tile_size;
        int ghost_y = ghost.getPosition()[0] / tile_size;

        if ((pac_x == ghost_x) & (pac_y == ghost_y)){

            if (gamestate.getGameState() == 1){
                gamestate.setScore(gamestate.getScore() + 50);
                ghost.setPosition(new int[] {15*tile_size,15*tile_size});

            }
            else{ 
                gamestate.setLife(gamestate.getLife() - 1);
                pacman.setPosition(new int[] {tile_size * 6, tile_size * 6});
            }


        }
    
    }

    
}
