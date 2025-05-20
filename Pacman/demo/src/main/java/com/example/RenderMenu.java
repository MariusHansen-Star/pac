package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.geometry.Pos;



public class RenderMenu {



    public static void  render(GraphicsContext gc, GameState gamestate, Label score, Label life){

    


        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();


        gc.clearRect(0, 0, canvasWidth, canvasHeight);

        score.setLayoutX(canvasWidth / 2 -50);
        score.setLayoutY(canvasHeight / 2 + 10); 


        life.setLayoutX(canvasWidth / 2- 50);
        life.setLayoutY(canvasHeight / 2 - 30);
        life.setText("GAME OVER");


    }







    
}
