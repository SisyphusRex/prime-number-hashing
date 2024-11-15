package primenumberhashing.commands;

//System Imports

//First Party Imports
import primenumberhashing.receivers.NoBaseHashTable;

public class UseOtherModuloBadDistributionCommand extends AbstractModuloCommand {

    public UseOtherModuloBadDistributionCommand(Menu parentMenu) {
        super(parentMenu);
    }

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new NoBaseHashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }
}