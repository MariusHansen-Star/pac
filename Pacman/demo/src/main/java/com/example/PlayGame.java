package com.example;

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

import javafx.scene.control.Label;







public class PlayGame extends Application {

    @Override
    public void start(Stage stage) {


        int tile_size = 40;

        //pacman pos: y = 6, x = 7
        Pacman pacman =  new Pacman(2,new ImageView("pac.png"),new int[]{tile_size * 6, tile_size * 7}, "RIGHT"
        , null, 0);
        Board board = new Board();
        GameState gamestate = new GameState(3, 1, 0);



        //score label
        Label scoreLabel = new Label("Score: " + gamestate.getScore());
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setStyle("-fx-font-size: 20px; -fx-background-color: transparent;");
        scoreLabel.setLayoutX(10);
        scoreLabel.setLayoutY(10);
      


        Pane root = new Pane();
        Canvas canvas = new Canvas(tile_size*16, tile_size*16);
        root.getChildren().addAll(canvas, pacman.image, scoreLabel);
        root.setStyle("-fx-background-color: black;");


        Scene scene = new Scene(root, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("PacMan");
        stage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //init board
        Render.render_board(gc, board, tile_size);  




        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                //ONLY CHECK collision at move boundatres (move progress = 0)???

               
                if (!Collision.wall_collision(pacman, board, tile_size)) {
                pacman.move();
                }
              
                if (Collision.sfood_collision(pacman, board, tile_size, gamestate)){

                    board.set_tile(pacman.position[0] /tile_size, pacman.position[1] / tile_size, 'n');
                    gamestate.setScore(gamestate.getScore() + 10);

                }



                RenderScore.render(gamestate, scoreLabel);
                Render.render_board(gc, board, tile_size);
                Render.render_moving_object(pacman, tile_size);



            }
        };

        timer.start();


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(!Collision.wall_collision(pacman, board, tile_size)){

                Controller.checkDirection(event, pacman);

                } else {

                    Controller.checkDirectionStuck(event, pacman);

                }

            }
        });
        



}



        


     
    

        
    

    public static void main(String[] args) {
        launch();
    }
    
}