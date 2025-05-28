package com.example;
import javafx.scene.image.ImageView;


public class Pacman implements MovingObject {

    private int speed;
    private ImageView image;
    private int[] position;
    private String direction;
    private int moveProgress;
    private String nextDirection; 

    //Image image = new Image("pac.png");

    public Pacman(int speed, ImageView image, int[] position, String direction, String nextDirection, int moveProgress) {
        this.speed=speed;
        this.image=image;
        this.position=position;
        this.direction=direction;
        this.nextDirection = nextDirection;
        this.moveProgress = moveProgress;
    }


    public void move() { 


        

            if(this.moveProgress < 20){

                
                if (direction=="UP") {
                    this.position[0] = position[0] - speed;
                }
            

                if (direction=="DOWN") {
                    
                    this.position[0] = position[0] + speed;
                }

                if (direction=="LEFT") {
                    this.position[1] = position[1] - speed;
                }

                if (direction=="RIGHT") {
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
    

    public int[] getPosition(){
        return this.position;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getDirection(){
        return this.direction;
    }

    
}
