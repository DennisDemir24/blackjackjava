package view;

import controller.GameActions;
import model.Card;

public class SimpleView implements IView {
    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }

        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public GameActions GetInput() {
        return getGameActions();
    }

    static GameActions getGameActions() {
        try {
            int c = System.in.read();

            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }

            switch (c) {
                case 'p':
                    return GameActions.PLAY;
                case 'h':
                    return GameActions.HIT;
                case 's':
                    return GameActions.STAND;
                case 'q':
                    return GameActions.QUIT;
                default:
                    return GameActions.DEFAULT;
            }
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return GameActions.DEFAULT;
        }
    }

    public void DisplayCard(Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<Card> a_hand, int a_score) {
        
        System.out.println(a_name + " Has: ");

        for (Card c : a_hand) {
            DisplayCard(c);
        }

        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }
    }
}
