package primenumberhashing.src.receivers;

//System Imports
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.receivers.ReceiversInterface;
import primenumberhashing.src.receivers.TestObject;
import primenumberhashing.src.receivers.TestObject;

public class HashTable extends Receiver {

    protected LinkedList<TestObject>[] bucketArray;
    protected Integer modulo;
    protected Integer hashConstant;
    protected String hashPattern = "";
    protected HashMap<String, String> keyValueData;

    public void loadHashTable(HashMap data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            TestObject newObject = new TestObject(entry.getKey(), entry.getValue());
            this.put(newObject);
        }
    }

    public void changeModulo(Integer newModulo) {
        this.modulo = newModulo;
        this.instantiateBucketArray();
    }

    public void changeHashConstant(Integer newHashConstant) {
        this.hashConstant = newHashConstant;
    }

    public void changeHashPattern(String newHashPattern) {
        this.hashPattern = newHashPattern;
    }

    public void put(TestObject inputObject) {
        Integer bucketIndex = this.getBucketIndex(inputObject.key);
        this.bucketArray[bucketIndex].add(inputObject);
    }

    public void moveAllObjectsFromHashMapToHashTable(HashMap data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            TestObject newObject = new TestObject(entry.getKey(), entry.getValue());
            this.put(newObject);
        }
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

    public class Hash {
        private Integer hashedKey;

        public Hash(Integer hashedKey) {
            this.hashedKey = hashedKey;
        }

        public void addHashPattern(String pattern) {
            String tempHashedKey = String.valueOf(this.hashedKey);
            tempHashedKey += pattern;
            this.hashedKey = Integer.valueOf(tempHashedKey);
        }

        public Integer getHashedKey() {
            return this.hashedKey;
        }

    }

    private Integer hashFunction(String key) {
        Integer integereddKey = Integer.valueOf(key);
        Hash hash = new Hash(integereddKey * this.hashConstant);
        hash.addHashPattern(this.hashPattern);
        return hash.getHashedKey();
    }

    private String addHashPattern(String hash) {
        hash += this.hashPattern;
        return hash;
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