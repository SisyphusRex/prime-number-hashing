// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src;

//System Imports
import java.util.Scanner;
import java.util.LinkedList;

//First Party Imports

import primenumberhashing.src.commands.Menu;
import primenumberhashing.src.receivers.Receiver;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public Integer displayMenuAndGetChoice(String name, String[] menuOptions) {
        String input = "";
        boolean isValidated = false;
        Integer choice = null;
        while (!isValidated) {
            System.out.println(name);
            this.printMenuOptions(menuOptions);
            input = this.getMenuChoice();
            isValidated = this.checkIfInteger(input);
            if (isValidated) {
                choice = Integer.valueOf(input);
                if (choice >= menuOptions.length) {
                    System.out.println("Choice not in menu.");
                    isValidated = false;
                }
            }
        }
        return choice;
    }

    public String getMenuChoice() {
        this.displaySelectionCursor();
        String input = this.getInput();
        System.out.println();
        return input;

    }

    public String getHashPattern() {
        boolean isValidated = false;
        String input = "";
        while (!isValidated) {
            System.out.println("Type the Pattern to concatenate to end of Hash:");
            input = this.getInput();
            isValidated = this.checkIfInteger(input);
        }
        System.out.println();
        return input;
    }

    public Integer getHashConstant() {
        boolean isValidated = false;
        String input = "";
        while (!isValidated) {
            System.out.println("Type an integer to be the hash constant:");
            input = this.getInput();
            isValidated = this.checkIfInteger(input);
        }
        Integer hashConstant = Integer.valueOf(input);
        System.out.println();
        return hashConstant;
    }

    public Integer getModulo() {
        boolean isValidated = false;
        String input = "";
        while (!isValidated) {
            System.out.println("Type an integer to be the modulo:");
            input = this.getInput();
            isValidated = this.checkIfInteger(input);
        }
        Integer modulo = Integer.valueOf(input);
        System.out.println();
        return modulo;

    }

    public static void displayFileNotFoundError() {
        System.out.println("FILE NOT FOUND.");
        System.out.println();
    }

    public static void displayIndexError() {
        System.out.println("INDEX OUT OF RANGE.");
        System.out.println();
    }

    public void displayModuloOrConstantNotCreatedError() {
        System.out.println(String
                .format("You cannot load the hashtable yet.%nYou must create a modulo and a hash constant first."));
        System.out.println();
    }

    public void displayNoIntegerError() {
        System.out.println("NOT A POSITIVE INTEGER.%n");
        System.out.println();
    }

    public void printReceiver(Receiver receiver) {
        System.out.println(receiver);
        System.out.println();
    }

    private String getInput() {
        String input = scanner.next();
        return input;
    }

    private void displaySelectionCursor() {
        System.out.println("Type Selection");
        System.out.print("> ");
    }

    private boolean checkIfInteger(String toCheck) {
        try {
            Integer myInt = Integer.valueOf(toCheck);
            if (myInt < 0) {
                return false;
            } else {
                return true;
            }

        } catch (NumberFormatException e) {
            this.displayNoIntegerError();
            return false;
        }
    }

    private void printMenuOptions(String[] menuOptions) {
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(String.format("%d: %s", i, menuOptions[i]));
        }
    }
}
