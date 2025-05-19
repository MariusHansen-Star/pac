package com.example;

public class GameState {

    private int score;
    private int pacman_life;
    private int game_state;
    private int power_state_timer;

    public GameState(int pac_life, int gamestate, int score){
        this.pacman_life = pac_life;
        this.game_state = gamestate;
        this.score = score;
        this.power_state_timer = 0;
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

    public void setTimer(int timer){
        this.power_state_timer = timer;
    }

    public int getTimer(){
        return this.power_state_timer;
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
