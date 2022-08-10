package com.tictactoeLogic;
import java.util.ArrayList;
public class Player {
    private String name;
    private char symbolX;
    private char symbolO;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
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
    
}
