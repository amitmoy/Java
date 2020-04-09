package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class CardsPile {
    protected ArrayList<Card> cards;
    protected int numOfCards;

    public CardsPile(){
        cards = new ArrayList<>();
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

    //This function scrumbles the cards in the deck by generating random index for each card and switch their places
    public void ScrumbleDeck() {
        Random rand = new Random();
        for(int i=0; i<numOfCards;i++) {
            Collections.swap(cards,i,rand.nextInt(numOfCards));
        }
    }

    public boolean IsEmpty(){ return numOfCards==0; }

    public ArrayList<Card> getCards(){ return cards; }
    public int getnumOfCards(){ return numOfCards; }
    public String toString(){
        String tmp = "Number of Cards: " + numOfCards + ", The cards are:";
        for (Card i:cards
             ) {
            tmp+=" |" + i.getSymbol()+"|";
        }
        return tmp;
    }
}
