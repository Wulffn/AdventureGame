public class MeleeWeapon extends Weapon{


    public MeleeWeapon(String itemName, String ability, int damage) {
        super(itemName, ability, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }


}
