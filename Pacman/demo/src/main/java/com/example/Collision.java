package com.example;

public class Collision {


    public static boolean wall_collision(MovingObject pacman,Board board, int tile_size){

        //calculate which value to get.

        int new_x = pacman.position[1];
        int new_y = pacman.position[0];

        if (pacman.direction.equals("UP")) {
            new_y = pacman.position[0] - pacman.speed ;
        }
       
        if (pacman.direction.equals("DOWN")) {
            new_y = pacman.position[0] + pacman.speed * 20 ; //hvorfor *20
        }

        if (pacman.direction.equals("LEFT")) {
            new_x = pacman.position[1] - pacman.speed ;
        }

        if (pacman.direction.equals("RIGHT")) {
            new_x = pacman.position[1] + pacman.speed * 20 ; //hvorfor *20
        }


        int position_in_matrix_x = (new_x  / tile_size);
        int position_in_matrix_y = (new_y  / tile_size);

        if (position_in_matrix_y < 0 || position_in_matrix_x < 0 || position_in_matrix_y >= board.map.length || position_in_matrix_x >= board.map[0].length) {
            return true; // out-of-bounds treated as wall
        }

        return board.map[position_in_matrix_y][position_in_matrix_x] == 'w';

    }


    public static boolean sfood_collision(MovingObject pacman,Board board, int tile_size, GameState gamestate){

        int new_x = pacman.position[1] / tile_size; // x
        int new_y = pacman.position[0] / tile_size; // y

        if (board.map[new_y][new_x] == 's'){
            return true;
        }
        return false;



    }




    
}
