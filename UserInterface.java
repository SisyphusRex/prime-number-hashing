package primenumberhashing;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu(String[] menuOptions) {
        System.out.println("Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ": " + menuOptions[i]);
        }
    }

    public int getInput() {
        Integer input = scanner.nextInt();
        return input;
    }

    public int getN() {
        System.out.println("Type integer n:");
        return getInput();
    }

    public static void displayFileNotFoundError() {
        System.out.println("File Not Found.");
    }
}