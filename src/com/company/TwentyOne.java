package com.company;

import javax.swing.*;

public class TwentyOne{
        public static void main(String[] args) {
            int input;
            JFrame frame = new JFrame("Twenty One");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 400);
            String name = JOptionPane.showInputDialog(
                    frame,
                    "Enter your name:",
                    "User's name",
                    JOptionPane.QUESTION_MESSAGE);
            GameGui twentyOne = new GameGui(name,1);
            frame.add(twentyOne);
            frame.setVisible(true);

            while(!twentyOne.isGameOver()){
                input = JOptionPane.showConfirmDialog(null,
                        "Do you want to take another card?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
                twentyOne.PullCards(input);
            }
        }
}
