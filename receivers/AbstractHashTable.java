package primenumberhashing.receivers;

//System Imports
import java.utils.LinkedList;

abstract class AbstractHashTable {
    LinkedList<Integer>[] values;
    protected Integer modulo;

    public AbstractHashTable(Integer n) {
        this.modulo = makeModulo(n);
        this.istantiateBlankValuesTable();
    }

    protected abstract Integer makeModulo(Integer n);

    private LinkedList<Integer>[] instantiateBlankValuesTable() {
        this.values = new LinkedList[this.modulo];
        this.instantiateBlankBuckets();
    }

    private void instantiateBlankBuckets() {
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = new LinkedList<Integer>();
        }
    }

    private Integer hashFunction(Integer key) {
        return key % this.modulo;
    }
}