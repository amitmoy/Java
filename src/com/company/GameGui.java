package com.company;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JPanel {
    private GameBoard game;

    public GameGui(String username,int numOfDecks){
        game = new GameBoard(username,numOfDecks);
        game.PcPullUntill(17);
        PullCards(0);
        PullCards(0);
    }
    public void PullCards(int choice){
            game.PullCards(choice);
            repaint();
    }
    public boolean isGameOver(){ return game.isGameOver();}
    public void setGameOver(boolean bol){ game.setGameOver(bol);}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        game.DrawBoard(g,w,h);
    }
}
