package Model;

import Model.Item;

public class Equipment extends Item {

    int eAmount;
    Player player;

    public Equipment(String itemType, String itemName, String itemDescription, int eAmount) {
        super(itemType,itemName, itemDescription);
        this.eAmount = eAmount;
    }


}
