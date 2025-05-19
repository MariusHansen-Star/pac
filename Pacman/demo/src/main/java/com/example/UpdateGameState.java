package com.example;

import javafx.scene.image.Image;


public class UpdateGameState {

    public static void ToPowerState(GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){

        if(gamestate.getGameState() == 0){
            gamestate.setGameState(1); // 1 is ghost scared
            gamestate.setTimer(500);

            redghost.image.setImage(new Image ("handsome_squidward.png"));
            blueghost.image.setImage(new Image ("handsome_squidward.png"));
            pinkghost.image.setImage(new Image ("handsome_squidward.png"));
            orangeghost.image.setImage(new Image ("handsome_squidward.png"));


            redghost.speed = redghost.speed / 2;
            blueghost.speed = blueghost.speed / 2;
            pinkghost.speed = pinkghost.speed / 2;
            orangeghost.speed = orangeghost.speed / 2;

        } else{
            gamestate.setTimer(500);

        }

    }

    public static void ToNormalState(GameState gamestate, Ghost redghost, Ghost blueghost, Ghost pinkghost, Ghost orangeghost){


        gamestate.setGameState(0); // 1 is ghost scared

        redghost.image.setImage(new Image ("redghost.png"));
        blueghost.image.setImage(new Image ("blueghost.png"));
        pinkghost.image.setImage(new Image ("pinkghost.png"));
        orangeghost.image.setImage(new Image ("orangeghost.png"));


        redghost.speed = redghost.speed * 2;
        blueghost.speed = blueghost.speed * 2;
        pinkghost.speed = pinkghost.speed * 2;
        orangeghost.speed = orangeghost.speed * 2;

    }

    


}
