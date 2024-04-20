package Model;

import java.util.Map;
import java.util.TreeMap;

public class Room
    {
        private String roomName;
        private String roomDescription;
        private String roomID;
        private boolean isVisited;
        private boolean isLocked;
        private String n;
        private String e;
        private String s;
        private String w;
        private Puzzle puzzle;
        private Monster monster;
        private Map<String, Item> inventory;

        public Room(String roomID ,String roomName, String roomDescription,boolean aVisited, boolean isLocked, String aN, String aE, String aS, String aW)
        {
            this.roomID = roomID;
            this.roomName = roomName;
            this.roomDescription = roomDescription;
            this.isVisited = aVisited;
            this.isLocked = isLocked;
            this.n = aN;
            this.e = aE;
            this.s = aS;
            this.w = aW;
            this.isVisited = false;
            inventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        }

        public String searchRoom()
        {
            StringBuilder searchResult = new StringBuilder();
            //checks for monster
            if (monster != null)
            {
                searchResult.append("There is a monster here! ").append(monster.getName()).append("Description: ").append(monster.getDesc()).append(".");
            }
            //checks puzzle
            if (puzzle != null)
            {
                searchResult.append("There is a puzzle here! ").append(puzzle.getDesc()).append(".");
            }
            if (!inventory.isEmpty())
            {
                searchResult.append("You see some items here: ");
                for (Map.Entry<String, Item> item : inventory.entrySet())
                {
                    searchResult.append(item.getValue().getItemName()).append(", ");
                }
                //remove the last comma and space
                searchResult.setLength(searchResult.length() - 2);
            }
            if (searchResult.length() == 0)
            {
                searchResult.append("You dont' see anything interesting here.");
            }
            return searchResult.toString();
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

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public String getW() {
            return w;
        }

        public void setW(String w) {
            this.w = w;
        }

        public Monster getMonster() {
            return monster;
        }

        public void setMonster(Monster monster) {
            this.monster = monster;
        }
    }

