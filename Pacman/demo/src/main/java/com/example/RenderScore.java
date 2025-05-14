package com.example;

import javafx.scene.control.Label;

public class RenderScore {

    public static void render(GameState gamestate, Label label){

        label.setText("Score: " + gamestate.getScore());



    }



    
    
}
