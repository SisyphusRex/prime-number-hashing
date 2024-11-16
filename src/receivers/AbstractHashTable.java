package primenumberhashing.src.receivers;

//System Imports
import java.util.LinkedList;
import java.util.ListIterator;

//First Party Imports

import primenumberhashing.src.receivers.TestObject;

public abstract class AbstractHashTable {
    protected LinkedList<TestObject>[] bucketArray;
    protected Integer modulo;
    protected Integer hashConstant;

    public AbstractHashTable(Integer n) {
        this.modulo = makeModulo(n);
        this.instantiateBucketArray();
    }

    protected abstract Integer makeModulo(Integer n);

    private void instantiateBucketArray() {
        this.bucketArray = new LinkedList[this.modulo];
        this.instantiateBuckets();
    }

    private void instantiateBuckets() {
        for (int i = 0; i < this.bucketArray.length; i++) {
            this.bucketArray[i] = new LinkedList<TestObject>();
        }
    }

    private Integer getBucketIndex(String key) {
        Integer hash = this.hashFunction(key);
        Integer index = this.rangeReduce(hash);
        return index;
    }

    private Integer rangeReduce(Integer hash) {
        Integer index = hash % this.modulo;
        return index;
    }

    private Integer hashFunction(String key) {
        Integer integereddKey = Integer.valueOf(key);
        Integer hash = (integereddKey * 11);
        key = String.valueOf(hash);
        key += "07";
        hash = Integer.valueOf(key);
        return hash;
    }

    public void put(TestObject inputObject) {
        Integer bucketIndex = this.getBucketIndex(inputObject.key);
        this.bucketArray[bucketIndex].add(inputObject);
    }

    public TestObject get(String key) {
        Integer bucketIndex = this.getBucketIndex(key);
        LinkedList<TestObject> bucket = this.bucketArray[bucketIndex];
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
        for (int i = 0; i < this.bucketArray.length; i++) {
            String bucketContents = "";
            bucketContents += String.format("Bucket #%d: ", i);
            LinkedList<TestObject> bucket = this.bucketArray[i];
            ListIterator myIterator = bucket.listIterator();
            while (myIterator.hasNext()) {
                bucketContents += String.format("%s ", myIterator.next());
            }

            hashtableContents += String.format("%s%n", bucketContents);
        }
        return hashtableContents;
    }

}