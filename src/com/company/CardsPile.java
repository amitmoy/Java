package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class CardsPile {
    protected ArrayList<Card> cards;
    protected int numOfCards;

    public CardsPile(){
        cards = new ArrayList<Card>();
        numOfCards = 0;
    }

    public void AddCard(Card card){
        cards.add(card);
        numOfCards++;
    }

    public void RemoveCard(Card card){
        cards.remove(card);
        numOfCards--;
    }

    public int getnumOfCards(){
        return numOfCards;
    }

    public void ScrumbleDeck() {
        Random rand = new Random();
        for(int i=0; i<numOfCards;i++) {
            Collections.swap(cards,i,rand.nextInt(numOfCards));
        }
    }

    public boolean IsEmpty(){
        return numOfCards==0;
    }
    protected ArrayList<Card> getCards(){
        return cards;
    }
    public String toString(){
        String tmp = "Number of Cards: " + numOfCards + ", The cards are:";
        for (Card i:cards
             ) {
            tmp+=" |" + i.getSymbol()+"|";
        }
        return tmp;
    }
}
