import java.util.Scanner;

public class UserInterface {

    private Adventure game;
    private Scanner s = new Scanner(System.in);

    public UserInterface(Adventure controller) {
        this.game = controller;
    }

    public void start() {

        System.out.println("Night City.\n" +
                "A lot like a toxic lover. is seductive and ruthless, it's capable of\n" +
                "teasing you with the countless promises and joys of life, but for the most part screws you up. The city has spiraled out of\n" +
                "control ever since Chrome came to town... It's now a place of violence, greed and constant fight for power.\n" +
                "You're surrounded by countless corporate buildings, high skyscrapers with glass walls shinier than most could imagine, junkies and Cyberpunks.\n" +
                "And if you've made it this far already, you're in for a lot of trouble. Welcome to Night City, the place of your wildest desires.");
    }

    public void gameCommands() {
        System.out.println("\nCONTROLS: ");
        System.out.println("-----------------------------");
        System.out.println("Type 'go north' to go north");
        System.out.println("Type 'go south' to go south");
        System.out.println("Type 'go west' to go west");
        System.out.println("Type 'go east' to go east");
        System.out.println("Type 'go look' to look around");
        System.out.println("-----------------------------");

        System.out.println("Type 'inventory' to see what is in your inventory");
        System.out.println("Type 'equip' to equip weapon or weapons from your inventory");
        System.out.println("Type 'view' to see equipped weapons");
        System.out.println("Type 'take' to pick up things from a room");
        System.out.println("Type 'drop' to drop an item from your inventory");
        System.out.println("-----------------------------");

        System.out.println("Type 'health/hp' to check current health status");
        System.out.println("Type 'eat' to consume food");
        System.out.println("Type 'atk/attack' to attack");
        System.out.println("-----------------------------");
        System.out.println("Type: 'start' to enter building");
    }

    public void gameEngine() {
        boolean error = false;
        do {
            error = false;
            String walk = s.nextLine();
            String[] userInputs = walk.split(" "); // array af strings // deler stringen op og splitter på mellemrum
            String command = userInputs[0];
            String userChoice = "";
            if (userInputs.length > 1) {
                userChoice = userInputs[1];
            }

            switch (command) {
                case "start":
                    System.out.println("You're currently in: " + game.getCurrentRoom().getName() + " " + game.getCurrentRoom().getRoomDescription());
                    break;
                case "go":
                    boolean succes = game.go(userChoice);
                    if (succes) {
                        Room currentRoom = game.getCurrentRoom();
                        System.out.println("You've gone " + userChoice);
                        System.out.println(currentRoom.getName() + " " + currentRoom.getRoomDescription());
                    } else {
                        System.out.println("Do you really want jump out the window that bad huh?...");
                    }
                    break;
                case "look":
                    System.out.println("Looking around ");
                    System.out.println("You are in: " + game.getCurrentRoom().getName());
                    System.out.println("--------------");
                    System.out.println(game.getCurrentRoom().getRoomDescription());
                    System.out.println("\nThese are the items in the room: ");
                    Room currentRoom = game.getCurrentRoom();
                    for (Item item : currentRoom.getItems()) {
                        System.out.println(item.getItemName() + item.getItemDescription());
                    }
                    System.out.println("--------------");
                    System.out.println(game.getCurrentRoom().getEnemies());

                    break;

                case "inventory", "inven", "inv":
                    System.out.println("Your inventory contains: " + game.getInventory());
                    break;
                case "take":
                    System.out.println("You've picked up " + game.takeItem(userChoice));
                    break;
                case "drop":
                    System.out.println("You've dropped: " + game.dropItem(userChoice));
                    break;
                case "health", "hp":
                    if (game.getHealthPoints() >= 100)
                        System.out.println("You currently have: " + game.getHealthPoints() + " you're full health!");
                    if (game.getHealthPoints() < 100 && game.getHealthPoints() >= 50)
                        System.out.println("You currently have: " + game.getHealthPoints() + " you're good to go!");
                    if (game.getHealthPoints() < 49 && game.getHealthPoints() >= 25)
                        System.out.println("You currently have: " + game.getHealthPoints() + " find something to eat...");
                    if (game.getHealthPoints() >= 1 && game.getHealthPoints() <= 24)
                        System.out.println("You currently have: " + game.getHealthPoints() + " it's not looking good");
                    break;
                case "eat":
                    System.out.println("You've eaten: " + game.eatFood(userChoice));
                    System.out.println("You now have: " + game.getHealthPoints());
                    break;
                case "equip", "equip weapon", "equipweapon":
                    System.out.println("You have equipped: " + game.equipWeapon(userChoice));
                    break;
                case "equipped":
                    System.out.println("You currently have: " + game.getEquippedWeapon() + " equipped");
                    break;
                case "atk", "attak", "attack":
                    System.out.println("You have attacked: " + game.attackEnemy(userChoice));
                    System.out.println("You now have: " + game.getHealthPoints() + "HP");
                    try {
                        System.out.println("Enemy now has: " + game.getEnemyHealthPoints() + "HP");
                    } catch (NullPointerException npe) {
                        System.out.println("No more fighting...");
                    }
                    break;
                default:
                    System.out.println("You can't do that...");
                    break;
            }
        } while (true);
    }
}
