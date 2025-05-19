package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Pacman extends MovingObject {


    //Image image = new Image("pac.png");

    public Pacman(int speed, ImageView image, int[] position, String direction, String nextDirection, int moveProgress) {
        this.speed=speed;
        this.image=image;
        this.position=position;
        this.direction=direction;
        this.nextDirection = nextDirection;
        this.moveProgress = moveProgress;
    }


    public void move() { // THIS SHOULD BE IN MOVEMENT CLASS: BREAKING SOLID PRINCIPLE.



            if(this.moveProgress < 20){

                if (direction=="UP") {
                    image.setRotate(270);
                    this.position[0] = position[0] - speed;
                }
            

                if (direction=="DOWN") {
                    image.setRotate(90);
                    this.position[0] = position[0] + speed;
                }

                if (direction=="LEFT") {
                    image.setRotate(180);
                    this.position[1] = position[1] - speed;
                }

                if (direction=="RIGHT") {
                    image.setRotate(0);
                    this.position[1] = position[1] + speed;
                }

                this.moveProgress = moveProgress + speed;

            } else {
                moveProgress = 0; 
                if (nextDirection != null) {
                    this.direction = nextDirection;
                    nextDirection = null;
                }
            }
            
         


        } 

     


    public void setPosition(int[] position){
        this.position = position;
        this.moveProgress = 0;
    }
    


    public void setNextDirection(String direction){
        this.nextDirection = direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public ImageView getImage() {
        return this.image;
    }
    






    
}
