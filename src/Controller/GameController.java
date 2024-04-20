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
            if (verb.equalsIgnoreCase("n")) {

            } else if (verb.equalsIgnoreCase("e")) {

            } else if (verb.equalsIgnoreCase("S")) {

            } else if (verb.equalsIgnoreCase("W")) {

            } else if (verb.equalsIgnoreCase("Explore")) {

            }
            else if(verb.equalsIgnoreCase("Inventory")){

            }
            else if(verb.equalsIgnoreCase("Stats")){

            }
            else if(verb.equalsIgnoreCase("Un-equip")){

            }
            else if(verb.equalsIgnoreCase("commands")){

            }
            else if(verb.equalsIgnoreCase("Exit")){
                System.exit(0);
            }
            else{
                gameView.wrongCommand();
            }
        }
        if (command.length == 2){
            object = command[1];
            if(verb.equalsIgnoreCase("Move")){
                if(object.equalsIgnoreCase("North")){
                    gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getN()));
                }
                else if(object.equalsIgnoreCase("East")){
                    gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getE()));
                }
                else if(object.equalsIgnoreCase("South")){
                    gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getS()));
                }
                else if(object.equalsIgnoreCase("West")){
                    gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getW()));
                }
            }
            else {
                gameView.wrongCommand();
            }
        }
    }
}
