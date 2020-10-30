package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

public interface INewGameStrategy {
    void NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}
