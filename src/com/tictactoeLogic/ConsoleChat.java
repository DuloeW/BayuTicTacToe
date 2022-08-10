package com.tictactoeLogic;

public class ConsoleChat{

    public static void wellcome() {
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("\t\tWellcome My Friends");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    public static void goodBye() {
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("\tThank You");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++\n");
    }

    public static void congratulations(String winner) {
        System.out.println("Congrats " + winner + " you are the winner");
    }

    public static void niceTry(String looser) {
        System.out.println("Nice try " + looser + ", keep smile :) ");
    }

    //public static void 

}
