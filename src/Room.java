import java.util.List;
import java.util.Map;

public class Room
    {
        private String roomName;
        private String roomDescription;
        private int roomID;
        private boolean isVisited;
        private Map<String, String> exits;
        private List<String> inventory;
        private List<String> puzzle;
        private boolean isLocked;
        private boolean hasMonster;

        public Room(String roomName, String roomDescription, int roomID, boolean isVisited, Map<String, String>exits)
        {
            this.roomName = roomName;
            this.roomDescription = roomDescription;
            this.roomID = roomID;
            this.isVisited = false;
            this.exits = exits;
            this.inventory = null;
            this.puzzle = null;
            this.isLocked = false;
            this.hasMonster = false;
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
        public int getRoomID()
        {
            return roomID;
        }
        public void setRoomID(int roomID)
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

        public Map<String, String> getExits()
        {
            return exits;
        }

        // getter/setter for puzzle
        public List<String> getPuzzle()
        {
            return puzzle;
        }
        public void setPuzzle(List<String> puzzle)
        {
            this.puzzle = puzzle;
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
        public boolean getHasMonster()
        {
            return hasMonster;
        }
        public boolean isHasMonster()
        {
            return hasMonster;
        }

        //getter/setter for isLocked
        public boolean getIsLocked()
        {
            return isLocked;
        }
        public boolean isLocked()
        {
            return isLocked;
        }
    }

