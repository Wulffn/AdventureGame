public class RangedWeapon extends Weapon{

    private int ammo;

    public RangedWeapon(String itemName, String ability, int damage, int ammo) {
        super(itemName, ability, damage);
        this.ammo = ammo;
    }

    public int getAmmoLeft() {
        return ammo;
    }

    public boolean canUse() {
        ammo -= 1;
        return (ammo > 0);
    }
}
