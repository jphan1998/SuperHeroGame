package Model;

import Model.Item;

public class Equipment extends Item {

    int eAmount;

    public Equipment(int roomID, String itemType, String itemName, String itemDescription, int eAmount) {
        super(roomID,itemType,itemName, itemDescription);
        this.eAmount = eAmount;
    }

    void equip(){

    }

}
