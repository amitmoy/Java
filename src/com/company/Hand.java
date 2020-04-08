package com.company;

public class Hand extends CardsPile {
    private int value;

    public Hand(){
        super();
        value = 0;
    }

    public int getValue(){
        return value;
    }

    public void AddCard(Card card){
        cards.add(card);
        numOfCards++;
        value+=card.getValue();
    }

    public void RemoveCard(Card card){
        cards.remove(card);
        numOfCards--;
        value-=card.getValue();
    }

    public Card SearchCard(String sym){
        for (Card i:cards
             ) {
            if(i.getSymbol().equals(sym))
                return i;
        }
        return null;
    }

    public boolean isGreaterThan(Hand other){
        return this.getValue()>other.getValue();
    }

    public boolean isGreaterThan(int num){
        return this.getValue()>num;
    }

    public String toString(){
        return super.toString() + ", Value of hand is: " +value;
    }

}
