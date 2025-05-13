package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

abstract class MovingObject {
    public int speed;
    public ImageView image;
    public int[] position;
    public String direction;
    public int moveProgress;
    public String nextDirection; //maybe only in pacman
    abstract void move();
    
}