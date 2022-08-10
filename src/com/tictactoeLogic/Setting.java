package com.tictactoeLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class Setting extends Board {
    private char[][] newBoardGame = getBoard();
    private ArrayList<Integer> player1IndexMove = new ArrayList<Integer>();
    private ArrayList<Integer> player2IndexMove = new ArrayList<Integer>();

    private void playerMove(int index, char symbol) {
        switch (index) {
            case 1:
                newBoardGame[0][0] = symbol;
                break;
            case 2:
                newBoardGame[0][1] = symbol;
                break;
            case 3:
                newBoardGame[0][2] = symbol;
                break;
            case 4:
                newBoardGame[1][0] = symbol;
                break;
            case 5:
                newBoardGame[1][1] = symbol;
                break;
            case 6:
                newBoardGame[1][2] = symbol;
                break;
            case 7:
                newBoardGame[2][0] = symbol;
                break;
            case 8:
                newBoardGame[2][1] = symbol;
                break;
            case 9:
                newBoardGame[2][2] = symbol;
                break;
            default:
                break;
        }

    }

    private void setPlayer1IndexMove(int index) {
        this.player1IndexMove.add(index);
    }

    private ArrayList getPlayer1IndexMove() {
        return this.player1IndexMove;
    }

    private void setPlayer2IndexMove(int index) {
        this.player2IndexMove.add(index);
    }

    private ArrayList getPlayer2IndexMove() {
        return this.player2IndexMove;
    }

    private boolean isDraw() {
        boolean isDraw = true;
        if ((newBoardGame[0][0] == ' ') || (newBoardGame[0][1] == ' ') || (newBoardGame[0][2] == ' ') ||
                (newBoardGame[1][0] == ' ') || (newBoardGame[1][1] != ' ') || (newBoardGame[1][2] == ' ') ||
                (newBoardGame[2][0] == ' ') || (newBoardGame[2][1] == ' ') || (newBoardGame[2][2] == ' ')) {
            isDraw = false;
            return isDraw;
        }
        return isDraw;
    }

    private boolean whoPlayerwin(char symbol) {
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

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (Exception e) {
            System.err.println("Error because : " + e.getMessage());
        }
    }

    public void playerTurn() {
        int player1Index, player2Index;
        String player1Name, player2Name, player1Symbol, player2Symbol;
        Scanner userInput = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        ConsoleChat alert = new ConsoleChat();

        displayTemplateBoard();

        System.out.print("Enter fist player name\t: ");
        player1Name = userInput.nextLine();
        player1.setName(player1Name);

        System.out.print("Enter fist player choise [X/O]: ");
        player1Symbol = userInput.nextLine();

        System.out.print("\nEnter second player name\t: ");
        player2Name = userInput.nextLine();
        player2.setName(player2Name);

        if (player1Symbol.equalsIgnoreCase("X")) {
            player1.setSymbolX('X');
            player2.setSymbolO('O');

            while (true) {

                if (player1IndexMove.size() < 4 && player2IndexMove.size() < 4) {
                    System.out.print("Enter " + player1.getName() + " [1-9] : ");
                    player1Index = userInput.nextInt();
                    setPlayer1IndexMove(player1Index);

                    System.out.print("Enter " + player2.getName() + " [1-9] : ");
                    player2Index = userInput.nextInt();
                    setPlayer2IndexMove(player2Index);

                    if (!getPlayer1IndexMove().contains(player2Index) || !getPlayer2IndexMove().contains(player1Index)) {

                        playerMove(player1Index, player1.getSymbolX());
                        playerMove(player2Index, player2.getSymbolO());
                        clearScreen();
                        createBoardGame();

                    } else {

                        while (getPlayer1IndexMove().contains(player2Index) && getPlayer2IndexMove().contains(player1Index)) {

                            System.out.println("Can't input same index");
                            System.out.print("Enter " + player1.getName() + " [1-9] : ");
                            player1Index = userInput.nextInt();
                            setPlayer1IndexMove(player1Index);

                            System.out.print("Enter " + player2.getName() + " [1-9] : ");
                            player2Index = userInput.nextInt();
                            setPlayer2IndexMove(player2Index);


                            if (!getPlayer1IndexMove().contains(player2Index) || !getPlayer2IndexMove().contains(player1Index)) {
                                playerMove(player1Index, player1.getSymbolX());
                                playerMove(player2Index, player2.getSymbolO());
                                clearScreen();
                                createBoardGame();
                            } else {
                                clearScreen();
                                createBoardGame();
                            }

                        }
                    }
                } else {

                    if (whoPlayerwin(player1.getSymbolX())) {
                        ConsoleChat.congratulations(player1.getName());
                        ConsoleChat.niceTry(player2.getName());
                        break;
                    } else if (whoPlayerwin(player2.getSymbolO())) {
                        ConsoleChat.congratulations(player2.getName());
                        ConsoleChat.niceTry(player1.getName());
                        break;
                    } else {
                        System.out.println("Draw");
                        break;
                    }

                }
            }
        } else if (player1Symbol.equalsIgnoreCase("O")) {
            player1.setSymbolO('O');
            player2.setSymbolX('X');

            while (true) {

                if (player1IndexMove.size() < 4 && player2IndexMove.size() < 4) {
                    System.out.print("Enter " + player1.getName() + " [1-9] : ");
                    player1Index = userInput.nextInt();
                    setPlayer1IndexMove(player1Index);

                    System.out.print("Enter " + player2.getName() + " [1-9] : ");
                    player2Index = userInput.nextInt();
                    setPlayer2IndexMove(player2Index);

                    if (!getPlayer1IndexMove().contains(player2Index) || !getPlayer2IndexMove().contains(player1Index)) {

                        playerMove(player1Index, player1.getSymbolO());
                        playerMove(player2Index, player2.getSymbolX());
                        clearScreen();
                        createBoardGame();

                    } else {

                        while (getPlayer1IndexMove().contains(player2Index) && getPlayer2IndexMove().contains(player1Index)) {

                            System.out.println("Can't input same index");
                            System.out.print("Enter " + player1.getName() + " [1-9] : ");
                            player1Index = userInput.nextInt();
                            setPlayer1IndexMove(player1Index);

                            System.out.print("Enter " + player2.getName() + " [1-9] : ");
                            player2Index = userInput.nextInt();
                            setPlayer2IndexMove(player2Index);


                            if (!getPlayer1IndexMove().contains(player2Index) || !getPlayer2IndexMove().contains(player1Index)) {
                                playerMove(player1Index, player1.getSymbolO());
                                playerMove(player2Index, player2.getSymbolX());
                                clearScreen();
                                createBoardGame();
                            } else {
                                clearScreen();
                                createBoardGame();
                            }

                        }
                    }

                } else {

                    if (whoPlayerwin(player1.getSymbolX())) {
                        ConsoleChat.congratulations(player1.getName());
                        ConsoleChat.niceTry(player2.getName());
                        break;
                    } else if (whoPlayerwin(player2.getSymbolO())) {
                        ConsoleChat.congratulations(player2.getName());
                        ConsoleChat.niceTry(player1.getName());
                        break;
                    } else {
                        System.out.println("Draw");
                        break;
                    }

                }
            }
        }
    }
}
