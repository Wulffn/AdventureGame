public abstract class Weapon extends Item{

    private int damage;

    public Weapon(String itemName, String ability, int damage) {
        super(itemName, ability);
        this.damage = damage;
    }

    public abstract boolean canUse();

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getItemName() + "," + getItemDescription();
    }
}
