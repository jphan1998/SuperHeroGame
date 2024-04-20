package Model;

import Model.Item;

public class Consumables extends Item {

    int cAmount;
    int cCount;

    public Consumables(int roomID, String itemType, String itemName, String itemDescription, int cAmount, int cCount) {
        super(roomID,itemType,itemName, itemDescription);
        this.cAmount = cAmount;
        this.cCount = cCount;
    }

    void consume(){

    }

}
