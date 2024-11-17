package primenumberhashing.src;

//System Imports
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.commands.ChangeModulo;
import primenumberhashing.src.commands.ChangeHashConstant;
import primenumberhashing.src.commands.ChangeHashPattern;
import primenumberhashing.src.commands.LoadHashTableAndPrint;
import primenumberhashing.src.commands.RemoveHashPattern;
import primenumberhashing.src.commands.Menu;
import primenumberhashing.src.commands.ExitProgramCommand;
import primenumberhashing.src.CSVReader;
import primenumberhashing.src.receivers.HashTable;

public class Program {
    CSVReader myCSVReader = new CSVReader();
    String goodKeysFilePath = "primenumberhashing/resources/GoodKeys.csv";
    HashTable myHashTable = new HashTable();
    Menu modifyHashPatternMenu;
    Menu modifyHashTableMenu;
    Menu mainMenu;

    public Program() {
        mainMenu = new Menu("Main Menu", null);
        modifyHashTableMenu = new Menu("HashTable Parameters Menu", mainMenu);
        modifyHashPatternMenu = new Menu("Modify Hash Pattern Menu", modifyHashTableMenu);
    }

    public void run() {
        establishModifyHashPatternMenu();
        establishModifyHashTableMenu();
        establishMainMenu();
        mainMenu.execute();
    }

    private void establishMainMenu() {
        ExitProgramCommand exitProgram = new ExitProgramCommand();
        this.mainMenu.addCommand("Create a HashTable", this.modifyHashTableMenu);
        this.mainMenu.addCommand("Exit Program", exitProgram);
    }

    private void establishModifyHashTableMenu() {
        ChangeModulo changeModulo = new ChangeModulo(modifyHashTableMenu, myHashTable);
        ChangeHashConstant changeHashConstant = new ChangeHashConstant(modifyHashTableMenu, myHashTable);
        LoadHashTableAndPrint loadHashTableAndPrint = new LoadHashTableAndPrint(modifyHashTableMenu, myHashTable);
        this.modifyHashTableMenu.addCommand("Load data into HashTable and Print", loadHashTableAndPrint);
        this.modifyHashTableMenu.addCommand("Change HashTable Modulo", changeModulo);
        this.modifyHashTableMenu.addCommand("Change the Hash Constant", changeHashConstant);
        this.modifyHashTableMenu.addCommand("Change the Hash Pattern", this.modifyHashPatternMenu);
    }

    private void establishModifyHashPatternMenu() {
        ChangeHashPattern changeHashPattern = new ChangeHashPattern(modifyHashPatternMenu, myHashTable);
        RemoveHashPattern removeHashPattern = new RemoveHashPattern(modifyHashPatternMenu, myHashTable);
        this.modifyHashPatternMenu.addCommand("Remove hash pattern", removeHashPattern);
        this.modifyHashPatternMenu.addCommand("Create new hash pattern", changeHashPattern);
    }

}