package primenumberhashing.commands;

import primenumberhashing.UserInterface;
import primenumberhashing.Utilities;
import primenumberhashing.CSVReader;
import primenumberhashing.receivers.AbstractHashTable;
import primenumberhashing.receivers.TestObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractModuloCommand implements Command {
    protected String myFilePath;
    protected AbstractHashTable myHashTable;
    protected HashMap<String, String> data;
    protected int moduloN;
    protected String goodKeysFilePath = "primenumberhashing/keys/GoodKeys.csv";
    protected String badKeysFilePath = "primenumberhashing/keys/BadKeys.csv";
    protected CSVReader csvReader = new CSVReader();
    protected UserInterface ui = new UserInterface();
    protected Utilities utils = new Utilities();
    protected Menu parentMenu;

    public AbstractModuloCommand(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute() {
        this.moduloN = this.ui.getN();
        this.assignHashTableType();
        this.assignMyFilePath();
        this.moveFromCSVToHashTable();
        this.ui.printHashTable(this.myHashTable);
        this.parentMenu.execute();
    }

    abstract protected void assignHashTableType();

    abstract protected void assignMyFilePath();

    protected void getFromCSV() {
        this.data = this.csvReader.getHashMapFromCSV(this.myFilePath);
    }

    protected void moveFromCSVToHashTable() {
        getFromCSV();
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            TestObject newObject = new TestObject(entry.getKey(), entry.getValue());
            this.myHashTable.put(newObject);
        }
    }

}