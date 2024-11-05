package primenumberhashing;

public class Program {
    public void run() {
        Menu mainMenu = new Menu();
        Menu hashMapCreationMenu = new Menu();
        Command exitProgram = new Command();
        mainMenu.addCommand("Exit Program", exitProgram);
        mainMenu.addCommand("Create HashMaps", hashMapCreationMenu);

        mainMenu.execute();

    }
}