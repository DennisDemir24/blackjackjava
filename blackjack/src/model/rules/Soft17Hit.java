package model.rules;

import model.Player;

public class Soft17Hit implements IHitStrategy {

    @Override
    public boolean DoHit(Player a_dealer) {
        int hitLimit = 17;
        if (a_dealer.CalcScore() < hitLimit) {
            return true;
        }

        return hitLimit == a_dealer.CalcScore() && a_dealer.checkForAce();
    }
}
