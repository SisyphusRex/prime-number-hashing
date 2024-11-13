package primenumberhashing.receivers;

//System Imports
import java.utils.LinkedList;

abstract class AbstractHashTable {
    protected LinkedList<Integer>[] values;
    protected Integer modulo;

    public AbstractHashTable(Integer n) {
        this.modulo = makeModulo(n);
        this.istantiateBlankValuesTable();
    }

    protected abstract Integer makeModulo(Integer n);

    private LinkedList<String>[] instantiateBlankValuesTable() {
        this.values = new LinkedList[this.modulo];
        this.instantiateBlankBuckets();
    }

    private void instantiateBlankBuckets() {
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = new LinkedList<String>();
        }
    }

    private Integer hashFunction(Integer key) {
        return key % this.modulo;
    }

    public void put(Integer key, String value) {
        Integer bucket = this.hashFunction(key);
        this.values[bucket] = value;
    }

    public String get(Integer key) {
        Integer bucket = this.hashFunction(key);
        return this.values[bucket];
    }

    public String toString() {
        String hashtableContents = "";
        for (int i; i < this.values.length; i++) {
            String bucketContents = "";
            bucketContents += String.format("Bucket #%d: ", i);
            for (String value : this.values[i]) {
                bucketContents += String.format("%s ", value);
            }
            hashtableContents += String.format("%s%n");
        }
        return hashtableContents;
    }

}