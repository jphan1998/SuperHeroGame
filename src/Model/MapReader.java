package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MapReader {

    private HashMap<String, Room> gameMap;

    public void readMap(String file) throws FileNotFoundException {

        File reader = new File(file); //Creates a file class that can be run through the scanner.
        Scanner mapReader = new Scanner(reader);
        HashMap<String, Room> aMaps = new HashMap<>();

        mapReader.useDelimiter("[~]+"); //Delimiter to separate the text file, removes carriage return, new line, and '~'.
        while (mapReader.hasNext()) {
            String id = mapReader.next();
            boolean seen = mapReader.nextBoolean();
            String name = mapReader.next();
            String desc = mapReader.next();
            int n = mapReader.nextInt();
            int e = mapReader.nextInt();
            int s = mapReader.nextInt();
            int w = mapReader.nextInt();
            aMaps.put(id, new Room(id, seen, name, desc, n, e, s, w));
        }
        this.gameMap = aMaps;
    }
}
