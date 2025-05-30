package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import javafx.scene.control.Label;







public class PlayGame extends Application {

    @Override
    public void start(Stage stage) {


        int tile_size = 20;
        int start_speed = 2;

        Pacman pacman =  new Pacman(start_speed,new ImageView("pac.png"),new int[]{tile_size * 14, tile_size * 9}, "RIGHT"
        , null, 0);
        Board board = new Board();
        GameState gamestate = new GameState(2, 0, 0);
        Ghost redghost = new Ghost (start_speed,new ImageView("redghost.png"),new int[]{tile_size * 15, tile_size * 13}, "RIGHT"
        , null, 0);
        Ghost blueghost = new Ghost (start_speed,new ImageView("blueghost.png"),new int[]{tile_size * 14, tile_size * 13}, "RIGHT"
        , null, 0);
        Ghost pinkghost = new Ghost (start_speed,new ImageView("pinkghost.png"),new int[]{tile_size * 14, tile_size * 14}, "RIGHT"
        , null, 0);
        Ghost orangeghost = new Ghost (start_speed,new ImageView("orangeghost.png"),new int[]{tile_size * 15, tile_size * 14}, "RIGHT"
        , null, 0);

        Wall wall = new Wall (new Image("wall.png"));
        BigFood bigFood = new BigFood(new Image("bigfood.jpg"));
        NormalFood normalFood = new NormalFood(new Image("normalfood.png"));



        //Brugt tankegang til builder pattern
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
        Canvas canvas = new Canvas(tile_size*board.getBoard()[0].length, tile_size*board.getBoard().length);
        root.getChildren().addAll(canvas, pacman.getImage(), redghost.getImage(),blueghost.getImage(), pinkghost.getImage(), orangeghost.getImage(), scoreLabel, LifeLabel);
        root.setStyle("-fx-background-color: black;");


        Scene scene = new Scene(root, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("PacMan");
        stage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //init board        
        Render.render_board(gc, board, tile_size, wall, bigFood, normalFood);  
      



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                    if(gamestate.getGameState() == 0 || gamestate.getGameState() == 1){ // gamestate 0 = normalstate, gamestate 1 = power state    
                        Update.updateGame(board, pacman, tile_size, gamestate, redghost, blueghost, pinkghost, orangeghost);

                        RenderScore.render(gamestate, scoreLabel, LifeLabel);
                        Render.render_board(gc, board, tile_size, wall, bigFood, normalFood);
                        Render.render_moving_object(pacman, tile_size);
                        Render.render_moving_object(redghost, tile_size);
                        Render.render_moving_object(blueghost, tile_size);
                        Render.render_moving_object(pinkghost, tile_size);
                        Render.render_moving_object(orangeghost, tile_size);
                       
                    } else if(gamestate.getGameState() == 3) { //gamestate 3 = endState

                        RenderMenu.render(gc ,gamestate, scoreLabel, LifeLabel);

                        
                    } else if (gamestate.getGameState() == 4) {// gamestate 4 = RestartState
                       
                       
                        Restart.resetPosition(pacman, redghost, blueghost, pinkghost, orangeghost, tile_size);
                        Restart.resetBoard(board);
                        Restart.resetGamestate(gamestate, true);

                        LifeLabel.setLayoutX(500);
                        LifeLabel.setLayoutY(10);

                        scoreLabel.setLayoutX(10);
                        scoreLabel.setLayoutY(10);

                    } else {  //gamestate 5 = RestartState

                        Restart.resetBoard(board);
                        Restart.resetGamestate(gamestate, false);

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