package com.tictactoe;
import com.tictactoeLogic.*;
public class Main extends ConsoleChat{
    public static void main(String[] args) {
        Board board = new Board();
        Setting setting = new Setting();

        Setting.clearScreen();
        wellcome();    
        setting.playerTurn(); 
        goodBye();       

    }
}
