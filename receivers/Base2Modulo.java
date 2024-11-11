package primenumberhashing.receivers;

public class Base2Modulo {
    private Integer modulo;

    public Base2Modulo(int n) {
        this.modulo = 2 ^ n;
    }

    public Integer[] rangeReduce(Integer[] keys) {
        Integer[] reducedKeys = new Integer[this.modulo];
        for (int i = 0; i < keys.length; i++) {
            Integer key = keys[i];
            Integer bucket = key % this.modulo;
            reducedKeys[bucket] = key;
        }
    }
}