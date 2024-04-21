package Model;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Player {
    private String name;
    private MapReader gameMap;
    private Room curRoom;
    private Room prevRoom;
    private int HP;
    private int CR;
    private Map<String, Item> inventory;
    private Map<String, Item> gear;

    public Player(String aName, MapReader aGameMap){
        HP = 15;
        CR = 2;
        this.name = aName;
        this.gameMap = aGameMap;
        curRoom = gameMap.getRoom("F1R1");
        inventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        gear = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public String move(String roomId)
    {
        String room;
        if (gameMap.getGameMap().containsKey(roomId))
        {
            curRoom.setVisited(true);
            prevRoom = curRoom;
            this.curRoom = gameMap.getRoom(roomId);
            room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
            return room;
        }
        else
        {
            return "No room";
        }
    }

    public String solvePuzzle() {
        int prevAttempt = curRoom.getPuzzle().getAttempts();
        if (!curRoom.getPuzzle().isSolved()) {
            Scanner in = new Scanner(System.in);
            for (int i = curRoom.getPuzzle().getAttempts(); i > 0; i--) {
                String input = in.nextLine();
                if (!input.toLowerCase().contains(curRoom.getPuzzle().solution.toLowerCase())) {
                    System.out.println("The answer you have provided is wrong, you still have " + (i - 1) + " left. Try one more time.");
                } else {
                    curRoom.getPuzzle().setSolved(true);
                    return "Solved";
                }
            }
            curRoom.getPuzzle().setAttempts(prevAttempt);
        }
        return "Failed";
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapReader getGameMap() {
        return gameMap;
    }

    public void setGameMap(MapReader gameMap) {
        this.gameMap = gameMap;
    }

    public Room getCurRoom() {
        return curRoom;
    }

    public void setCurRoom(Room curRoom) {
        this.curRoom = curRoom;
    }

    public Room getPrevRoom() {
        return prevRoom;
    }

    public void setPrevRoom(Room prevRoom) {
        this.prevRoom = prevRoom;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getCR() {
        return CR;
    }

    public void setCR(int CR) {
        this.CR = CR;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Item> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Item> getGear() {
        return gear;
    }

    public void setGear(Map<String, Item> gear) {
        this.gear = gear;
    }

    public void consume(String name) {
        if (inventory.get(name) instanceof Consumables) {
            HP += ((Consumables) inventory.get(name)).getcAmount();
            System.out.println("You have consumed " + name);
        }
    }


    public String equip(String name) {
        if (inventory.get(name) instanceof Equipment) {
            CR += ((Equipment) inventory.get(name)).geteAmount();
            return name;
        } else {
            return "Wrong";
        }
    }


    public String read(String name) {
        if (inventory.get(name) instanceof Item) {
            return curRoom.getPuzzle().getHint();
        }
    }



    /*public void use(){
        if(inventory.containsKey()){

        }else if (inventory.containsKey()){

        }
    }


}
