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

    //Pull cards to user when deck is not empty and user choosed option 0
    public void PullCards(int choice){
        if(!deck.IsEmpty()) {
            if (choice == 0) {//user choice was to pull card
                user.PullCard(deck.Pull());
                if (user.isBurned())
                    gameOver = true;
            } else {
                gameOver = true;
            }
        } else {
            System.out.println("Deck out of Cards");
            gameOver = true;
        }
    }
    //Its pulling cards to the computer's hand until its value reach n
    public void PcPullUntill(int n){
        while(pc.getHandValue()<=n){
            pc.PullCard(deck.Pull());
        }
    }

    //returns the winner hand.
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

    //Drawing the game board by getting the right weight and height from JPanel object.
    public void DrawBoard(Graphics g, int w, int h){
        if(gameOver) {
            pc.DrawPlayer(g, 5, 45);
            g.setFont(new Font("arial",Font.BOLD, 14));
            Player winner = BetterHand();
            if(winner == null){
                g.drawString("Its tie",w/2,h/2);
            } else {
                g.drawString("The Winner is:"+winner.getName(),w/2-50,h/2);
            }
        } else {
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
