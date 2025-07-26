// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

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
