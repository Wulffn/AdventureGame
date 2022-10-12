public class Main {

    public static void main(String[] args) {
        Adventure controller = new Adventure();
        UserInterface ui = new UserInterface(controller);
        ui.start();
        ui.gameCommands();
        ui.gameEngine();

    }
}
