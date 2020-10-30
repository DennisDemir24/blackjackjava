package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public void NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        a_player.DealCard(a_deck.GetCard(), true);
        a_dealer.DealCard(a_deck.GetCard(), true);
        a_player.DealCard(a_deck.GetCard(), true);

    }
}
