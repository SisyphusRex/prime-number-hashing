package primenumberhashing.commands;

//System Imports
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
//First Party Imports
import primenumberhashing.receivers.Base2HashTable;

public class UseBase2ModuloGoodDistributionCommand extends AbstractModuloCommand implements Command {
    @Override
    public void execute() {

        int moduloN = ui.getN();

        Base2HashTable myBase2 = new Base2HashTable(moduloN);
        HashMap<String, String> data = csvReader.getHashMapFromCSV(goodKeysFilePath);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            myBase2.put(entry.getKey(), entry.getValue());
        }

        ui.printHashTable(myBase2);
    }
}