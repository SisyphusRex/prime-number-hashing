package primenumberhashing.receivers;

//System Imports
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
//First Party Imports
import primenumberhashing.receivers.AbstractModulo;

public class Base2Modulo extends AbstractModulo {

    public Base2Modulo(int n) {
        super(n);
    }

    @Override
    protected int makeModulo(int n) {
        return (int) Math.pow(2, n);
    }
}