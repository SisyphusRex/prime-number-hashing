package primenumberhashing.commands.menus;

import java.util.HashMap;
import java.util.Map;
import primenumberhashing.commands.Command;

abstract class AbstractMenu {
    private Map<String, Command> commands = new HashMap<>();

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
        for (String name : commands.keySet()) {
            System.out.println(name);
        }
    }
}