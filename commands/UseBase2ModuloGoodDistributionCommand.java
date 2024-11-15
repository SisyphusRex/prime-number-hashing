package primenumberhashing.commands;

//System Imports
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
//First Party Imports
import primenumberhashing.receivers.Base2HashTable;
import primenumberhashing.receivers.TestObject;
import primenumberhashing.receivers.AbstractHashTable;

public class UseBase2ModuloGoodDistributionCommand extends AbstractModuloCommand {

    public UseBase2ModuloGoodDistributionCommand(Menu parentMenu) {
        super(parentMenu);
    }

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new Base2HashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.goodKeysFilePath;
    }
}