package primenumberhashing;

import primenumberhashing.commands.*;

public class Program {
    Menu mainMenu;
    Menu populateTablesMenu;
    Menu chooseKeyDistributionMenu;
    Menu badKeyDistributionMenu;
    Menu goodKeyDistributionMenu;

    public Program() {
        mainMenu = new Menu(null);
        populateTablesMenu = new Menu(mainMenu);
        badKeyDistributionMenu = new Menu(populateTablesMenu);
        goodKeyDistributionMenu = new Menu(populateTablesMenu);
    }

    public void run() {
        establishGoodKeyDistributionMenu();
        establishBadKeyDistributionMenu();
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

        populateTablesMenu.addCommand("Use keys with good distribution", goodKeyDistributionMenu);
        populateTablesMenu.addCommand("Use keys with poor distribution", badKeyDistributionMenu);

    }

    private void establishBadKeyDistributionMenu() {
        UseBase2ModuloBadDistributionCommand badBase2 = new UseBase2ModuloBadDistributionCommand();
        UseBase10ModuloBadDistributionCommand badBase10 = new UseBase10ModuloBadDistributionCommand();
        badKeyDistributionMenu.addCommand("Use base 2", badBase2);
        badKeyDistributionMenu.addCommand("Use base 10", badBase10);

    }

    private void establishGoodKeyDistributionMenu() {
        UseBase2ModuloGoodDistributionCommand goodBase2 = new UseBase2ModuloGoodDistributionCommand();
        UseBase10ModuloGoodDistributionCommand goodBase10 = new UseBase10ModuloGoodDistributionCommand();
        goodKeyDistributionMenu.addCommand("use base 2", goodBase2);
        goodKeyDistributionMenu.addCommand("use base 10", goodBase10);
    }
}