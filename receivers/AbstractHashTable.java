package primenumberhashing.receivers;

//System Imports
import java.util.LinkedList;
import java.util.ListIterator;

//First Party Imports

import primenumberhashing.receivers.TestObject;

public abstract class AbstractHashTable {
    protected LinkedList<TestObject>[] testObjectsTable;
    protected Integer modulo;

    public AbstractHashTable(Integer n) {
        this.modulo = makeModulo(n);
        this.instantiateBlankValuesTable();
    }

    protected abstract Integer makeModulo(Integer n);

    private void instantiateBlankValuesTable() {
        this.testObjectsTable = new LinkedList[this.modulo];
        this.instantiateBlankBuckets();
    }

    private void instantiateBlankBuckets() {
        for (int i = 0; i < this.testObjectsTable.length; i++) {
            this.testObjectsTable[i] = new LinkedList<TestObject>();
        }
    }

    private Integer hashFunction(String key) {
        return Integer.parseInt(key) % this.modulo;
    }

    public void put(TestObject inputObject) {
        Integer bucket = this.hashFunction(inputObject.key);
        this.testObjectsTable[bucket].add(inputObject);
    }

    public TestObject get(String key) {
        Integer bucketIndex = this.hashFunction(key);
        LinkedList<TestObject> bucket = this.testObjectsTable[bucketIndex];
        for (int i = 0; i < bucket.size(); i++) {
            TestObject pulledObject = bucket.get(i);
            if (pulledObject.key == key) {
                return pulledObject;
            }
        }
        return null;
    }

    public String toString() {
        String hashtableContents = "";
        for (int i = 0; i < this.testObjectsTable.length; i++) {
            String bucketContents = "";
            bucketContents += String.format("Bucket #%d: ", i);
            LinkedList<TestObject> bucket = this.testObjectsTable[i];
            ListIterator myIterator = bucket.listIterator();
            while (myIterator.hasNext()) {
                bucketContents += String.format("%s ", myIterator.next());
            }

            hashtableContents += String.format("%s%n", bucketContents);
        }
        return hashtableContents;
    }

}