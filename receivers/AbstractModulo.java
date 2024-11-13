package primenumberhashing.receivers;

//System Imports
import java.util.LinkedList;

//First Party Imports

abstract class AbstractModulo {
    public Integer modulo;

    public AbstractModulo(int n) {
        this.modulo = makeModulo(n);
    }

    protected abstract Integer makeModulo(Integer n);

    public LinkedList<Integer>[] createHashTable(Integer[] values) {

        // instantiate the hashtable (an array of linked lists)
        LinkedList<Integer>[] hashTable = new LinkedList[this.modulo];

        // instantiate the buckets
        for (int i = 0; i < this.modulo; i++) {
            hashTable[i] = new LinkedList<Integer>();
        }

        // map each value to bucket and add value to that bucket
        for (int i = 0; i < values.length; i++) {
            Integer value = values[i];
            Integer bucket = hashingFunction(value);

            hashTable[bucket].add(value);
        }
        return hashTable;
    }

    private Integer hashingFunction(Integer value) {
        return Integer.valueOf(value % this.modulo);
    }
}