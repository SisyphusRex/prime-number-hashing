package primenumberhashing.src.commands;

//System Imports

//First Party Imports
import primenumberhashing.src.receivers.Base10HashTable;

public class UseBase10ModuloBadDistributionCommand extends AbstractModuloCommand {

    public UseBase10ModuloBadDistributionCommand(Menu parentMenu) {
        super(parentMenu);
    }

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new Base10HashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }
}