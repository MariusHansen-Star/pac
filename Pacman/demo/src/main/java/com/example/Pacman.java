package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Pacman extends MovingObject {

    public String direction;
    





    //Image image = new Image("pac.png");

    public Pacman(int speed, ImageView image, int[] position, String direction) {
        this.speed=speed;
        this.image=image;
        this.position=position;
        this.direction=direction;

    }

    
    
    public void move() {
    }

    public ImageView getImage() {
        return this.image;
    }
    

    public void move(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            direction = "UP";
        }
        else if (event.getCode() == KeyCode.DOWN) {
            direction = "DOWN";
        }
        else if (event.getCode() == KeyCode.LEFT) {
            direction = "LEFT";
        }
        else if (event.getCode() == KeyCode.RIGHT) {
            direction = "RIGHT";
        }
        else {
            direction = "NO DIRECTION";
        }
    }
}
