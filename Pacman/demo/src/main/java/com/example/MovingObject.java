package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public interface  MovingObject {

    public void move();
    public void setPosition(int[] position);
    public void setNextDirection(String direction);
    public void setDirection(String direction);

    

    
}