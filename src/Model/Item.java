package Model;

public class Item {
    private String ItemType;
    private String ItemName;
    private String ItemDescription;


    public Item(String itemType, String itemName, String itemDescription) {
        ItemType = itemType;
        ItemName = itemName;
        ItemDescription = itemDescription;
    }

    public String getItemName() {
        return ItemName;
    }

    public String examineItem() {
        return ItemDescription;
    }
}
