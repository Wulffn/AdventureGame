public class PlayerWithOnlyFiveItemCapacity extends Player {

    private String name;

    public PlayerWithOnlyFiveItemCapacity(String playerName, int health, Weapon weapon) {
        super(health, weapon);
        name = playerName;
    }

    //Eksempel på polymorfisme. Hvis en specialiseret player har brug for ny funktionalitet, kan metoden fra super klassen overrides
    @Override
    public boolean takeItem(String itemName) {
        if(this.getInventory().size() == 5) throw new IllegalStateException("Enemy inventory can't be greater than five. Drop some items if you want to pick this up");
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().equals(itemName)) {
                this.getInventory().add(item);
                currentRoom.removeItem(item);
                return true;
            }
        }
        return false;
    }

    //Eksempel på overloading kan være at enemy må have et variabelt antal i inventory

    public boolean takeItem(String itemName, int maxInventoryCount) {
        if(this.getInventory().size() == 5) throw new IllegalStateException("Enemy inventory can't be greater than five. Drop some items if you want to pick this up");
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().equals(itemName)) {
                this.getInventory().add(item);
                currentRoom.removeItem(item);
                return true;
            }
        }
        return false;
    }

    //Og endnu bedre, i har to metoder der nu ligner hinanden. Erstat metode på linje 12 med følgende. Det har samme funktionalitet:

//    @Override
//    public boolean takeItem(String itemName) {
//        return takeItem(itemName, 5);
//    }
}

