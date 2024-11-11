package primenumberhashing.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import primenumberhashing.UserInterface;

public class Menu implements Command {
    private Map<String, Command> commands = new HashMap<>();
    private String[] menuOptions;
    private Menu parentMenu;
    private UserInterface ui = new UserInterface();

    // private Scanner scanner = new Scanner(System.in);

    public Menu(Menu parentMenu) {
        this.parentMenu = parentMenu;
        if (parentMenu != null) {
            commands.put("Back", null);
        }
    }

    @Override
    public void execute() {
        mapHashKeysToArray();
        ui.displayMenu(this.menuOptions);
        int choice = ui.getInput();
        String name = mapInputToName(choice);
        executeCommand(name);

    }

    private void mapHashKeysToArray() {
        Set<String> setOfKeys = commands.keySet();
        menuOptions = new String[setOfKeys.size()];
        menuOptions = setOfKeys.toArray(menuOptions);
    }

    private String mapInputToName(int input) {
        String optionName = menuOptions[input];
        return optionName;
    }

    /*
     * private int getInput() {
     * Integer input = scanner.nextInt();
     * return input;
     * }
     */
    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    private void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        // perhaps move this to its own UI method
        if (command != null) {
            command.execute();
        } else if (commandName.equals("Back") && parentMenu != null) {
            parentMenu.execute();
        } else {
            System.out.println("invalid Command");
        }
    }

    /*
     * private void displayMenu() {
     * System.out.println("Menu:");
     * for (int i = 0; i < menuOptions.length; i++) {
     * System.out.println(i + ": " + menuOptions[i]);
     * }
     * }
     */

    /*
     * private void displayMenuHash() {
     * System.out.println("Menu:");
     * int counter = 0;
     * for (String name : commands.keySet()) {
     * String optionWithNumber = String.format("%d: %s", counter, name);
     * System.out.println(optionWithNumber);
     * counter++;
     * }
     * }
     */
}