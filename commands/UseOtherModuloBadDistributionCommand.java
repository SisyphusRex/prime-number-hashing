package primenumberhashing.commands;

public class UseOtherModuloBadDistributionCommand extends AbstractModuloCommand {
    @Override
    protected void assignHashTableType() {
        this.myHashTable = new OtherHashTable(this.moduloN);
    }

    @Override
    protected void assignMyFilePath() {
        this.myFilePath = this.badKeysFilePath;
    }
}