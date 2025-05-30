package com.example;

import javafx.scene.image.Image;


public class UpdateGameState {

    public static void ToPowerState(GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){

        if(gamestate.getGameState() == 0){      // Gamestate 0 = normalStare
            gamestate.setGameState(1); // Gamestate 1 = powerState
            gamestate.setTimer(251);

            redghost.getImage().setImage(new Image ("Vulnerable-ghost.png"));
            blueghost.getImage().setImage(new Image ("Vulnerable-ghost.png"));
            pinkghost.getImage().setImage(new Image ("Vulnerable-ghost.png"));
            orangeghost.getImage().setImage(new Image ("Vulnerable-ghost.png"));


            redghost.setSpeed(redghost.getSpeed() / 2); 
            blueghost.setSpeed(blueghost.getSpeed() / 2); 
            pinkghost.setSpeed(pinkghost.getSpeed() / 2); 
            orangeghost.setSpeed(orangeghost.getSpeed() / 2); 

        } else{
            gamestate.setTimer(251);


        }

    }

    public static void ToNormalState(GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){


        gamestate.setGameState(0); 

        redghost.getImage().setImage(new Image ("redghost.png"));
        blueghost.getImage().setImage(new Image ("blueghost.png"));
        pinkghost.getImage().setImage(new Image ("pinkghost.png"));
        orangeghost.getImage().setImage(new Image ("orangeghost.png"));


        redghost.setSpeed(redghost.getSpeed() * 2);
        blueghost.setSpeed(blueghost.getSpeed() * 2);
        pinkghost.setSpeed(pinkghost.getSpeed() * 2);
        orangeghost.setSpeed(orangeghost.getSpeed() * 2);

    }

    
    


}
