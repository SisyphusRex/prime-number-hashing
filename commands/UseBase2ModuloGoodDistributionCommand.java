package primenumberhashing.commands;

import primenumberhashing.receivers.Base2Modulo;
import java.util.List;
import java.util.LinkedList;

public class UseBase2ModuloGoodDistributionCommand extends AbstractModuloCommand implements Command {
    @Override
    public void execute() {

        int moduloN = ui.getN();
        Base2Modulo myBase2 = new Base2Modulo(moduloN);
        List<List<String>> data = csvReader.getArrayFromCSV(goodKeysFilePath);
        Integer[] keys = utils.convertStringArrayListToIntegerArray(data.get(0));
        LinkedList<Integer>[] keysInBuckets = myBase2.rangeReduce(keys);

    }
}