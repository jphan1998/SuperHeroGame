package Model;

import Model.Item;

public class Consumables extends Item {

    int cAmount;
    int cCount;

    public Consumables(String itemName, String itemDescription, String itemType, int cAmount, int cCount) {
        super(itemType,itemName, itemDescription);
        this.cAmount = cAmount;
        this.cCount = cCount;
    }

    public int getcAmount() {
        return cAmount;
    }


}
