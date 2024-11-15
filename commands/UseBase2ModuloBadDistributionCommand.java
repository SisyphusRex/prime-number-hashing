package primenumberhashing.commands;

//System Imports
import java.util.HashMap;
import java.util.Map;
//First Party Imports
import primenumberhashing.receivers.AbstractHashTable;
import primenumberhashing.commands.Command;
import primenumberhashing.receivers.Base2HashTable;
import primenumberhashing.receivers.TestObject;

public class UseBase2ModuloBadDistributionCommand extends AbstractModuloCommand {

    public UseBase2ModuloBadDistributionCommand(Menu parentMenu) {
        super(parentMenu);
    }

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new Base2HashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }

}