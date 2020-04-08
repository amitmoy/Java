package com.company;

import java.awt.*;

public class GameBoard {
    private Player pc;
    private Player user;
    private Deck deck;
    private boolean gameOver;

    public GameBoard(String username, int numberOfDecks){
        pc = new Player("Computer");
        user = new Player(username);
        deck = new Deck(numberOfDecks);
        deck.ScrumbleDeck();
        gameOver = false;
    }


    public void PullCards(int choice){
        if(!deck.IsEmpty()) {
            if (choice == 0) //user choice was to pull card
                user.PullCard(deck.Pull());
        } else {
            System.out.println("Deck out of Cards");
            gameOver = true;
        }
    }
    public void PcPullUntill(int n){
        while(pc.getHandValue()<=n){
            pc.PullCard(deck.Pull());
        }
    }
    public Player BetterHand(){
        if(user.isBurned()){
            if(pc.isBurned()) {
                return null;
            } else {
                return pc;
            }
        } else {
            if(pc.isBurned()){
                return user;
            } else {
                if(user.getHandValue()>pc.getHandValue()){
                    return user;
                } else if(user.getHandValue()<pc.getHandValue()){
                    return pc;
                } else {
                    return null;
                }
            }
        }
    }

    public void DrawBoard(Graphics g, int w, int h){
        if(gameOver)
            pc.DrawPlayer(g,5, 45);

        else {
            g.setFont(new Font("arial",Font.ITALIC, 14));
            g.drawString("Computer's hand value: ?",5,45);
        }

        user.DrawPlayer(g,5,h-30);
    }
    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean bol){gameOver = bol;}
    public Player getPc(){ return pc; }
    public Player getUser(){ return user; }
    public Deck getDeck(){ return deck; }
    public void setPc(Player newPlayer){pc = newPlayer;}
    public void setUser(Player newPlayer){user = newPlayer;}
    public void setDeck(Deck newDeck){ deck = newDeck;}
    public String toString(){return "Players info: \n" + pc.toString() + "\n" + user.toString() +"\nDeck info: "+deck.toString();}
}
