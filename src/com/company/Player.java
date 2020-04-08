package com.company;

import java.awt.*;

public class Player {
    private Hand hand;
    private String name;

    public Player(String str){
        hand = new Hand();
        name = str;
    }

    public void setName(String str){
        name = str;
    }

    public String getName(){
        return name;
    }

    public boolean isBurned(){
        return hand.getValue()>21;
    }

    public int getHandValue(){
        int numOfAces=0;
        int value=0;

        for (Card i:hand.getCards()
             ) {
                value+=i.getValue();
                if(i.getSymbol().equals("ACE"))
                    numOfAces++;
        }

        for(int i=0; i<numOfAces;i++){
            if(value+10<=21)
                value+=10;
        }
        return value;
    }
    public void PullCard(Card c){
        getHand().AddCard(c);
    }

    public void DrawPlayer(Graphics g, int w, int h){
        String info = name + "'s hand value:" +getHandValue();
        g.setFont(new Font("arial",Font.ITALIC, 14));
        g.drawString(info,w,h);
        info ="";
        for (Card i:hand.getCards()
             ) {
            info+="|"+i.getSymbol()+"| ";
        }
        g.drawString(info,w,h+15);
    }
    public Hand getHand(){
        return hand;
    }
    public void setHand(Hand new_hand){
        hand = new_hand;
    }
    public String toString(){
        return name+"'s hand information: " + hand.toString();
    }
}
