package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck extends CardsPile {
    public Deck(int numOfDecks){
        super();
        for(;numOfDecks>0;numOfDecks--) {
            for (int i = 0; i < 4; i++) {
                for (int j = 2; j <= 10; j++)
                    AddCard(new Card(j, String.valueOf(j)));
                AddCard(new Card(10, "K"));
                AddCard(new Card(10, "Q"));
                AddCard(new Card(10, "J"));
                AddCard(new Card(1, "ACE"));
            }
        }
    }

    public void ScrumbleDeck() {
        Random rand = new Random();
        for(int i=0; i<numOfCards;i++) {
            Collections.swap(cards,i,rand.nextInt(numOfCards));
        }
    }

    public Card Pull(){
        if(numOfCards>0) {
            numOfCards--;
            return cards.remove(0);
        }
        return null;
    }

    public String toString(){
        return "Deck info: " +super.toString();
    }
}
