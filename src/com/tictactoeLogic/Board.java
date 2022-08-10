package com.tictactoeLogic;

public class Board{
    private static char[][] boardGame = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public Board() {}

    public static char[][] getBoard() {
        return boardGame;
    }

    public static void displayTemplateBoard() {
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + "1" + " | " + "2" + " | " + "3" + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + "4" + " | " + "5" + " | " + "6" + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + "7" + " | " + "8" + " | " + "9" + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +\n");
    }
    
    public static  void createBoardGame() { 
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + boardGame[0][0] + " | " + boardGame[0][1] + " | " + boardGame[0][2] + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + boardGame[1][0] + " | " + boardGame[1][1] + " | " + boardGame[1][2] + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
        System.out.println("| " + boardGame[2][0] + " | " + boardGame[2][1] + " | " + boardGame[2][2] + " |");
        System.out.println("+ -" + " + " + "-" + " + " + "- +");
    }
}
