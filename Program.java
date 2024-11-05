package primenumberhashing;

import primenumberhashing.commands.*;;

public class Program {
    Menu mainMenu;
    Menu populateTablesMenu;
    Menu chooseKeyDistributionMenu;

    public Program() {
        mainMenu = new Menu();
        populateTablesMenu = new Menu();
        chooseKeyDistributionMenu = new Menu();
    }

    public void run() {
        establishPopulateTablesMenu();
        establishMainMenu();
        mainMenu.execute();
    }

    private void establishMainMenu() {
        ExitProgramCommand exitProgram = new ExitProgramCommand();
        mainMenu.addCommand("Exit Program", exitProgram);
        mainMenu.addCommand("Populate Tables", populateTablesMenu);
    }

    private void establishPopulateTablesMenu() {
        ReturnPreviousMenuCommand returnPreviousMenu = new ReturnPreviousMenuCommand();
        UseBase2ModuloCommand useBase2 = new UseBase2ModuloCommand();
        UseBase10ModuloCommand useBase10 = new UseBase10ModuloCommand();
        populateTablesMenu.addCommand("Return to Previous Menu", returnPreviousMenu);

    }

    priv
}