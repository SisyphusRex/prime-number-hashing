package primenumberhashing.receivers;

import primenumberhashing.receivers.AbstractHashTable;

public class Base2HashTable extends AbstractHashTable {
    public Base2HashTable(Integer n) {
        super(n);
    }

    protected Integer makeModulo(Integer n) {
        return Math.pow(2, n);
    }
}