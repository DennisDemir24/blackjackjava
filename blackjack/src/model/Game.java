package model;

import model.rules.IObserver;
import model.rules.RulesFactory;

public class Game {

    private Dealer m_dealer;
    private Player m_player;

    public Game() {
        m_dealer = new Dealer(new RulesFactory());
        m_player = new Player();
    }

    public void addObserver(IObserver obs) {
        m_dealer.addObserver(obs);
        m_player.addObserver(obs);
    }


    public boolean IsGameOver()
    {
        return m_dealer.IsGameOver();
    }

    public boolean IsDealerWinner()
    {
        return m_dealer.IsDealerWinner(m_player);
    }

    public void NewGame()
    {
        m_dealer.NewGame(m_player);
    }

    public void Hit()
    {
        m_dealer.Hit(m_player);
    }

    public void Stand() {
        // TODO: Implement this according to Game_Stand.sequencediagram
        m_dealer.Stand();
    }

    public Iterable<Card> GetDealerHand()
    {
        return m_dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand()
    {
        return m_player.GetHand();
    }

    public int GetDealerScore()
    {
        return m_dealer.CalcScore();
    }

    public int GetPlayerScore()
    {
        return m_player.CalcScore();
    }


}
