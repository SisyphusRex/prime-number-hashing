package primenumberhashing;

import java.util.List;

public class Utilities {

    public Integer[] convertStringArrayListToIntegerArray(List<String> data) {

        Integer[] arr = new Integer[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = Integer.valueOf(data.get(i));
        }
        return arr;
    }
}