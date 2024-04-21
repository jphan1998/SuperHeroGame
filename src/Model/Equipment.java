package Model;

import Model.Item;

public class Equipment extends Item {

    int eAmount;

    public Equipment(String itemType, String itemName, String itemDescription, int eAmount) {
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
