package com.tictactoeLogic;

import java.util.Scanner;
import java.util.concurrent.ConcurrentNavigableMap;

public class Setting extends Board {
    private char[][] newBoardGame = Board.getBoard();

    public void player1Move(int index, char symbol) {
        Player player = new Player("");
        final char test = symbol;
        switch (index) {
            case 1:
                newBoardGame[0][0] = test;
                break;
            case 2:
                newBoardGame[0][1] = test;
                break;
            case 3:
                newBoardGame[0][2] = test;
                break;
            case 4:
                newBoardGame[1][0] = test;
                break;
            case 5:
                newBoardGame[1][1] = test;
                break;
            case 6:
                newBoardGame[1][2] = test;
                break;
            case 7:
                newBoardGame[2][0] = test;
                break;
            case 8:
                newBoardGame[2][1] = test;
                break;
            case 9:
                newBoardGame[2][2] = test;
                break;
            default:
                break;
        }
    }

    public void player2Move(int index, char symbol) {
        Player player = new Player("");
        final char test = symbol;
        switch (index) {
            case 1:
                newBoardGame[0][0] = test;
                break;
            case 2:
                newBoardGame[0][1] = test;
                break;
            case 3:
                newBoardGame[0][2] = test;
                break;
            case 4:
                newBoardGame[1][0] = test;
                break;
            case 5:
                newBoardGame[1][1] = test;
                break;
            case 6:
                newBoardGame[1][2] = test;
                break;
            case 7:
                newBoardGame[2][0] = test;
                break;
            case 8:
                newBoardGame[2][1] = test;
                break;
            case 9:
                newBoardGame[2][2] = test;
                break;
            default:
                break;
        }
    }

    public boolean checkIfDraw() {
        boolean isDraw = false;
        for (int i = 0; i < newBoardGame.length; i++) {
            for (int j = 0; j < newBoardGame[i].length; j++) {
                if (newBoardGame[i][j] == ' ') {
                    isDraw = false;
                    return isDraw;
                }
            }
        }
        return isDraw;
    }

    public boolean isBoardHasSymbolX(Player playerOponent) {
        char symbol = playerOponent.getSymbolX();
        boolean overLoading = false;
        if ((newBoardGame[0][0] == symbol) || (newBoardGame[0][1] == symbol) || (newBoardGame[0][2] == symbol) ||
            (newBoardGame[1][0] == symbol) || (newBoardGame[1][1] == symbol) || (newBoardGame[1][2] == symbol) ||
            (newBoardGame[2][0] == symbol) || (newBoardGame[2][1] == symbol) || (newBoardGame[2][2] == symbol)) {
            overLoading = true;
            return overLoading;
        }
        return overLoading;
    }

    public boolean isBoardHasSymbolO(Player playerOponent) {
        char symbol = playerOponent.getSymbolO();
        boolean overLoading = false;
        if ((newBoardGame[0][0] == symbol) || (newBoardGame[0][1] == symbol) || (newBoardGame[0][2] == symbol) ||
            (newBoardGame[1][0] == symbol) || (newBoardGame[1][1] == symbol) || (newBoardGame[1][2] == symbol) ||
            (newBoardGame[2][0] == symbol) || (newBoardGame[2][1] == symbol) || (newBoardGame[2][2] == symbol)) {
            overLoading = true;
            return overLoading;
        }
        return overLoading;
    }

    public boolean whoPlayerwin(char symbol) {
        boolean isWin = false;
        if ((newBoardGame[0][0] == symbol) && (newBoardGame[0][1] == symbol) && (newBoardGame[0][2] == symbol) ||
                (newBoardGame[1][0] == symbol) && (newBoardGame[1][1] == symbol) && (newBoardGame[1][2] == symbol) ||
                (newBoardGame[2][0] == symbol) && (newBoardGame[2][1] == symbol) && (newBoardGame[2][2] == symbol) ||

                (newBoardGame[0][0] == symbol) && (newBoardGame[1][0] == symbol) && (newBoardGame[2][0] == symbol) ||
                (newBoardGame[0][1] == symbol) && (newBoardGame[1][1] == symbol) && (newBoardGame[2][1] == symbol) ||
                (newBoardGame[0][2] == symbol) && (newBoardGame[1][2] == symbol) && (newBoardGame[2][2] == symbol) ||

                (newBoardGame[0][0] == symbol) && (newBoardGame[1][1] == symbol) && (newBoardGame[2][2] == symbol) ||
                (newBoardGame[0][2] == symbol) && (newBoardGame[1][1] == symbol) && (newBoardGame[2][0] == symbol)) {

            isWin = true;
            return isWin;
        }
        return isWin;
    }

    public void playerTurn() {
        int player1Index, player2Index;
        String player1Name, player2Name, player1Symbol, player2Symbol;
        Scanner userInput = new Scanner(System.in);

        Board.displayTemplateBoard();

        System.out.print("Enter fist player name\t: ");
        player1Name = userInput.nextLine();
        Player player1 = new Player(player1Name);
        System.out.print("Enter fist player choise [X/O]: ");
        player1Symbol = userInput.nextLine();

        System.out.print("\nEnter second player name\t: ");
        player2Name = userInput.nextLine();
        Player player2 = new Player(player1Name);

        while (true) {

            System.out.print("Player1 turn [1-9]\t: ");
            player1Index = userInput.nextInt();

            System.out.print("Player2 turn [1-9]\t: ");
            player2Index = userInput.nextInt();

            while (player1Index == player2Index) {
                System.out.println("Cant same index move!!");

                System.out.print("Player1 turn [1-9]\t: ");
                player1Index = userInput.nextInt();

                System.out.print("Player2 turn [1-9]\t: ");
                player2Index = userInput.nextInt();
            }

            if (player1Symbol.equalsIgnoreCase("X")) {

                player1.setSymbolX('X');
                player2.setSymbolO('O');
                player1Move(player1Index, player1.getSymbolX());

                while ((!isBoardHasSymbolX(player1))) {

                }

                player2Move(player2Index, player2.getSymbolO());
                Board.createBoardGame();

                if (whoPlayerwin(player1.getSymbolX())) {
                    System.out.println("player1 win");
                    break;
                } else if (whoPlayerwin(player2.getSymbolO())) {
                    System.out.println("player 2 win");
                    break;
                }

            } else if (player1Symbol.equalsIgnoreCase("O")) {

                player1.setSymbolO('O');
                player2.setSymbolX('X');
                player1Move(player1Index, player1.getSymbolO());
                player2Move(player2Index, player2.getSymbolO());

                Board.createBoardGame();
                if (whoPlayerwin(player1.getSymbolO())) {
                    System.out.println("player1 win");
                    break;
                } else if (whoPlayerwin(player2.getSymbolX())) {
                    System.out.println("player 2 win");
                    break;
                }

            }
            System.out.println(checkIfDraw());
        }
    }
}
