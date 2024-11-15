package primenumberhashing.src.receivers;

import primenumberhashing.src.receivers.AbstractHashTable;

public class Base10HashTable extends AbstractHashTable {
    public Base10HashTable(Integer n) {
        super(n);
    }

    @Override
    protected Integer makeModulo(Integer n) {
        return (int) Math.pow(10, n);
    }
}