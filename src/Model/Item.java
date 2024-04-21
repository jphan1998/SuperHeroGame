package Model;

public class Item {
    private int roomID;
    private String ItemType;
    private String ItemName;
    private String ItemDescription;


    public Item(int roomID, String itemType, String itemName, String itemDescription) {
        this.roomID = roomID;
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
