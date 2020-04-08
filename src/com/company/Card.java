package com.company;

public class Card {
    private int value;
    private String symbol;

    public Card(int Value, String Symbol){
        value = Value;
        symbol = Symbol;
    }

    public void setValue(int val){
        value = val;
    }

    public int getValue(){
        return value;
    }

    public void setSymbol(String Symbol){
        symbol = Symbol;
    }

    public String getSymbol(){
        return symbol;
    }
     public String toString(){
        return "Value: " + value + ", Symbol: " +symbol;
     }
}
