/* Class created by Jimmy
 * All Methods created by Jimmy
 */

package Model;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MapReader implements java.io.Serializable {

    private HashMap<String, Room> gameMap;

    // MapReader Object was created by Jimmy and all Methods inside.
    public MapReader() throws FileNotFoundException {
        gameMap = new HashMap<>();
        readMap("Room.txt");
        readMonster("Monster.txt");
        readPuzzle("puzzles.txt");
        readItems("Items.txt");
    }

    public void readMap(String file) throws FileNotFoundException {

        File reader = new File(file); //Creates a file class that can be run through the scanner.
        Scanner mapReader = new Scanner(reader);
        HashMap<String, Room> aMaps = new HashMap<>();

        mapReader.useDelimiter("[~\r\n]+"); //Delimiter to separate the text file, removes carriage return, new line, and '~'.
        while (mapReader.hasNext()) {
            String id = mapReader.next();
            String name = mapReader.next();
            String desc = mapReader.next();
            boolean visited = mapReader.nextBoolean();
            boolean locked = mapReader.nextBoolean();
            String n = mapReader.next();
            String e = mapReader.next();
            String s = mapReader.next();
            String w = mapReader.next();
            aMaps.put(id, new Room(id, name, desc, visited, locked, n, e, s, w));
        }
        this.gameMap = aMaps;
    }

    public void readMonster(String file) throws FileNotFoundException{
        File reader = new File(file); //Creates a file class that can be run through the scanner.
        Scanner monsterReader = new Scanner(reader);
        monsterReader.useDelimiter("[~\r\n]+"); //Delimiter to separate the text file, removes carriage return, new line, and '~'.

        while (monsterReader.hasNext()) {
            String id = monsterReader.next();
            String name = monsterReader.next();
            String desc = monsterReader.next();
            int CR = monsterReader.nextInt();
            int HP = monsterReader.nextInt();
            String unlock = monsterReader.next();
            gameMap.get(id).setMonster(new Monster(name, desc, CR, HP, unlock));
        }
    }

    public void readPuzzle(String file) throws FileNotFoundException {
        File reader = new File(file); //Creates a file class that can be run through the scanner.
        Scanner puzzleReader = new Scanner(reader);
        puzzleReader.useDelimiter("[~\r\n]+"); //Delimiter to separate the text file, removes carriage return, new line, and '~'.

        while (puzzleReader.hasNext()) {
            String id = puzzleReader.next();
            String name = puzzleReader.next();
            String desc = puzzleReader.next();
            String hint = puzzleReader.next();
            String answer = puzzleReader.next();
            int attempts = puzzleReader.nextInt();
            String unlock = puzzleReader.next();
            gameMap.get(id).setPuzzle(new Puzzle(name, desc, hint, answer, attempts, unlock));
        }
    }

    public void readItems(String file) throws FileNotFoundException {
        File reader = new File(file); // Creates a file class that can be run through the scanner.
        Scanner itemReader = new Scanner(reader);
        itemReader.useDelimiter("[~\r\n]+"); // Delimiter to separate the text file, removes carriage return, new line, and '~'.

        while (itemReader.hasNext()) {
            String roomId = itemReader.next();
            String itemName = itemReader.next();
            String itemDescription = itemReader.next();
            String dropLocation = itemReader.next();
            String itemType = itemReader.next();

            if(itemType.equalsIgnoreCase("consumable")){
                int cAmount = itemReader.nextInt();
                int cCount = itemReader.nextInt();
                if(dropLocation.equalsIgnoreCase("Room")){
                    gameMap.get(roomId).getInventory().put(itemName, new Consumables(itemName,itemDescription,itemType, cAmount, cCount));
                }
                if(dropLocation.equalsIgnoreCase("Puzzle")){
                    gameMap.get(roomId).getPuzzle().getInventory().put(itemName, new Consumables(itemName,itemDescription,itemType, cAmount, cCount));
                }
                if(dropLocation.equalsIgnoreCase("Monster")){
                    gameMap.get(roomId).getMonster().getInventory().put(itemName, new Consumables(itemName,itemDescription,itemType, cAmount, cCount));
                }
            }
            if (itemType.equalsIgnoreCase("equipment")){
                int eAmount = itemReader.nextInt();
                if(dropLocation.equalsIgnoreCase("Room")){
                    gameMap.get(roomId).getInventory().put(itemName, new Equipment(itemName,itemDescription,itemType, eAmount));
                }
                if(dropLocation.equalsIgnoreCase("Puzzle")){
                    gameMap.get(roomId).getPuzzle().getInventory().put(itemName, new Equipment(itemName,itemDescription,itemType, eAmount));
                }
                if(dropLocation.equalsIgnoreCase("Monster")){
                    gameMap.get(roomId).getMonster().getInventory().put(itemName, new Equipment(itemName,itemDescription,itemType, eAmount));
                }
            }
            if(itemType.equalsIgnoreCase("item")){
                if(dropLocation.equalsIgnoreCase("Room")){
                    gameMap.get(roomId).getInventory().put(itemName, new Item(itemName,itemDescription,itemType));
                }
                if(dropLocation.equalsIgnoreCase("Puzzle")){
                    gameMap.get(roomId).getPuzzle().getInventory().put(itemName, new Item(itemName,itemDescription,itemType));
                }
                if(dropLocation.equalsIgnoreCase("Monster")){
                    gameMap.get(roomId).getMonster().getInventory().put(itemName, new Item(itemName,itemDescription,itemType));
                }
            }
        }
    }

    public Room getRoom (String id){
        return gameMap.get(id);
    }

    //Getters and Setters
    public HashMap<String, Room> getGameMap() {
        return gameMap;
    }

    public void setGameMap(HashMap<String, Room> gameMap) {
        this.gameMap = gameMap;
    }
}


