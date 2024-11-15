package primenumberhashing.src.commands;

//System Imports

//First Party Imports
import primenumberhashing.src.receivers.NoBaseHashTable;

public class UsePrimeModuloGoodDistributionCommand extends AbstractModuloCommand {

    public UsePrimeModuloGoodDistributionCommand(Menu parentMenu) {
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