package primenumberhashing.commands;

import primenumberhashing.receivers.Base2HashTable;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class UseBase2ModuloGoodDistributionCommand extends AbstractModuloCommand implements Command {
    @Override
    public void execute() {

        int moduloN = ui.getN();

        Base2HashTable myBase2 = new Base2HashTable(moduloN);
        Hashmap<String, String> data = csvReader.getArrayFromCSV(goodKeysFilePath);
        for (key, value : data) {

        }
        Integer[] keys = utils.convertStringArrayListToIntegerArray(data.get(0));
        LinkedList<Integer>[] hashTable = myBase2.createHashTable(keys);
        ui.printLinkedListArray(hashTable);
    }
}