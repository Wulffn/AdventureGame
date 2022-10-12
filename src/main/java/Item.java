public class Item {

    private String itemName;
    private String itemDescription;

    public Item(String itemName, String ability) {
        this.itemName = itemName;
        this.itemDescription = ability;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String toString() {
        return itemName + ", " + itemDescription;
    }

}