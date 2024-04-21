package Model;

public class Item {
    private String ItemType;
    private String ItemName;
    private String ItemDescription;



    public Item(String itemName, String itemDescription, String itemType) {
        ItemType = itemType;
        ItemName = itemName;
        ItemDescription = itemDescription;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

}
