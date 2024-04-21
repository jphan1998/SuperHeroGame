package Controller;

import Model.GameModel;
import Model.Monster;
import View.GameView;
import java.io.*;

import java.util.Scanner;

public class GameController implements java.io.Serializable {
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
                if(gameModel.getPlayer().getInventory().isEmpty()){
                    gameView.emptyInv();
                }
                else{
                    gameView.invHead();
                    for(String name : gameModel.getPlayer().getInventory().keySet()){
                        gameView.viewInv(name);
                    }
                }
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
            else if (verb.equalsIgnoreCase("Save")) {
                saveGame();
                gameView.saveGame();
            } else if (verb.equalsIgnoreCase("Load")) {
                loadGame();
                gameView.loadGame();
                // Display the current room after loading the game
                gameView.updateView("You are now in " + gameModel.getPlayer().getCurRoom().getName() + "\n" + gameModel.getPlayer().getCurRoom().getDescription());
            }
            else{
                gameView.wrongCommand();
            }
        }
        if (command.length == 2){
            object = command[1];
            if(verb.equalsIgnoreCase("Move")){
                if(object.equalsIgnoreCase("North")){
                    if(gameModel.getPlayer().getGameMap().getGameMap().containsKey(gameModel.getPlayer().getCurRoom().getN())) {
                        if (gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getN()).getIsLocked()) {
                            gameView.lockedRoom();
                        } else {
                            gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getN()));
                        }
                    }
                    else{
                        gameView.updateView("No room");
                    }
                }
                else if(object.equalsIgnoreCase("East")){
                    if(gameModel.getPlayer().getGameMap().getGameMap().containsKey(gameModel.getPlayer().getCurRoom().getE())) {
                        if (gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getE()).getIsLocked()) {
                            gameView.lockedRoom();
                        } else {
                            gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getE()));
                        }
                    }
                    else{
                        gameView.updateView("No room");
                    }
                }
                else if(object.equalsIgnoreCase("South")){
                    if(gameModel.getPlayer().getGameMap().getGameMap().containsKey(gameModel.getPlayer().getCurRoom().getS())) {
                        if (gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getS()).getIsLocked()) {
                            gameView.lockedRoom();
                        } else {
                            gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getS()));
                        }
                    }
                    else{
                        gameView.updateView("No room");
                    }
                }
                else if(object.equalsIgnoreCase("West")){
                    if(gameModel.getPlayer().getGameMap().getGameMap().containsKey(gameModel.getPlayer().getCurRoom().getW())) {
                        if (gameModel.getPlayer().getGameMap().getRoom(gameModel.getPlayer().getCurRoom().getW()).getIsLocked()) {
                            gameView.lockedRoom();
                        } else {
                            gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getCurRoom().getW()));
                        }
                    }
                    else{
                        gameView.updateView("No room");
                    }
                }
            }
            else if(verb.equalsIgnoreCase("Solve")){
                if(object.equalsIgnoreCase("Puzzle")){
                    if(gameModel.getPlayer().getCurRoom().getPuzzle() == null){
                        gameView.noPuzzle();
                    }
                    else {
                        if (gameModel.getPlayer().getInventory().containsKey("Torch")) {
                            gameView.displayPuzzle(gameModel.getPlayer().getCurRoom().getPuzzle().getName(), gameModel.getPlayer().getCurRoom().getPuzzle().getDesc());
                            gameView.puzzleResults(gameModel.getPlayer().solvePuzzle());
                            if (!gameModel.getPlayer().getCurRoom().getPuzzle().isSolved()) {
                                gameView.updateView(gameModel.getPlayer().move(gameModel.getPlayer().getPrevRoom().getRoomID()));
                            }
                            gameModel.getPlayer().getCurRoom().setPuzzle(null);
                        }
                        else{
                            gameView.noTorch();
                        }
                    }
                }
            }
            else if (verb.equalsIgnoreCase("Fight ")){
                String monsterName = input.substring(6).trim();

                if (gameModel.getPlayer().getCurRoom().getMonster().getName().equalsIgnoreCase(monsterName))
                {
                    Monster monster = gameModel.getPlayer().getCurRoom().getMonster();
                    gameView.encounterMonster();
                    boolean playerWon = gameModel.getPlayer().combatWithMonster(monster);
                    if (playerWon) {
                        gameModel.getPlayer().getCurRoom().removeMonster();
                        gameView.win();
                    }
                    else {
                        gameView.lose();
                        loadGame(); // Game over method
                        return;
                    }
                }

                else
                {
                    gameView.noMonster();
                }
            }
            else if(verb.equalsIgnoreCase("Equip")){
                if(gameModel.getPlayer().getInventory().containsKey(object)){
                    gameView.equip(gameModel.getPlayer().equip(object));
                }
                else{
                    gameView.notInv();
                }
            }else if(verb.equalsIgnoreCase("Consume")){
                if(gameModel.getPlayer().getInventory().containsKey(object)){
                    gameView.con(gameModel.getPlayer().consume(object));
                }
                else{
                    gameView.notInv();
                }
            } else if (verb.equalsIgnoreCase("Pickup")) {
                if(gameModel.getPlayer().getCurRoom().getInventory().containsKey(object)){
                    gameView.pickUp(gameModel.getPlayer().pickUpItem(object));
                }
                else{
                    gameView.noItem();
                }
            }else if (verb.equalsIgnoreCase("Drop")) {
                if(gameModel.getPlayer().getInventory().containsKey(object)){
                    gameView.drop(gameModel.getPlayer().dropItem(object));
                }
                else{
                    gameView.noItem();
                }
            }else if(verb.equalsIgnoreCase("Examine")){
                if(gameModel.getPlayer().getInventory().containsKey(object)){
                    gameView.examine(gameModel.getPlayer().examineItem(object));
                }
                else{
                    gameView.notInv();
                }

            }else if(verb.equalsIgnoreCase("Use")) {
                if (gameModel.getPlayer().getInventory().containsKey(object)) {
                    if ((gameModel.getPlayer().use(object).equalsIgnoreCase("hint"))) {
                        gameView.useItem(gameModel.getPlayer().use(object));
                        gameView.displayHint(gameModel.getPlayer().getCurRoom().getPuzzle().getHint());
                    } else {
                        gameView.useItem(gameModel.getPlayer().use(object));
                    }
                } else {
                    gameView.notInv();
                }
            }
            else if(verb.equalsIgnoreCase("Access")) {
                if(object.equalsIgnoreCase("Status")){
                    gameView.stats(gameModel.getPlayer().getHP(), gameModel.getPlayer().getCR());
                }
                else{
                    gameView.wrongCommand();
                }
            }
            else {
                gameView.wrongCommand();
            }
        }
    }

    public void saveGame() {
        try {
            FileOutputStream fileOut = new FileOutputStream("gameState.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameModel);
            out.close();
            fileOut.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream("gameState.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameModel = (GameModel) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
