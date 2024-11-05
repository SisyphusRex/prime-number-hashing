package primenumberhashing.commands;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;

public class Menu implements Command {
    private Map<String, Command> commands = new HashMap<>();
    private String[] menuOptions;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        mapHashKeysToArray();
        displayMenu();
        int choice = getInput();
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

    private int getInput() {
        Integer input = scanner.nextInt();
        return input;
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    private void executeCommand(String name) {
        Command command = commands.get(name);
        // perhaps move this to its own UI method
        if (command != null) {
            command.execute();
        } else {
            System.out.println("invalid Command");
        }
    }

    private void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ": " + menuOptions[i]);
        }
    }

    private void displayMenuHash() {
        System.out.println("Menu:");
        int counter = 0;
        for (String name : commands.keySet()) {
            String optionWithNumber = String.format("%d: %s", counter, name);
            System.out.println(optionWithNumber);
            counter++;
        }
    }
}