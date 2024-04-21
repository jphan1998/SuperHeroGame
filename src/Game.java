/* Class created by Jimmy
 * All Methods created by Jimmy
 */
import Controller.GameController;
import Model.GameModel;
import View.GameView;

import java.io.FileNotFoundException;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
    }
}