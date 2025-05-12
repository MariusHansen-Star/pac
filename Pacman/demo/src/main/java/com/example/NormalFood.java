package com.example;

import javafx.scene.image.Image;

public class NormalFood extends NonMovingObject {

    
    public NormalFood(Image image, int[] position) {
        this.image=image;
        this.position=position;
    }

    public Image getImage() {
        return this.image;
    }



    
}