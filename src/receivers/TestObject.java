package primenumberhashing.src.receivers;

//System Imports

//First Party Imports

public class TestObject {
    public String key;
    public String value;
    private int maxLength = 4;

    public TestObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        String name = this.value;
        if (name.length() >= maxLength) {
            return String.format("(%s)", this.value.substring(0, 3));
        } else {
            return String.format("(%s)", this.value);
        }

    }
}