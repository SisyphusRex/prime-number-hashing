package primenumberhashing.src;

//System Imports
import java.util.Scanner;
import java.util.LinkedList;

//First Party Imports
import primenumberhashing.src.receivers.AbstractHashTable;
import primenumberhashing.src.receivers.Base2HashTable;
import primenumberhashing.src.commands.Menu;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu(Menu myMenu) {
        System.out.print(myMenu);
        this.displaySelectionCursor();

    }

    public void displaySelectionCursor() {
        System.out.println("Type Selection");
        System.out.print("> ");
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
        System.out.println("FILE NOT FOUND.");
    }

    public static void displayIndexError() {
        System.out.println("INDEX OUT OF RANGE.");
    }

    public void printLinkedListArray(LinkedList<Integer>[] keysInBuckets) {

        for (int i = 0; i < keysInBuckets.length; i++) {
            String bucketContents = "";
            bucketContents += String.format("Bucket #%d: ", i);
            for (Integer j : keysInBuckets[i]) {
                bucketContents += String.format("%d ", j);
            }
            System.out.println(bucketContents);
        }

    }

    public void printHashTable(AbstractHashTable table) {
        System.out.println(table);
    }

}