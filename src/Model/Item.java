/* Class created by Kevin
 * All Methods created by Kevin
 * Item Text File made by Kevin
 */

package Model;

import java.io.Serializable;

public class Item implements Serializable {
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
