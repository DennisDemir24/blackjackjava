package model.rules;

import model.Player;

public class Soft17Hit implements IHitStrategy {
    private final int hitlimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScore() < hitlimit) {
            return true;
        }

        if (hitlimit == a_dealer.CalcScore() && a_dealer.checkForAce()) {
            return true;
        }
        return false;
    }
}
