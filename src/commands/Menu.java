// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src.commands;

//System Imports
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//First Party Imports
import primenumberhashing.src.UserInterface;

public class Menu implements Command {
    private Map<String, Command> commands = new HashMap<>();
    private String[] menuOptions;
    private Menu parentMenu;
    private UserInterface ui = new UserInterface();
    private String menuName;

    public Menu(String menuName, Menu parentMenu) {
        this.menuName = menuName;
        this.parentMenu = parentMenu;
        if (parentMenu != null) {
            commands.put("Back", null);
        }
    }

    @Override
    public void execute() {
        mapHashKeysToArray();
        int choice = ui.displayMenuAndGetChoice(this.menuName, this.menuOptions);
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

    public String toString() {
        String menuString = "";
        menuString = String.format("%s%n", this.menuName);
        for (int i = 0; i < this.menuOptions.length; i++) {
            menuString += String.format("%d: %s%n", i, this.menuOptions[i]);
        }
        return menuString;
    }
}
