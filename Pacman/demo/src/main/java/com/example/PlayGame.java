package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class PlayGame extends Application {



    @Override
    public void start(Stage stage) {

        Board board = new Board();
    



        Scene scene = Render.render_board(board, 40);



        stage.setTitle("AnimationTimer");
        stage.setScene(scene);
        stage.show();





        /* 
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            
            public void handle(KeyEvent event) {
                pacman.move(event);
            }
        });

        */




        /* 

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pacman.direction=="UP") {
                    pacmanImage.setRotate(270);
                    pacmanImage.setY(pacmanImage.getY() - pacman.speed);
                }
               

                if (pacman.direction=="DOWN") {
                    pacmanImage.setRotate(90);
                    pacmanImage.setY(pacmanImage.getY() + pacman.speed);
                }

                if (pacman.direction=="LEFT") {
                    pacmanImage.setRotate(180);
                    pacmanImage.setX(pacmanImage.getX() - pacman.speed);
                }

                if (pacman.direction=="RIGHT") {
                    pacmanImage.setRotate(0);
                    pacmanImage.setX(pacmanImage.getX() + pacman.speed);
                }

                //if (pacmanImage.getX() >= 620 || pacmanImage.getX() <= 0) {
                  //  pacmanImage.setX(pacmanImage.getX() - pacman.speed);
                    //pacman.speed *= 0.5;
                //}


                //test

                if (pacmanImage.getX() >= 400) {
                    pacmanImage.setX(pacmanImage.getX() - pacman.speed);

                
                }

                if (pacmanImage.getX() <= 100) {
                    pacmanImage.setX(pacmanImage.getX() + pacman.speed);

                
                }

                if (pacmanImage.getY() >= 610) {
                    pacmanImage.setY(pacmanImage.getY() - pacman.speed);
                }
                
                if (pacmanImage.getY() <= 0) {
                    pacmanImage.setY(pacmanImage.getY() + pacman.speed);
                }
            }

        };


        timer.start();
        */
    

        
    }

    public static void main(String[] args) {
        launch();
    }
    
}