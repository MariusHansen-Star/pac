package com.example;
import javafx.scene.image.ImageView;


public class Pacman implements MovingObject {

    private int speed;
    private ImageView image;
    private int[] position;
    private String direction;
    private int moveProgress;
    private String nextDirection; 



    public Pacman(int speed, ImageView image, int[] position, String direction, String nextDirection, int moveProgress) {
        this.speed=speed;
        this.image=image;
        this.position=position;
        this.direction=direction;
        this.nextDirection = nextDirection;
        this.moveProgress = moveProgress;
    }

    

    public void move(Board board) { 
        
            if(!Collision.wall_collision(this, board, 20)){

                if(this.moveProgress < 20){

                    
                    if (direction=="UP") {
                        this.position[0] = this.position[0] - speed;
                    }
                

                    if (direction=="DOWN") {
                        
                        this.position[0] = this.position[0] + speed;
                    }

                    if (direction=="LEFT") {
                        this.position[1] = this.position[1] - speed;
                    }

                    if (direction=="RIGHT") {
                        this.position[1] = this.position[1] + speed;
                    }

                    this.moveProgress = this.moveProgress + speed;

                } 


                if (this.moveProgress >= 20) {
                    this.moveProgress = 0; 
                    if (nextDirection != null && !Collision.Check_wall_at_new_direction(this ,board)) {
                        this.direction = nextDirection;
                        nextDirection = null;
            
                      }

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

    public int getMoveProgress(){
        return this.moveProgress;
    }

    public String getNextDirection(){
        return this.nextDirection;
    }
    
}
