package Model;

import Model.Item;

public class Consumables extends Item {

    int cAmount;
    int cCount;

    public Consumables( String itemType, String itemName, String itemDescription, int cAmount, int cCount) {
        super(itemType,itemName, itemDescription);
        this.cAmount = cAmount;
        this.cCount = cCount;
    }


}
