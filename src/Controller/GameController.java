package Controller;

import Model.GameModel;
import View.GameView;

import java.util.Scanner;

public class GameController {
    GameView gameView;
    GameModel gameModel;
    Scanner in;

    public GameController(GameModel aGameModel, GameView aGameView) {
        in = new Scanner(System.in);
        this.gameModel = aGameModel;
        this.gameView = aGameView;
        gameStart();
        while(gameModel.getPlayer().getHP() > 0) {
            gamePlay();
        }
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

    public void gameStart() {
        gameView.welcome();
        gameView.updateView("You are now in " + gameModel.getPlayer().getCurRoom().getName() + "\n" + gameModel.getPlayer().getCurRoom().getDescription());
    }

    public void gamePlay(){
        String verb;
        String object;
        gameView.printView();
        if(gameModel.getPlayer().getCurRoom().getVisited()){
            gameView.hasVisited();
        }
        String input = in.nextLine();
        String[] command = input.split(" ", 2);
        verb = command[0];
        if (command.length == 1) {
            if(verb.equalsIgnoreCase("Inventory") || verb.equalsIgnoreCase("I")){

            } else if (verb.equalsIgnoreCase("Search"))
            {
                gameView.updateSearch(gameModel.getPlayer().getCurRoom().searchRoom());
            }
            else if(verb.equalsIgnoreCase("Exit")){
                System.exit(0);
            }
            else if(verb.equalsIgnoreCase("Locked")){
                gameView.isLocked(gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getRoomID()).getIsLocked());
            }
            else{
                gameView.wrongCommand();
            }
        }
        if (command.length == 2){
            object = command[1];
            if(verb.equalsIgnoreCase("Move")){
                if(object.equalsIgnoreCase("North")){
                    if(gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getN()).getIsLocked()){
                        gameView.lockedRoom();
                    }
                    else {
                        gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getN()));
                    }
                }
                else if(object.equalsIgnoreCase("East")){
                    if(gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getE()).getIsLocked()){
                        gameView.lockedRoom();
                    }
                    else {
                        gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getE()));
                    }
                }
                else if(object.equalsIgnoreCase("South")){
                    if(gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getS()).getIsLocked()){
                        gameView.lockedRoom();
                    }
                    else {
                        gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getS()));
                    }
                }
                else if(object.equalsIgnoreCase("West")){
                    if(gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getW()).getIsLocked()){
                        gameView.lockedRoom();
                    }
                    else {
                        gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getW()));
                    }
                }
            }
            else if(verb.equalsIgnoreCase("Solve")){
                if(object.equalsIgnoreCase("Puzzle")){
                    if(gameModel.getPlayer().getCurRoom().getPuzzle() == null){
                        gameView.noPuzzle();
                    }
                    else {
                        gameView.displayPuzzle(gameModel.getPlayer().getCurRoom().getPuzzle().getName(), gameModel.getPlayer().getCurRoom().getPuzzle().getDesc());
                        gameView.puzzleResults(gameModel.getPlayer().solvePuzzle());
                        if (!gameModel.getPlayer().getCurRoom().getPuzzle().isSolved()) {
                            gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getPrevRoom().getRoomID()));
                        }
                    }
                }
            }
            else {
                gameView.wrongCommand();
            }
        }
    }
}
