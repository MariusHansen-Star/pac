package com.example;



import javafx.scene.image.Image;

abstract class NonMovingObject {
    public Image image; //skal den ikke være private, da vi har en getter til attributten?

    public Image getImage(){
        return this.image;
    }
    
}
