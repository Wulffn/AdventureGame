import java.util.ArrayList;
public class Room {

    private String name;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public Room(String name, String roomDescription) {
        this.name = name;
        this.roomDescription = roomDescription;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
    }

    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy findEnemy(String enemyName) {
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyName().equals(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        enemy.setCurrentRoom(this);
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }
}