import Controller.GameController;
import Model.GameModel;
import View.GameView;

import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
    }
}