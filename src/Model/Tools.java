package Model;

import Model.Item;

public class Tools extends Item{
    Room rooms;
    Puzzle puzzle;

    public Tools(int roomID, String itemType,String itemName, String itemDescription) {
        super(roomID,itemType,itemName, itemDescription);
    }


}
