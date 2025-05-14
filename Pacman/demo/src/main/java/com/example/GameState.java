package com.example;

public class GameState {

    private int score;
    private int pacman_life;
    private int game_state;

    public GameState(int pac_life, int gamestate, int score){
        this.pacman_life = pac_life;
        this.game_state = gamestate;
        this.score = score;
    }
    
    public void setScore(int score){
        this.score = score;
    }


    public void setLife(int life){
        this.pacman_life = life;
    }

    public void setGameState(int gamestate){
        this.game_state = gamestate;
    }

    public int getScore(){
        return this.score;
    }

    public int getGameState(){
        return this.game_state;
    }

    public int getLife(){
        return this.pacman_life;
    }



    
}
