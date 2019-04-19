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
package group6cardgame;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author owner
 */
public class Group6CardGame {

    /**
     * @param args the command line arguments
     */
    private static boolean war = false;
    private static Player p1;
    private static Player p2;
    private static Card c1;
    private static Card c2;
    private static boolean gameOver = false;

    public static void main(String[] args) throws IOException {
        Deck d = new Deck();
        ArrayList<Card> hand1 = new ArrayList<>(d.dealPlayerOne());
        ArrayList<Card> hand2 = new ArrayList<>(d.dealPlayerTwo());
        p1 = new Player(hand1);
        p2 = new Player(hand2);
        while (gameOver == false) {

            c1 = p1.playCard();

            c2 = p2.playCard();

            System.out.println("P1: " + c1.toString() + "\n");
            System.out.println("P2: " + c2.toString() + "\n");

            war = c1.getValue().ordinal() == c2.getValue().ordinal();
            if (war == true) {
                System.out.println("WAR!!!");
                warDeckSize(p1.hand.size());
                p1.WarDiscard();
                warDeckSize(p2.hand.size());
                p2.WarDiscard();
                System.out.println("Both Players drop 3 more card face down and play a new card\n");
                c1 = p1.playCard();
                c2 = p2.playCard();
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
            } else {
                if (c1.getValue().ordinal() > c2.getValue().ordinal()) {
                    p1.roundWin();
                    System.out.println("Player 1 Wins 2 points!\n");
                    war = false;
                } else {
                    p2.roundWin();
                    System.out.println("Player 2 Wins 2 points!\n");
                    war = false;
                }
            }

            System.out.println("Player 1 points: " + p1.getPoints());
            System.out.println("Player 2 points: " + p2.getPoints());
            System.out.println("------------------------------------\n");

            System.out.println("Press any key to continue");
            System.in.read();
            deckSize(p1.getHandSize());
            deckSize(p2.getHandSize());
            winCon(p1.getPoints(), p2.getPoints());
        }
        System.out.println("GAME OVER");
        System.exit(0);
    }

    public static boolean winCon(int p1, int p2) {
        if (p1 >= 26) {
            System.out.println("Player 1 WINS THE GAME!!!\n");
            gameOver = true;
        } else if (p2 >= 26) {
            System.out.println("Player 2 WINS THE GAME!!!\n");
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }

    public static boolean warDeckSize(int size) {
        if (size <= 4) {
            System.out.println("Player does not have any more cards\n"
                    + "Game Over!\n"
                    + "Player with the highest points wins!");
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }

    public static boolean deckSize(int size) {
        if (size <= 2) {
            System.out.println("Player does not have any more cards\n"
                    + "Game Over!\n"
                    + "Player with the highest points wins!");
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }
}
