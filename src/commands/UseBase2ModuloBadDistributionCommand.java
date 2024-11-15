package primenumberhashing.src.commands;

//System Imports
import java.util.HashMap;
import java.util.Map;
//First Party Imports
import primenumberhashing.src.receivers.AbstractHashTable;
import primenumberhashing.src.commands.Command;
import primenumberhashing.src.receivers.Base2HashTable;
import primenumberhashing.src.receivers.TestObject;

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