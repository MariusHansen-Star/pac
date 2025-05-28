package com.example;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



public class Render {




    public static void render_board(GraphicsContext gc,Board board, int tile_size, NonMovingObject wall, NonMovingObject bigFood, NonMovingObject normalFood) {

       
        Image wallImage = wall.getImage();
        Image bigFoodImage = bigFood.getImage();
        Image normalFoodImage = normalFood.getImage();
  
        
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        

        for (int row = 0; row < board.getBoard().length; row++) {
                for (int column = 0; column < board.getBoard()[0].length; column++) {
                    double x = column * tile_size;
                    double y = row * tile_size;
        
                    char tile = board.getBoard()[row][column];
        
                    switch (tile) {
        
                        case 'n':
                            gc.fillRect(x, y, tile_size, tile_size);
                            break;
        
                        case 'r':
                            gc.fillRect(x, y, tile_size, tile_size);
                            break;
                        
                        case 'w':
                            gc.drawImage(wallImage, x, y, tile_size, tile_size); 
                            break;
                        
                        case 'g':
                            gc.fillRect(x, y, tile_size, tile_size);                             
                            break;
        
                        case 'p':
                            gc.fillRect(x, y, tile_size, tile_size);
                            break;
        
                        case 'o':
                            gc.fillRect(x, y, tile_size, tile_size);
                            break;
        
                        case 'h':

                            gc.fillRect(x, y, tile_size, tile_size);

                            break;
        
                        case 'b':
                            gc.drawImage(bigFoodImage, x, y, tile_size, tile_size);
                            break;
        
                        case 's':
                            gc.drawImage(normalFoodImage, x, y, tile_size, tile_size);
                            break;
        
                    }
            }

           
        }


    }

                    
    public static void render_moving_object(Pacman mObject, int tile_size){
        
        mObject.getImage().setX(mObject.getPosition()[1]);
        mObject.getImage().setY(mObject.getPosition()[0]);
        mObject.getImage().setFitHeight(tile_size);
        mObject.getImage().setFitWidth(tile_size);

        String direction = mObject.getDirection();

        if (direction=="UP") {
            mObject.getImage().setRotate(270);
        }
    

        if (direction=="DOWN") {
            mObject.getImage().setRotate(90);
        }

        if (direction=="LEFT") {
            mObject.getImage().setRotate(180);
        }

        if (direction=="RIGHT") {
            mObject.getImage().setRotate(0);
        }
    }

    public static void render_moving_object(Ghost mObject, int tile_size){
        
        mObject.getImage().setX(mObject.getPosition()[1]);
        mObject.getImage().setY(mObject.getPosition()[0]);
        mObject.getImage().setFitHeight(tile_size);
        mObject.getImage().setFitWidth(tile_size);

    }
    



    
}
