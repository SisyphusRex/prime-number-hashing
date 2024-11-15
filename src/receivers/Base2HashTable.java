package primenumberhashing.src.receivers;

import primenumberhashing.src.receivers.AbstractHashTable;

public class Base2HashTable extends AbstractHashTable {
    public Base2HashTable(Integer n) {
        super(n);
    }

    @Override
    protected Integer makeModulo(Integer n) {
        return (int) Math.pow(2, n);
    }
}