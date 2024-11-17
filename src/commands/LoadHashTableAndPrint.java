package primenumberhashing.src.commands;

//System Imports
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.receivers.Receiver;
import primenumberhashing.src.CSVReader;
import primenumberhashing.src.commands.Menu;

public class LoadHashTableAndPrint extends AbstractCommand {
    CSVReader myCSVReader = new CSVReader();
    protected String keyValueFilePath = "primenumberhashing/resources/GoodKeys.csv";

    public LoadHashTableAndPrint(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    @Override
    protected void executeReceiver() {
        try {
            this.receiver.loadHashTable(this.myCSVReader.getHashMapFromCSV(this.keyValueFilePath));
            ui.printReceiver(this.receiver);
        } catch (NullPointerException e) {
            ui.displayModuloOrConstantNotCreatedError();
        }

    }
}