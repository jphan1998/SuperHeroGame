package Model;

import Model.Item;

public class Consumables extends Item {

    int cAmount;
    int cCount;

    public Consumables(String itemName, String itemDescription, String itemType, int cAmount, int cCount) {
        super(itemName, itemDescription, itemType);
        this.cAmount = cAmount;
        this.cCount = cCount;
    }

    public int getcAmount() {
        return cAmount;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }
}
