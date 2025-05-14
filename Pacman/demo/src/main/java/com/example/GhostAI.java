package com.example;

import java.util.Random;


public class GhostAI {



    public static void chase(Ghost ghost, Pacman pacman, Board board){

        Random random = new Random();
        String[] directions = {"UP", "DOWN", "RIGHT", "LEFT"};
        String randomDirection = directions[random.nextInt(directions.length)];

        ghost.setNextDirection(randomDirection);
        ghost.move();

    }

    
}
