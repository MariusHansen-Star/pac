package com.example;

import javafx.scene.image.Image;

public class BigFood extends NonMovingObject {


    public BigFood(Image image, int[] position) {
        this.image=image;
        this.position=position;
    }

    public Image getImage() {
        return this.image;
    }
    
}