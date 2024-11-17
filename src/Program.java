package primenumberhashing.src;

//System Imports
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.commands.ChangeModulo;
import primenumberhashing.src.commands.ChangeHashConstant;
import primenumberhashing.src.commands.ChangeHashPattern;
import primenumberhashing.src.commands.LoadHashTableAndPrint;
import primenumberhashing.src.commands.Menu;
import primenumberhashing.src.CSVReader;
import primenumberhashing.src.receivers.HashTable;

public class Program {
    CSVReader myCSVReader = new CSVReader();
    String goodKeysFilePath = "primenumberhashing/resources/GoodKeys.csv";
    Menu mainMenu;

    public Program() {

        mainMenu = new Menu("Main Menu", null);

    }

    public void run() {
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