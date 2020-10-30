package model.rules;

import java.util.Random;

public class WinGameStrategy implements IWinStrategy {

    @Override
    public boolean isDealerWinner(int dealerScore, int playerScore) {
        Random gen = new Random();

        int equalHitLimit = 21;
        if (dealerScore < playerScore && playerScore <= equalHitLimit) {
            return false;
        } else if (dealerScore > playerScore && dealerScore <= equalHitLimit) {
            return true;
        } else if (dealerScore == playerScore && playerScore == equalHitLimit) {
            return false;
        } else if (dealerScore > equalHitLimit && playerScore <= equalHitLimit) {
            return false;
        } else if (dealerScore == playerScore && dealerScore < equalHitLimit) {
            int winner = gen.nextInt(2);
            return winner != 0;
        } return true;
    }
}

