package primenumberhashing.commands;

public class UsePrimeModuloBadDistributionCommand extends AbstractModuloCommand {
    @Override
    protected void assignHashTableType() {
        this.myHashTable = new PrimeHashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }
}