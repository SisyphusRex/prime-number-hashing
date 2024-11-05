package primenumberhashing.commands.menus;

import java.util.HashMap;
import java.util.Map;
import primenumberhashing.commands.Command;
import java.util.Scanner;

abstract class AbstractMenu implements Command {
    private Map<String, Command> commands = new HashMap<>();
    private Command[] menuOptions;

    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        mapHashKeysToArray();
        displayMenu();
        int choice = getInput();
        String name = mapInputToName(choice);
        executeCommand(name);

    }

    private void mapHashKeysToArray() {
        setOfKeys = commands.keySet();
        hashKeys = new String[setOfKeys.size()];
        hashKeys = setOfKeys.toArray();
    }

    private String mapInputToName(int input) {
        String optionName = menuOptions[input];
        return optionName;
    }

    private int getInput() {
        Integer input = scanner.nextInt();
        return input;
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name) {
        Command command = commands.get(name);
        // perhaps move this to its own UI method
        if (command != null) {
            command.execute();
        } else {
            System.out.println("invalid Command");
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ": " + menuOptions[i]);
        }
    }

    public void displayMenuHash() {
        System.out.println("Menu:");
        int counter = 0;
        for (String name : commands.keySet()) {
            String optionWithNumber = String.format("%d: %s", counter, name);
            System.out.println(optionWithNumber);
            counter++;
        }
    }
}