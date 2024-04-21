package Model;

import Model.Item;

public class Equipment extends Item {

    int eAmount;

    public Equipment(String itemName, String itemDescription, String itemType, int eAmount) {
        super(itemType,itemName, itemDescription);
        this.eAmount = eAmount;
    }

    public int geteAmount() {
        return eAmount;
    }

    public void seteAmount(int eAmount) {
        this.eAmount = eAmount;
    }
}
