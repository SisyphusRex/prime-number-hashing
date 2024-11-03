package primenumberhashing.menus;

import java.util.Scanner;
import java.util.HashMap;

public abstract class AbstractMenu {

    protected Scanner scanner;

    protected String[] menuOptions;

    public AbstractMenu() {
        scanner = new Scanner(System.in);
        menuOptions = assignMenuOptions();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getChoice();
            if (choice == 0) {
                break;
            }
            processChoice(choice);
        }
    }

    protected abstract String[] assignMenuOptions();

    protected void displayMenu() {
        System.out.println("0: Exit");
        for (int i = 1; i < menuOptions.length + 1; i++) {
            String menuLine = String.format("%d: %s", i, menuOptions[i - 1]);
            System.out.println(menuLine);
        }
    }

    private int getChoice() {
        System.out.print("Enter your choice: ");
        int choice = getInt();
        return choice;
    }

    private int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid choice. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean isInMenu(int choice) {
        if ((0 < choice) && (choice <= menuOptions.length)) {
            return true;
        }
        System.out.println("Choice not in menu.")
        return false;
    }

    protected abstract void processChoice(int choice);
}