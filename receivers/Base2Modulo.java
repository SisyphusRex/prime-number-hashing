package primenumberhashing.receivers;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

import primenumberhashing.commands.Command;

public class Base2Modulo {
    private Integer modulo;

    public Base2Modulo(int n) {
        this.modulo = (int) Math.pow(2, n);
    }

    public LinkedList<Integer>[] rangeReduce(Integer[] keys) {

        LinkedList<Integer>[] reducedKeys = new LinkedList[this.modulo];
        for (int i = 0; i < this.modulo; i++) {
            reducedKeys[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < keys.length; i++) {
            Integer value = keys[i];
            Integer bucket = Integer.valueOf(value % this.modulo);

            reducedKeys[bucket].add(value);
        }
        return reducedKeys;
    }
}