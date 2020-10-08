package model.rules;

import java.util.Random;

public class WinGameStrategy implements IWinStrategy {
    private int equalHitLimit = 21;

    @Override
    public boolean isDealerWinner(int dealerScore, int playerScore) {
        Random gen = new Random();

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
            if (winner == 0) {
                return false;
            }
        } return true;
    }
}

