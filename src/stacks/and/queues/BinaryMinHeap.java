package stacks.and.queues;

import java.util.*;

/**
 * Operations:
 * 1. deleteMin
 * 2. insert
 * 3. containsKey
 * 4. decrease
 */
public class BinaryMinHeap<Key, Value extends Comparable<Value>> {

    class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Node> nodes;
    private Map<Key, Integer> map;

    public BinaryMinHeap() {
        this.nodes = new ArrayList<>();
        nodes.add(null);
        this.map = new HashMap<Key, Integer>();
    }

    public boolean isEmpty(){
        return map.size()==0;
    }

    public boolean contains(Key key){
        return map.containsKey(key);
    }

    public void insert(Key key, Value value){
        Node node = new Node(key, value);
        nodes.add(node);
        map.put(key, nodes.size()-1);
        swim(nodes.size()-1);
    }

    public Key deleteMin(){
        Key value = nodes.get(1).key;
        map.remove(nodes.get(1).key);
        Collections.swap(nodes, 1, nodes.size()-1);
        nodes.remove(nodes.size()-1);
        sink(1);
        return value;
    }

    public void decrease(Key key, Value value){
        if(!contains(key)) return;
        int index = map.get(key);
        nodes.get(index).value = value;
        swim(index);
    }

    private void swim(int k){
        while (k>1 && less(k,k/2)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= nodes.size()-1){
            int j = 2*k;
            if(j<nodes.size()-1 && less(j, j+1))
                j = j+1;
            if(!less(j, k)) break;
            swap(j, k);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return nodes.get(i).value.compareTo(nodes.get(j).value) < 0;
    }

    private void swap(int i, int j){
        updateMapIndex(i,j);
        Collections.swap(nodes, i, j);
    }

    private void updateMapIndex(int i, int j){
        Key keyI = nodes.get(i).key;
        Key keyJ = nodes.get(j).key;

        map.put(keyI, j);
        map.put(keyJ, i);
    }

    public static void main(String[] args) {
        BinaryMinHeap<Character, Integer> binaryMinHeap = new BinaryMinHeap<>();
        binaryMinHeap.insert('b', 2);
        binaryMinHeap.insert('a', -1);
        binaryMinHeap.insert('f', 7);
        binaryMinHeap.insert('c', 6);
        binaryMinHeap.insert('e', 5);
        binaryMinHeap.insert('d', 4);
        binaryMinHeap.insert('g', 8);

        System.out.println("Contains a: "+binaryMinHeap.contains('a'));
        System.out.println("Min: "+binaryMinHeap.deleteMin());
        binaryMinHeap.decrease('f',-5);
        System.out.println("Contains f: "+binaryMinHeap.contains('f'));
        System.out.println("Min: "+binaryMinHeap.deleteMin());
    }
}
