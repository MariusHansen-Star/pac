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

    
    Pacman pacman;
    Board board;
    GameState gamestate;
    Ghost redghost;
    Ghost blueghost;
    Ghost pinkghost;
    Ghost orangeghost;

    @Override
    public void start(Stage stage) {


        int tile_size = 20;
        int start_speed = 2;

        //pacman pos: y = 6, x = 7
        Pacman pacman =  new Pacman(start_speed,new ImageView("pac.png"),new int[]{tile_size * 6, tile_size * 6}, "RIGHT"
        , null, 0);
        Board board = new Board();
        GameState gamestate = new GameState(2, 0, 0);
        Ghost redghost = new Ghost (start_speed,new ImageView("redghost.png"),new int[]{tile_size * 2, tile_size * 4}, "RIGHT"
        , null, 0);
        Ghost blueghost = new Ghost (start_speed,new ImageView("blueghost.png"),new int[]{tile_size * 2, tile_size * 4}, "RIGHT"
        , null, 0);
        Ghost pinkghost = new Ghost (start_speed,new ImageView("pinkghost.png"),new int[]{tile_size * 2, tile_size * 4}, "RIGHT"
        , null, 0);
        Ghost orangeghost = new Ghost (start_speed,new ImageView("orangeghost.png"),new int[]{tile_size * 2, tile_size * 4}, "RIGHT"
        , null, 0);





        //score label
        Label scoreLabel = new Label("Score: " + gamestate.getScore());
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setStyle("-fx-font-size: 20px; -fx-background-color: transparent;");
        scoreLabel.setLayoutX(10);
        scoreLabel.setLayoutY(10);


        //Life label
        Label LifeLabel = new Label("Lifes: " + gamestate.getLife());
        LifeLabel.setTextFill(Color.WHITE);
        LifeLabel.setStyle("-fx-font-size: 20px; -fx-background-color: transparent;");
        LifeLabel.setLayoutX(500);
        LifeLabel.setLayoutY(10);
      


        Pane root = new Pane();
        Canvas canvas = new Canvas(tile_size*board.map[0].length, tile_size*board.map.length);
        root.getChildren().addAll(canvas, pacman.image, redghost.image,blueghost.image, pinkghost.image, orangeghost.image, scoreLabel, LifeLabel);
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

                //only check collision at move boundatres (move progress = 0)???

                    if(gamestate.getGameState() == 0 || gamestate.getGameState() == 1){
                        Update.updateGame(board, pacman, tile_size, gamestate, redghost, blueghost, pinkghost, orangeghost);

                        RenderScore.render(gamestate, scoreLabel, LifeLabel);
                        Render.render_board(gc, board, tile_size);
                        Render.render_moving_object(pacman, tile_size);
                        Render.render_moving_object(redghost, tile_size);
                        Render.render_moving_object(blueghost, tile_size);
                        Render.render_moving_object(pinkghost, tile_size);
                        Render.render_moving_object(orangeghost, tile_size);
                       
                    } else if(gamestate.getGameState() == 3) {

                        RenderMenu.render(gc ,gamestate, scoreLabel, LifeLabel);

                        
                    } else{ // Restarts game
                        pacman.setPosition(new int[]{tile_size * 6, tile_size * 6});
                        board.restart();
                        gamestate.setLife(2);
                        gamestate.setScore(0);
                        gamestate.setGameState(0);


                        redghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
                        blueghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
                        pinkghost.setPosition(new int[]{tile_size * 10, tile_size * 10});
                        orangeghost.setPosition(new int[]{tile_size * 10, tile_size * 10});


                        LifeLabel.setLayoutX(500);
                        LifeLabel.setLayoutY(10);

                        scoreLabel.setLayoutX(10);
                        scoreLabel.setLayoutY(10);

                    }
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


                Controller.checkClick(event, gamestate);

            }
        });
        



}



        


     
    

        
    

    public static void main(String[] args) {
        launch();
    }
    
}