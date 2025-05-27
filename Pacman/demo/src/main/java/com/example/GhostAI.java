package com.example;

import java.util.Random;
import java.util.*;


public class GhostAI {



    public static void chase(Ghost ghost, Pacman pacman, Board board, int tile_size){

        // Random Movement
        Random random = new Random();
        String[] directions = {"UP", "DOWN", "RIGHT", "LEFT"};
        String randomDirection = directions[random.nextInt(directions.length)];

        ghost.setNextDirection(randomDirection);

        if(!Collision.wall_collision(ghost, board, tile_size)){
            ghost.move();
        } else{
            ghost.setDirection(randomDirection);
        }
        

    } 
    

    
}
