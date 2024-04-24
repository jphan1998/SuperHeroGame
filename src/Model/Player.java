/* Class created by Jimmy
 * Move & SolvePuzzle Method by Jimmy
 * Use, Consume, Equip, Drop, Pickup, and all Item Methods by Kevin
 * CombatWithMonster Method by Ash
 */
package Model;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Player implements Serializable {
    private String name;
    private MapReader gameMap;
    private Room curRoom;
    private Room prevRoom;
    private int HP;
    private int CR;
    private Map<String, Item> inventory;
    private Map<String, Item> gear;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Player(String aName, MapReader aGameMap) {
        HP = 15;
        CR = 2;
        this.name = aName;
        this.gameMap = aGameMap;
        curRoom = gameMap.getRoom("F1R1");
        inventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        gear = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public String move(String roomId) {
        String room;
        if (gameMap.getGameMap().containsKey(roomId)) {
            curRoom.setVisited(true);
            prevRoom = curRoom;
            curRoom = gameMap.getRoom(roomId);
            room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
            return room;
        } else {
            return "No room";
        }
    }

    public String solvePuzzle() {
        int prevAttempt = curRoom.getPuzzle().getAttempts();
        if (!curRoom.getPuzzle().isSolved()) {
            Scanner in = new Scanner(System.in);
            for (int i = curRoom.getPuzzle().getAttempts(); i > 0; i--) {
                String input = in.nextLine();
                String[] command = input.split(" ", 2);
                String verb = command[0];

                    if (verb.equalsIgnoreCase("Use")) {
                        String object = command[1];
                        if (getInventory().containsKey(object)) {
                            if (object.toLowerCase().contains(curRoom.getPuzzle().solution.toLowerCase())) {
                                curRoom.getPuzzle().setSolved(true);
                                if(!curRoom.getPuzzle().getUnlockRoom().equalsIgnoreCase("0")) {
                                    gameMap.getRoom(curRoom.getPuzzle().getUnlockRoom()).setLocked(false);
                                }
                                if(!curRoom.getPuzzle().getInventory().isEmpty()){
                                    for(String name : curRoom.getPuzzle().getInventory().keySet()){
                                        curRoom.getInventory().put(name, curRoom.getPuzzle().getInventory().get(name));
                                        curRoom.getPuzzle().getInventory().remove(name);
                                    }
                                }
                                return "Solved";
                            } else {
                                System.out.println("The answer you have provided is wrong, you still have " + (i - 1) + " left. Try one more time.");
                            }
                        } else {
                            return "NoItem";
                        }
                    }
                    else if(input.equalsIgnoreCase("Skeleton Key")){
                        return "use";
                    }
                    else if(input.equalsIgnoreCase("Runestone")){
                        return "use";
                    }
                    else if(verb.equalsIgnoreCase("Quit")){
                        break;
                    }
                else if(!input.toLowerCase().contains(curRoom.getPuzzle().solution.toLowerCase())) {
                    System.out.println("The answer you have provided is wrong, you still have " + (i - 1) + " left. Try one more time.");
                } else {
                    curRoom.getPuzzle().setSolved(true);
                        if(!curRoom.getPuzzle().getUnlockRoom().equalsIgnoreCase("0")) {
                            gameMap.getRoom(curRoom.getPuzzle().getUnlockRoom()).setLocked(false);
                        }
                    if(!curRoom.getPuzzle().getInventory().isEmpty()){
                        for(String name : curRoom.getPuzzle().getInventory().keySet()){
                            curRoom.getInventory().put(name, curRoom.getPuzzle().getInventory().get(name));
                            curRoom.getPuzzle().getInventory().remove(name);
                        }
                    }
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

    public String consume(String name) {
        if (inventory.get(name) instanceof Consumables) {
            HP += ((Consumables) inventory.get(name)).getcAmount();
            ((Consumables) inventory.get(name)).setcCount(((Consumables) inventory.get(name)).getcCount() - 1);
            if(((Consumables) inventory.get(name)).getcCount() == 0){
                inventory.remove(name);
            }
            return "Heal";
        }else
            return "Nothing";
    }

    public String equip(String name) {
        if (inventory.get(name) instanceof Equipment) {
            CR += ((Equipment) inventory.get(name)).geteAmount();
            return "Equip";
        } else {
            return "Wrong";
        }
    }

    public String use(String name) {
        if (name.equalsIgnoreCase("Grapple Hook")) {
            if(curRoom.getRoomID().equalsIgnoreCase("F1R6")){
                curRoom.setVisited(true);
                prevRoom = curRoom;
                curRoom = gameMap.getRoom("F2R1");
                String room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
                return room;
            }else if(curRoom.getRoomID().equalsIgnoreCase("F2R1")){
                curRoom.setVisited(true);
                prevRoom = curRoom;
                curRoom = gameMap.getRoom("F1R6");
                String room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
                return room;
            }
        }else if(name.equalsIgnoreCase("Teleport Crystal")){
            if(curRoom.getRoomID().equalsIgnoreCase("F2R8")){
                curRoom.setVisited(true);
                prevRoom = curRoom;
                curRoom = gameMap.getRoom("F3R1");
                String room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
                return room;
            }else if(curRoom.getRoomID().equalsIgnoreCase("F3R1")){
                curRoom.setVisited(true);
                prevRoom = curRoom;
                curRoom = gameMap.getRoom("F2R8");
                String room = "You are now in " + curRoom.getName() + "\n" + curRoom.getDescription();
                return room;
            }
        }
        else if(name.equalsIgnoreCase("Scroll of Knowledge")){
            if(curRoom.getPuzzle() != null){
                return "Hint";
            }
            else return "NoPuzzle";
        }else if(name.equalsIgnoreCase("Invisibility Cloak")){
            if(curRoom.getPuzzle() != null){
                return "Hint";
            }
            else return "NoPuzzle";
        }
        else if(name.equalsIgnoreCase("Invisibility Cloak")){
            gameMap.getRoom("F3R6").setLocked(false);
            return "sneak";
        }
        return "Nothing";


    }

    public String pickUpItem(String name){
        if (curRoom.getInventory().get(name) instanceof Consumables){
            if(inventory.containsKey(name)) {
                ((Consumables) inventory.get(name)).setcCount(((Consumables) inventory.get(name)).getcCount() + 1);
                curRoom.getInventory().remove(name);
            }
            else{
                inventory.put((curRoom.getInventory().get(name).getItemName()), curRoom.getInventory().get(name));
                curRoom.getInventory().remove(name);
            }
        }
        else {
            inventory.put(curRoom.getInventory().get(name).getItemName(), curRoom.getInventory().get(name));
            curRoom.getInventory().remove(name);
        }
            return inventory.get(name).getItemName();
    }

    public String dropItem(String name){
        if (inventory.get(name) instanceof Consumables){
            if(curRoom.getInventory().containsKey(name)) {
                ((Consumables) curRoom.getInventory().get(name)).setcCount(((Consumables) curRoom.getInventory().get(name)).getcCount() + 1);
                if(((Consumables) curRoom.getInventory().get(name)).getcCount() == 0 ){
                    inventory.remove(name);
                }
            } else{
                curRoom.getInventory().put((inventory.get(name).getItemName()), inventory.get(name));
                if(((Consumables) curRoom.getInventory().get(name)).getcCount() == 0 ){
                    inventory.remove(name);
                }
            }
        } else {
            curRoom.getInventory().put(inventory.get(name).getItemName(), inventory.get(name));
            inventory.remove(name);
        }
        return curRoom.getInventory().get(name).getItemName();
    }

    public String examineItem(String name){
        return inventory.get(name).getItemDescription();
    }

    public boolean combatWithMonster(Monster monster) {
        System.out.println("You encountered a " + ANSI_PURPLE +  monster.getName() + ANSI_RESET + "!");
        System.out.println("Monster CR: " + ANSI_PURPLE +  monster.getCR() + ANSI_RESET);

        boolean playerTurn = true;
        boolean playerWon = false;
        while (getHP() > 0 && curRoom.getMonster().getHP() > 0) {
            if (playerTurn) {
                System.out.println("Player HP: " + ANSI_PURPLE +  getHP() + ANSI_RESET);
                System.out.println(curRoom.getMonster().getName() + "'s HP: " + ANSI_PURPLE +  curRoom.getMonster().getHP() + ANSI_RESET);
                System.out.println("Choose your action:");
                System.out.println("Attack");
                System.out.println("Flee");
                System.out.print("Your command: ");
                Scanner scanner = new Scanner(System.in);
                String action = scanner.nextLine().toUpperCase();
                switch (action) {
                    case "ATTACK":
                        int randomNumber = (int) (Math.random() * 10) + 1;
                        int playerCR = getCR();
                        int playerDealDamage = Math.max(0, (playerCR + randomNumber) - curRoom.getMonster().getCR());
                        curRoom.getMonster().setHP(curRoom.getMonster().getHP() - playerDealDamage);

                        System.out.println("You hit the " + ANSI_PURPLE + monster.getName() + ANSI_RESET + " for " + ANSI_PURPLE + playerDealDamage + ANSI_RESET + " damage.");
                        break;

                    case "FLEE":
                        if(getHP() <= 10){
                            setCurRoom(getPrevRoom());
                            System.out.println(ANSI_RED +"You have fled to the previous room" + ANSI_RESET);
                            return false;

                        }
                        playerTurn = true;
                        break;

                    default:
                        System.out.println(ANSI_RED +"You did nothing!! Try again." + ANSI_RESET);
                }
            } else {
                int randomNumber = (int) (Math.random() * 10) + 1;
                int monsterCR = curRoom.getMonster().getCR();
                int monsterDealDamage = Math.max(0, (monsterCR + randomNumber) - getCR());

                setHP(getHP() - monsterDealDamage);
                System.out.println("The " + ANSI_PURPLE + curRoom.getMonster().getName() + ANSI_RESET + " hits you for " + ANSI_PURPLE + monsterDealDamage + ANSI_RESET + " damage.");
            }
            if (monster.getHP() <= 0) {
                System.out.println(ANSI_RED + "You defeated the " + ANSI_RESET + ANSI_PURPLE + curRoom.getMonster().getName() + ANSI_RESET + ANSI_RED +  "!" + ANSI_RESET);
                playerWon = true;
                setHP(getHP()+3);
                setCR(getCR()+1);
                System.out.println(ANSI_RED + "Current HP " + ANSI_RESET + ANSI_PURPLE + getHP() + ANSI_RESET + ANSI_RED +  " 3+" + ANSI_RESET);
                System.out.println(ANSI_RED + "Current CR " + ANSI_RESET + ANSI_PURPLE + getCR() + ANSI_RESET + ANSI_RED +  " 1+" + ANSI_RESET);
                if(!curRoom.getMonster().getInventory().isEmpty()){
                    for(String name : curRoom.getMonster().getInventory().keySet()){
                        curRoom.getInventory().put(name, curRoom.getMonster().getInventory().get(name));
                        curRoom.getMonster().getInventory().remove(name);
                    }
                }
                if(!curRoom.getMonster().getUnlock().equalsIgnoreCase("0")){
                    gameMap.getRoom(curRoom.getMonster().getUnlock()).setLocked(false);
                }
                break;
            }
            playerTurn = !playerTurn;
        }
        if (!playerWon) {
            System.out.println(ANSI_RED + "You were defeated by the " + ANSI_RESET + ANSI_PURPLE + curRoom.getMonster().getName() + ANSI_RESET + ANSI_RED +  "!" + ANSI_RESET);
        }
        return playerWon;
    }


}
