public class Enemy extends Player {

    private String enemyName;
    private String description;
    private boolean isDead;

    public Enemy(String enemyName, String description, int health, Weapon weapon) {
        super.health = health;
        super.equippedWeapon = weapon;
        this.enemyName = enemyName;
        this.description = description;
        this.isDead = isDead;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getHealthPoints() {
        return health;
    }

    public int enemyHealth() {
        if (health > 0) {
            return getHealthPoints();
        } else {
            currentRoom.addItem(equippedWeapon);
            getInventory().remove(equippedWeapon);
            currentRoom.removeEnemy(this);
        }
        return 0;
    }

    @Override
    public String toString() {
        return enemyName + " " + description + " " + health + "HP";
    }
}