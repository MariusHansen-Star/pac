package com.example;

import javafx.scene.image.ImageView;


public interface  MovingObject {

    public void move();

    //setters
    public void setPosition(int[] position);
    public void setNextDirection(String direction);
    public void setDirection(String direction);

    //getters
    public int getSpeed();
    public ImageView getImage();
    public String  getDirection();
    public int[] getPosition();

    

    
}