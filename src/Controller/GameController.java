package Controller;

import Model.GameModel;
import View.GameView;

public class GameController {
    GameView gameView;
    GameModel gameModel;

    public GameController(GameModel aGameModel, GameView aGameView){
        this.gameModel = aGameModel;
        this.gameView = aGameView;
        gameStart();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void gameStart(){
        gameView.welcome();
        gameView.updateView("You are now in " + gameModel.getPlayer().getCurRoom().getName());
    }
}
