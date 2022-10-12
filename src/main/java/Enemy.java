public class Enemy extends Player {

    private String enemyName;
    private String description;
    private boolean isDead;

    public Enemy(String enemyName, String description, int health, Weapon weapon) {
        //I stedet for at gøre attributter i player protected så i kan sætte dem, så gør brug af en contructor i superklassen.
        //Se linje 10 i Player.java

        super(health, weapon); // <- Bedre

        super.health = health; // no
        super.equippedWeapon = weapon; // no
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