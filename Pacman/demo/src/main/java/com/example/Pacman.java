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
                    if (nextDirection != null && !Check_wall_at_new_direction(board) /*AND den_direction_han_skal_pege_Ingen_Mur(Board)  */) {
                        this.direction = nextDirection;
                        nextDirection = null;
            
            }



        }
        






            }


         


        } 


        private boolean Check_wall_at_new_direction(Board board){

            //nextDirection

            int new_x = this.position[1];
            int new_y = this.position[0];

            String nextDirection = this.nextDirection;

            if (nextDirection.equals("UP")) {
                new_y = this.position[0] - this.speed;
            }
           
            if (nextDirection.equals("DOWN")) {
                new_y = this.position[0] + this.speed + (20 - 1);
            }
    
            if (nextDirection.equals("LEFT")) {
                new_x = this.position[1] - this.speed;
            }
    
            if (nextDirection.equals("RIGHT")) {
                new_x = this.position[1] + this.speed + (20 - 1);
            }


            int position_in_matrix_x = (new_x  / 20);
            int position_in_matrix_y = (new_y  / 20);

            if (position_in_matrix_y < 0 || position_in_matrix_x < 0 || position_in_matrix_y >= board.getBoard().length || position_in_matrix_x >= board.getBoard()[0].length) {
                return true; // out-of-bounds treated as wall
            }
    
            return board.getBoard()[position_in_matrix_y][position_in_matrix_x] == 'w';
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

    
}
