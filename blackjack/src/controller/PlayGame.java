package controller;

import model.Game;
import model.rules.IObserver;
import view.IView;

public class PlayGame implements IObserver {
    private Game game;
    private IView view;

    public PlayGame(Game a_game, IView a_view)  {
        game = a_game;
        view = a_view;
        game.addObserver(this);
    }

    public boolean Play() {
        view.DisplayWelcomeMessage();

        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

        if (game.IsGameOver())
        {
            view.DisplayGameOver(game.IsDealerWinner());
        }

        GameActions input = view.GetInput();

        switch (input) {
            case PLAY:
                game.NewGame();
                break;
            case HIT:
                game.Hit();
                break;
            case STAND:
                game.Stand();
                break;
            case QUIT:
                return false;
            case DEFAULT:
            default:
                break;
        }
        return true;
    }

    @Override
    public void update() {
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

    }

}
