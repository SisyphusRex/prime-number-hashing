package primenumberhashing.receivers;

import primenumberhashing.receivers.AbstractHashTable;

public class NoBaseHashTable extends AbstractHashTable {
    public NoBaseHashTable(Integer n) {
        super(n);
    }

    @Override
    protected Integer makeModulo(Integer n) {
        return (int) n;
    }
}