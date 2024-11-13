package primenumberhashing.receivers;

//System Imports
import java.util.LinkedList;
//First Party Imports

public class KeyValueLinkedList<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>> list = new LinkedList<>();

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<K, V>(key, value);
        list.add(newNode);
    }

    public V get(K key) {
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V[] getAllValues() {
        V[] allValues = new V[list.size()];
        int counter = 0;
        for (Node<K, V> node : list) {
            allValues[counter] = node.value;
            counter++;
        }
        return allValues;
    }

}