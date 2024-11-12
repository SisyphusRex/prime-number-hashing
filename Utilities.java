package primenumberhashing;

import java.util.List;

public class Utilities {

    public Integer[] convertStringArrayListToIntegerArray(List<String> data) {
        Integer[] arr = new Integer[data.size()];
        arr = data.toArray(arr);
        return arr;
    }
}