package primenumberhashing;

import primenumberhashing.commands.*;

public class Program {
    Menu mainMenu;
    Menu populateTablesMenu;
    Menu compareDataMenu;
    Menu badKeyDistributionMenu;
    Menu goodKeyDistributionMenu;

    public Program() {
        mainMenu = new Menu("Main Menu", null);
        populateTablesMenu = new Menu("Populate HashTables Menu", mainMenu);
        compareDataMenu = new Menu("Compare Statistics Menu", mainMenu);

        badKeyDistributionMenu = new Menu("Bad Key Distribution Menu", populateTablesMenu);
        goodKeyDistributionMenu = new Menu("Good Key Distribution Menu", populateTablesMenu);
    }

    public void run() {
        establishGoodKeyDistributionMenu();
        establishBadKeyDistributionMenu();
        establishPopulateTablesMenu();
        establishCompareDataMenu();
        establishMainMenu();
        mainMenu.execute();
    }

    private void establishMainMenu() {
        ExitProgramCommand exitProgram = new ExitProgramCommand();
        mainMenu.addCommand("Exit Program", exitProgram);
        mainMenu.addCommand("Populate Tables", populateTablesMenu);
        mainMenu.addCommand("Compare Data", compareDataMenu);
    }

    private void establishCompareDataMenu() {
        CompareStatisticsOfTables compareStats = new CompareStatisticsOfTables();

        compareDataMenu.addCommand("Compare Table Statistics", compareStats);
    }

    private void establishPopulateTablesMenu() {

        populateTablesMenu.addCommand("Use keys with good distribution", goodKeyDistributionMenu);
        populateTablesMenu.addCommand("Use keys with poor distribution", badKeyDistributionMenu);

    }

    private void establishBadKeyDistributionMenu() {
        UseBase2ModuloBadDistributionCommand badBase2 = new UseBase2ModuloBadDistributionCommand(
                badKeyDistributionMenu);
        UseBase10ModuloBadDistributionCommand badBase10 = new UseBase10ModuloBadDistributionCommand(
                badKeyDistributionMenu);
        UsePrimeModuloBadDistributionCommand badPrime = new UsePrimeModuloBadDistributionCommand(
                badKeyDistributionMenu);
        UseOtherModuloBadDistributionCommand badOther = new UseOtherModuloBadDistributionCommand(
                badKeyDistributionMenu);
        badKeyDistributionMenu.addCommand("Use base 2 Modulo", badBase2);
        badKeyDistributionMenu.addCommand("Use base 10 Modulo", badBase10);
        badKeyDistributionMenu.addCommand("Use Prime Modulo", badPrime);
        badKeyDistributionMenu.addCommand("Use other Modulo", badOther);

    }

    private void establishGoodKeyDistributionMenu() {
        UseBase2ModuloGoodDistributionCommand goodBase2 = new UseBase2ModuloGoodDistributionCommand(
                goodKeyDistributionMenu);
        UseBase10ModuloGoodDistributionCommand goodBase10 = new UseBase10ModuloGoodDistributionCommand(
                goodKeyDistributionMenu);
        UsePrimeModuloGoodDistributionCommand goodPrime = new UsePrimeModuloGoodDistributionCommand(
                goodKeyDistributionMenu);
        UseOtherModuloGoodDistributionCommand goodOther = new UseOtherModuloGoodDistributionCommand(
                goodKeyDistributionMenu);
        goodKeyDistributionMenu.addCommand("Use base 2 Modulo", goodBase2);
        goodKeyDistributionMenu.addCommand("Use base 10 Modulo", goodBase10);
        goodKeyDistributionMenu.addCommand("Use Prime Modulo", goodPrime);
        goodKeyDistributionMenu.addCommand("Use Other Modulo", goodOther);
    }

}