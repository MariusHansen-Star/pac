package com.example;

public class WinCondition {

    public static boolean check (Board board){

        char[][] map = board.getBoard();

        boolean found = true;

        for (char[] row : map) {
            if (new String(row).contains("s") || new String(row).contains("b")) {
                found = false;
                break;
            }
        }

        return found;


    }
    
}
