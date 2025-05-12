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


    public static Scene render_board(Board board, int tile_size) {


        //INIT ALL FIX LATER
        Pacman pacman = new Pacman(2,new ImageView("pac.png") , null, null);
        Ghost redGhost = new Ghost(0, new ImageView("redghost.png"), null);
        Ghost blueGhost = new Ghost(0, new ImageView("blueghost.png"), null);
        Ghost orangeGhost = new Ghost(0, new ImageView("orangeghost.png"), null);
        Ghost pinkGhost = new Ghost(0, new ImageView("pinkghost.png"), null);
        Wall wall = new Wall(new Image("wall.png"), null);
        BigFood bigFood = new BigFood(new Image("bigfood.jpg"), null);
        NormalFood normalFood = new NormalFood(new Image("normalfood.png"), null);
    
        ImageView pacmanImage = pacman.getImage();
        ImageView redGhostImage = redGhost.getImage();
        ImageView blueGhostImage = blueGhost.getImage();
        ImageView orangeGhostImage = orangeGhost.getImage();
        ImageView pinkGhostImage = pinkGhost.getImage();
        Image wallImage = wall.getImage();
        Image bigFoodImage = bigFood.getImage();
        Image normalFoodImage = normalFood.getImage();
    
    
        Canvas canvas = new Canvas(620, 650);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        //


        for (int row = 0; row < board.map.length; row++) {
                for (int column = 0; column < board.map[0].length; column++) {
                    double x = column * tile_size;
                    double y = row * tile_size;
        
                    char tile = board.map[row][column];
        
                    switch (tile) {
        
                        case 'n':
                            graphics.fillRect(x, y, tile_size, tile_size);
                            break;
        
                        case 'r':
                            redGhostImage.setX(column*tile_size);
                            redGhostImage.setY(row*tile_size);
                            redGhostImage.setFitHeight(tile_size-5);
                            redGhostImage.setFitWidth(tile_size-5);
                            break;
                        
                        case 'w':
                            graphics.drawImage(wallImage, x, y, tile_size, tile_size); 
                            break;
                        
                        case 'g':
                            blueGhostImage.setX(column*tile_size);
                            blueGhostImage.setY(row*tile_size);
                            blueGhostImage.setFitHeight(tile_size-5);
                            blueGhostImage.setFitWidth(tile_size-5);                            
                            break;
        
                        case 'p':
                            pinkGhostImage.setX(column*tile_size);
                            pinkGhostImage.setY(row*tile_size);
                            pinkGhostImage.setFitHeight(tile_size-5);
                            pinkGhostImage.setFitWidth(tile_size-5);
                            break;
        
                        case 'o':
                            orangeGhostImage.setX(column*tile_size);
                            orangeGhostImage.setY(row*tile_size);
                            orangeGhostImage.setFitHeight(tile_size-5);
                            orangeGhostImage.setFitWidth(tile_size-5);


                            break;
        
                        case 'h':
                            pacmanImage.setX(column*tile_size);
                            pacmanImage.setY(row*tile_size);
                            pacmanImage.setFitHeight(tile_size);
                            pacmanImage.setFitWidth(tile_size);


                            break;
        
                        case 'b':
                            graphics.drawImage(bigFoodImage, x, y, tile_size, tile_size);
                            break;
        
                        case 's':
                            graphics.drawImage(normalFoodImage, x, y, tile_size, tile_size);
                            break;
        
                    }
            }

           
        }


            Pane pane = new Pane();
            pane.getChildren().addAll(canvas,pacmanImage,blueGhostImage,orangeGhostImage,pinkGhostImage,redGhostImage);

            Scene scene = new Scene(pane, 620,650 ,Color.BLACK);

            return scene;


    }


    
}
