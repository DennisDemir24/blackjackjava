package model;

import model.rules.*;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IWinStrategy m_winRule;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.getNewWinRule();
    }


    public void NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            m_newGameRule.NewGame(m_deck, this, a_player);
        }
    }

    public void Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            a_player.DealCard(m_deck.GetCard(), true);
        }
    }

    public void Stand() {
        if (m_deck != null) {
            ShowHand();

            while (m_hitRule.DoHit(this)) {
                Hit(this);
            }
        }
    }

    public boolean IsDealerWinner(Player a_player) {
        return m_winRule.isDealerWinner(this.CalcScore(), a_player.CalcScore());
    }

    public boolean IsGameOver() {
        return m_deck != null && !m_hitRule.DoHit(this);
    }

}
