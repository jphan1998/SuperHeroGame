package Model;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MapReader {

    private HashMap<String, Room> gameMap;

    public MapReader() throws FileNotFoundException {
        gameMap = new HashMap<>();
        readMap("Room.txt");
        readMonster("Monster.txt");
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

    public HashMap<Integer, HashMap<String, String>> readItems(String file) throws FileNotFoundException {
        HashMap<Integer, HashMap<String, String>> itemsMap = new HashMap<>();

        File reader = new File(file); // Creates a file class that can be run through the scanner.
        Scanner itemReader = new Scanner(reader);
        itemReader.useDelimiter("[~\r\n]+"); // Delimiter to separate the text file, removes carriage return, new line, and '~'.

        while (itemReader.hasNext()) {
            int roomId = Integer.parseInt(itemReader.next());
            String itemName = itemReader.next();
            String itemDescription = itemReader.next();
            String itemType = itemReader.next();

            // Check if the room already exists in the itemsMap
            if (!itemsMap.containsKey(roomId)) {
                itemsMap.put(roomId, new HashMap<>());
            }
            Item newItem = null;
            switch (itemType) {
                case "Consumable":
                    int cAmount = itemReader.nextInt();
                    int cCount = itemReader.nextInt();
                    newItem = new Consumables(roomId, itemName, itemDescription, itemType, cAmount, cCount);
                    break;
                case "Equipment":
                    int eAmount = itemReader.nextInt();
                    newItem = new Equipment(roomId, itemName, itemDescription, itemType, eAmount);
                    break;
                case "Tool":
                    newItem = new Tools(roomId, itemName, itemDescription, itemType);
                    break;
                default:
                    break;
            }
            itemsMap.get(roomId).put(itemName, itemDescription);
        }
        return itemsMap;
    }

    public Room getRoom (String id){
        return gameMap.get(id);
    }

    public void saveGame(String filename) {

        {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filename);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(gameMap);
                objectOutputStream.close();
                fileOutputStream.close();
                System.out.println("Game saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadGame(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gameMap = (HashMap<String, Room>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Game loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Getters and Setters
    public HashMap<String, Room> getGameMap() {
        return gameMap;
    }

    public void setGameMap(HashMap<String, Room> gameMap) {
        this.gameMap = gameMap;
    }
}


