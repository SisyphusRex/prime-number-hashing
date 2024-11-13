package primenumberhashing.receivers;

//System Imports
import java.util.LinkedList;

//First Party Imports
import primenumberhashing.receivers.KeyValueLinkedList;

public abstract class AbstractHashTable {
    protected KeyValueLinkedList<String, String>[] objects;
    protected Integer modulo;

    public AbstractHashTable(Integer n) {
        this.modulo = makeModulo(n);
        this.istantiateBlankValuesTable();
    }

    protected abstract Integer makeModulo(Integer n);

    private LinkedList<String>[] instantiateBlankValuesTable() {
        this.objects = new KeyValueLinkedList[this.modulo];
        this.instantiateBlankBuckets();
    }

    private void instantiateBlankBuckets() {
        for (int i = 0; i < this.objects.length; i++) {
            this.objects[i] = new KeyValueLinkedList<String, String>();
        }
    }

    private Integer hashFunction(String key) {
        return Integer.parseInt(key) % this.modulo;
    }

    public void put(String key, String value) {
        Integer bucket = this.hashFunction(key);
        this.objects[bucket].put(key, value);
    }

    public String get(String key) {
        Integer bucket = this.hashFunction(key);
        return this.objects[bucket].get(key);
    }

    public String toString() {
        String hashtableContents = "";
        for (int i; i < this.objects.length; i++) {
            String bucketContents = "";
            bucketContents += String.format("Bucket #%d: ", i);
            String[] contentsList = this.objects[i].getAllValues();
            for (String value : contentsList) {
                bucketContents += String.format("%s ", value);
            }

            hashtableContents += String.format("%s%n");
        }
        return hashtableContents;
    }

}