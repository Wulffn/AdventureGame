public class Map {

    private Room startRoom = null;

    public void mapBuild() {
        Room room1 = new Room("Room 1", "Why would the brooker give us this mission? Something seems off, let's keep our eyes open and be ready for whatever" +
                " might happen...");
        Room room2 = new Room("Room 2:", "is that blood over in the corner?.. hmm I knew something was up ");
        Room room3 = new Room("Room 3:", "damn, rotten meat? this stinks... ");
        Room room4 = new Room("Room 4:", "The view is awesome from up here! ");
        Room room5 = new Room("Room 5:", "I knew it was in here! THE SANDEVISTIAN");
        Room room6 = new Room("Room 6:", "the view of Night City... is it what is is I guess");
        Room room7 = new Room("Room 7:", "this place just gets more creepy");
        Room room8 = new Room("Room 8:", "I see something right up ahead, lets look out for traps ");
        Room room9 = new Room("Room 9:", "its just dark and lonely in here. ");

        Item item3 = new Item("goggles", " +utility");
        Item item5 = new Item("adrenaline", " +dmg boost");
        Item item6 = new Item("boots", " +movement");
        Item item7 = new Item("armor", " +toughness");
        Item item8 = new Item("key", " for a door?");

        Food food1 = new Food("apple", " ", +15);
        Food food2 = new Food("proteinbar", " yum ", +20);
        Food food3 = new Food("rotten meat", " nasty ", -25);
        Food food4 = new Food("tequila", " booze ", -35);
        Food food5 = new Food("soda", " mountain dew! ", +15);
        Food food6 = new Food("sushi", " california roll! ", +50);

        MeleeWeapon meleeWeapon1 = new MeleeWeapon("sword", " ", 15);
        MeleeWeapon meleeWeapon2 = new MeleeWeapon("knife", " ", 10);
        RangedWeapon rangedWeapon1 = new RangedWeapon("shotgun", " ", 30, 8);
        RangedWeapon rangedWeapon2 = new RangedWeapon("bow", " ", 20, 6);

        // enemy Weapons
        MeleeWeapon enemyWeapon1 = new MeleeWeapon("lightcutter", " ", 20);
        MeleeWeapon enemyWeapon2 = new MeleeWeapon("BloodThirster", " ", 45);

        // enemies and their HP
        Enemy enemy1 = new Enemy("robot", ", low tier robot", 45,enemyWeapon1);
        Enemy enemy2 = new Enemy("outlaw", ", a cyberpunk", 65, enemyWeapon2);

        // add to enemy inventory

        // enemy placement
        room3.addEnemy(enemy1);
        room8.addEnemy(enemy2);

        // weapon placement
        room2.addItem(meleeWeapon1);
        room6.addItem(meleeWeapon2);
        room7.addItem(rangedWeapon1);
        room9.addItem(rangedWeapon2);


        // food placement
        room1.addItem(food1);
        room2.addItem(food2);
        room3.addItem(food3);
        room4.addItem(food4);
        room9.addItem(food5);
        room7.addItem(food6);

        // item placement
        room3.addItem(item3);
        room5.addItem(item5);
        room6.addItem(item6);
        room7.addItem(item7);
        room9.addItem(item8);

        // movement for room 1
        room1.setEast(room2);
        room1.setSouth(room4);

        // movement for room 2
        room2.setWest(room1);
        room2.setEast(room3);

        // movement for room 3
        room3.setWest(room2);
        room3.setSouth(room6);

        // movement for room 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        // movement for room 5
        room5.setSouth(room8);

        // movement for room 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // movement for room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // movement for room 8
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        // movement for room 9
        room9.setNorth(room6);
        room9.setWest(room8);

        startRoom = room1;

    }

    public Room getStartRoom() {
        return startRoom;
    }

}
