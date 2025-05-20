package com.example;

import javafx.scene.control.Label;

public class RenderScore {

    public static void render(GameState gamestate, Label scorelabel, Label lifelabel ){

        scorelabel.setText("Score: " + gamestate.getScore());
        lifelabel.setText("Life:" + gamestate.getLife());



    }



    
    
}
