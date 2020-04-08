package com.company;

import javax.swing.*;

public class Tester {
    public static void main(String[] args) {
        Hand h = new Hand();
        Card card = new Card(7,"7");
        Card card1 = new Card(9,"9");
        h.AddCard(card);
        h.AddCard(card1);
        System.out.println(h.toString());
        int input;
        JFrame frame = new JFrame("Twenty One");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        String name = (String)JOptionPane.showInputDialog(
                frame,
                "Enter your name:",
                "User's name",
                JOptionPane.QUESTION_MESSAGE);
        GameGui twentyOne = new GameGui(name,1);
        frame.add(twentyOne);
        frame.setVisible(true);

        input = 0;
        while(!twentyOne.isGameOver() && input != 2){
             input = JOptionPane.showConfirmDialog(null,
                    "Do you want to take another card?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
             twentyOne.PullCards(input);

        }

    }
}
