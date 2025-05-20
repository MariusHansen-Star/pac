package com.example;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class Controller {

    public static void checkDirection(KeyEvent event, Pacman pacman){


        if (event.getCode() == KeyCode.UP) {
            pacman.setNextDirection("UP");
        }
        else if (event.getCode() == KeyCode.DOWN) {
            pacman.setNextDirection("DOWN");
        }
        else if (event.getCode() == KeyCode.LEFT) {
            pacman.setNextDirection("LEFT");
        }
        else if (event.getCode() == KeyCode.RIGHT) {
            pacman.setNextDirection("RIGHT");


        }

    }


    public static void checkDirectionStuck(KeyEvent event, Pacman pacman){

        if (event.getCode() == KeyCode.UP) {
            pacman.setDirection("UP");
        }
        else if (event.getCode() == KeyCode.DOWN) {
            pacman.setDirection("DOWN");
        }
        else if (event.getCode() == KeyCode.LEFT) {
            pacman.setDirection("LEFT");
        }
        else if (event.getCode() == KeyCode.RIGHT) {
            pacman.setDirection("RIGHT");


        }
    }


    public static void checkClick(KeyEvent event, GameState gamestate){

        if(event.getCode() == KeyCode.SPACE){
            gamestate.setGameState(4);


        }

    }


}
