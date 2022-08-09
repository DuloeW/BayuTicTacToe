package com.tictactoeLogic;

public class Player {
    private String name;
    private char symbolX;
    private char symbolO;

    public Player(String name) {
        this.name = name;
    }
    public void setSymbolX(char x){
        this.symbolX = x;
    }

    public void setSymbolO(char o){
        this.symbolO = o;
    }

    public char getSymbolX() {
        return this.symbolX;
    }

    public char getSymbolO() {
        return this.symbolO;
    }

    public String getName() {
        return this.name;
    }
    
}
