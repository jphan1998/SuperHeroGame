package Model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Room
    {
        private String roomName;
        private String roomDescription;
        private String roomID;
        private boolean isVisited;
        private boolean isLocked;
        private int n;
        private int e;
        private int s;
        private int w;
        private Puzzle puzzle;
        private Monster monster;
        private Map<String, Item> inventory;

        public Room(String roomID ,String roomName, String roomDescription, boolean isLocked, int aN, int aE, int aS, int aW)
        {
            this.roomID = roomID;
            this.roomName = roomName;
            this.roomDescription = roomDescription;
            this.isVisited = false;
            inventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            this.isLocked = isLocked;
            this.n = aN;
            this.e = aE;
            this.s = aS;
            this.w = aW;
        }

        public String searchRoom()
        {
            // Implementation for searching the room
            return null;
        }

        public String currentRoom()
        {
            // Implementation for displaying information about the current room
            return null;
        }

        public void exitRoom()
        {
            // Implementation for exiting the current room
        }

        // getter/setter for roomID
        public String getRoomID()
        {
            return roomID;
        }
        public void setRoomID(String roomID)
        {
            this.roomID = roomID;
        }

        // getter/setter for roomName
        public String getName()
        {
            return roomName;
        }
        public void setRoomName(String roomName)
        {
            this.roomName = roomName;
        }

        // getter/setter for roomDescription
        public String getDescription()
        {
            return roomDescription;
        }
        public void setRoomDescription(String roomDescription)
        {
            this.roomDescription = roomDescription;
        }

        // getter/setter for isVisited
        public boolean getVisited()
        {
            return isVisited;
        }
        public void setVisited(boolean visited)
        {
            isVisited = visited;
        }

        // getter/setter for hasMonster

        //getter/setter for isLocked
        public boolean getIsLocked()
        {
            return isLocked;
        }
        public boolean isLocked()
        {
            return isLocked;
        }

        public Map<String, Item> getInventory() {
            return inventory;
        }

        public void setInventory(Map<String, Item> inventory) {
            this.inventory = inventory;
        }

        public Puzzle getPuzzle() {
            return puzzle;
        }

        public void setPuzzle(Puzzle puzzle) {
            this.puzzle = puzzle;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public Monster getMonster() {
            return monster;
        }

        public void setMonster(Monster monster) {
            this.monster = monster;
        }
    }

