package primenumberhashing.commands;

public class UseBase10ModuloBadDistributionCommand extends AbstractModuloCommand {

    @Override
    protected void assignHashTableType() {
        this.myHashTable = new Base10HashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }
}