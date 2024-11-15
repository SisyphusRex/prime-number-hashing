package primenumberhashing.commands;

//System Imports

//First Party Imports
import primenumberhashing.receivers.NoBaseHashTable;

public class UseOtherModuloGoodDistributionCommand extends AbstractModuloCommand {

    public UseOtherModuloGoodDistributionCommand(Menu parentMenu) {
        super(parentMenu);
    }

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new NoBaseHashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.goodKeysFilePath;
    }
}