package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;


public class Render {



    public static void render_board(GraphicsContext gc,Board board, int tile_size) {


        //INIT ALL FIX LATER

        Wall wall = new Wall(new Image("wall.png"), null);
        BigFood bigFood = new BigFood(new Image("bigfood.jpg"), null);
        NormalFood normalFood = new NormalFood(new Image("normalfood.png"), null);
    
        Image wallImage = wall.getImage();
        Image bigFoodImage = bigFood.getImage();
        Image normalFoodImage = normalFood.getImage();
    
        



        
        
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        

        for (int row = 0; row < board.map.length; row++) {
                for (int column = 0; column < board.map[0].length; column++) {
                    double x = column * tile_size;
                    double y = row * tile_size;
        
                    char tile = board.map[row][column];
        
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

                    
     





    
    public static void render_moving_object(MovingObject mobject, int tile_size){


        
        mobject.image.setX(mobject.position[1]);
        mobject.image.setY(mobject.position[0]);
        mobject.image.setFitHeight(tile_size);
        mobject.image.setFitWidth(tile_size);



    }


    
    





    
}
