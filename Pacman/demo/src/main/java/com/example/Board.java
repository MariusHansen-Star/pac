package com.example;




public class Board {


    
    //16x16
    public char[][] map = {
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'}, //0
        {'w','s','s','s','s','s','s','w','s','s','s','s','s','s','s','w'}, //1
        {'w','s','s','s','s','s','s','w','s','s','s','s','s','s','s','w'}, //2
        {'w','b','w','w','s','w','w','w','s','w','s','w','w','b','s','w'},
        {'w','s','s','s','s','s','s','s','s','s','s','s','s','s','s','w'},
        {'w','s','s','w','w','s','s','w','w','w','s','s','s','s','s','w'},
        {'w','s','w','w','s','n','w','s','s','s','w','s','s','s','s','w'},
        {'w','s','w','s','n','s','s','s','s','s','s','w','s','s','s','w'},
        {'w','s','s','s','n','n','n','n','s','n','s','s','s','s','s','w'},
        {'w','s','s','s','w','w','n','w','w','n','s','s','s','s','s','w'},
        {'w','s','s','s','w','n','o','n','w','n','s','s','s','s','s','w'},
        {'w','s','s','s','w','r','g','p','w','n','s','s','s','s','s','w'},
        {'w','s','s','s','w','w','w','w','w','n','s','s','s','s','s','w'},
        {'w','b','w','s','s','s','s','h','s','s','s','s','s','b','s','w'},
        {'w','s','s','s','s','s','s','s','s','s','s','s','s','s','s','w'},
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'}
        };


        public void set_tile(int y, int x,  char tile) {
            this.map[y][x] = tile; 
        }

    
        public char[][] getBoard(){
            return this.map;

        }    


}
