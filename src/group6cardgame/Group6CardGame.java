/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group6cardgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class Group6CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //-Setup-
        //2 players
        //split deck between player [player can't see cards until they are played]
        //players each place their first card face up 
        //higher number wins and gains the cards (1 roundWin)
        // if cards match, they go into war
        //-in war- 
        //each player drops 3 facedown card (warDiscard)
        //winner gets all the cards used (warWin + roundWin [the points are seperated incase war happens twice])
        /**
         * game ends when there are no more cards or when a player exceeds 26
         * points [once 26 points is reached the losing player can never catch
         * up]; whichever comes first
         */
        boolean gameOver = false;

        Scanner in = new Scanner(System.in);
        Deck d = new Deck();
        ArrayList<Card> hand1 = new ArrayList<>(d.dealPlayerOne());

        ArrayList<Card> hand2 = new ArrayList<>(d.dealPlayerTwo());

        Player p1 = new Player(hand1);
        Player p2 = new Player(hand2);

        do {

            boolean war = false;

            Card c1 = p1.playCard();
            Card c2 = p2.playCard();

            System.out.println("P1: " + c1.toString() + "\n");
            System.out.println("P2: " + c2.toString() + "\n");

            war = c1.getValue().ordinal() == c2.getValue().ordinal();

            while (war == true) {
                System.out.println("WAR!!!");
                p1.WarDiscard();
                p2.WarDiscard();

                System.out.println("Both Players drop 3 more card face down and play a new card");

                c1 = p1.playCard();
                c2 = p2.playCard();

                System.out.println("");

                System.out.println("P1: " + c1.toString() + "\n");
                System.out.println("P2: " + c2.toString() + "\n");
                
                if (c1.getValue().ordinal() > c2.getValue().ordinal()) {
                    p1.warWin();
                    System.out.println("Player 1 Wins 8 points!\n");

                    war = false;
                } else if (c1.getValue().ordinal() < c2.getValue().ordinal()) {
                    p2.warWin();
                    System.out.println("Player 2 Wins 8 points!\n");
                    war = false;
                }

            }

            if (war == false) {
                if (c1.getValue().ordinal() > c2.getValue().ordinal()) {
                    p1.roundWin();
                    System.out.println("Player 1 Wins 2 points!\n");
                } else {
                    p2.roundWin();
                    System.out.println("Player 2 Wins 2 points!\n");
                }
            }

            System.out.println("Player 1 points: " + p1.getPoints());
            System.out.println("Player 2 points: " + p2.getPoints());
            System.out.println("------------------------------------\n");

            if (p1.getPoints() >= 26) {
                System.out.println("Player 1 WINS THE GAME!!!\n");
                gameOver = true;
            } else if (p2.getPoints() >= 26) {
                System.out.println("Player 2 WINS THE GAME!!!\n");
                gameOver = true;
            }

        } while (gameOver == false);

        System.out.println("GAME OVER");
    }

}
