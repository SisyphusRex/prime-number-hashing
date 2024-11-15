package primenumberhashing.commands;

//System Imports

//First Party Imports

public class UsePrimeModuloGoodDistributionCommand extends AbstractModuloCommand {
    @Override
    protected void assignHashTableType() {
        this.myHashTable = new PrimeHashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.goodKeysFilePath;
    }
}