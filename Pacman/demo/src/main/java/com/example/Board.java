package com.example;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;




public class Board {


    public char[][] map = {
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'},
        {'w','s','s','s','s','s','s','w','s','s','s','s','s','s','w'},
        {'w','s','s','s','s','s','s','w','s','s','s','s','s','s','w'},
        {'w','b','w','w','s','w','w','w','s','w','s','w','w','b','w'},
        {'w','s','s','s','s','s','s','s','s','s','s','s','s','s','w'},
        {'w','s','s','w','w','s','s','w','w','w','s','s','s','s','w'},
        {'w','s','w','w','s','n','w','s','s','s','w','s','s','s','w'},
        {'w','s','w','s','n','s','s','s','s','s','s','w','s','s','w'},
        {'w','s','s','s','n','n','n','n','s','n','s','s','s','s','w'},
        {'w','s','s','s','w','w','n','w','w','n','s','s','s','s','w'},
        {'w','s','s','s','w','n','o','n','w','n','s','s','s','s','w'},
        {'w','s','s','s','w','r','g','p','w','n','s','s','s','s','w'},
        {'w','s','s','s','w','w','w','w','w','n','s','s','s','s','w'},
        {'w','b','w','s','s','s','s','h','s','s','s','s','s','b','w'},
        {'w','s','s','s','s','s','s','s','s','s','s','s','s','s','w'},
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'}
        };


    
        public char[][] getBoard(){

            return this.map;


        }    






}
