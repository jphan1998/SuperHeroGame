package Model;

import java.util.Map;
import java.util.TreeMap;

public class Player {
    String name;
    MapReader gameMap;
    private Room curRoom;
    private Room prevRoom;
    private int HP;
    private int CR;
    private Map<String, Item> inventory;
    private Map<String, Item> gear;

    public Player(String aName, MapReader aGameMap){
        this.name = aName;
        this.gameMap = aGameMap;
        curRoom = gameMap.getRoom("F1R1");
        inventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        gear = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
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
}
