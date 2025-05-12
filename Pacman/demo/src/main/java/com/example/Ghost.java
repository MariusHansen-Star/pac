package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ghost extends MovingObject {

    private int ghostState;

    public Ghost(int speed, ImageView image, int[] position) {
        this.speed=speed;
        this.image=image;
        this.position=position;
    }


    

    public void move() {

    }

    public void scared() {

    }

    public void chase() {

    }

    public ImageView getImage() {
        return this.image;
    }
    
}