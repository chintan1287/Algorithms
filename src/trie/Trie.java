package trie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class Trie<Value> {

    private Node root;

    class Node {
        char c;
        Value value;
        Node left, mid, right;
    }

    public void put(String key, Value value){
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key,Value value, int d){
        char c = key.charAt(d);
        if(x==null) {
            x = new Node();
            x.c = c;
        }

        if(c<x.c) x.left = put(x.left, key, value, d);
        else if(c>x.c) x.right = put(x.right, key, value, d);
        else if(d<key.length()-1) x.mid = put(x.mid, key, value, d+1);
        else x.value = value;
        return x;
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x==null) return null;
        return (Value) x.value;
    }

    private Node get(Node x, String key, int d){
        char c = key.charAt(d);
        if(x==null) return null;
        if(c<x.c) return get(x.left, key, d);
        else if(c>x.c) return get(x.right, key, d);
        else if(d<key.length()-1) return get(x.mid, key, d+1);
        else return x;
    }

    public Iterable<String> keys(){
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> queue){
        if(x==null) return;
        if(x.value!=null) queue.add(prefix+x.c);
        collect(x.left, prefix+x.c, queue);
        collect(x.right, prefix+x.c, queue);
        collect(x.mid, prefix+x.c, queue);
    }

    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<>();
        trie.put("shell", 1);
        trie.put("shells", 2);
        trie.put("by", 3);

        System.out.println("Get shell: "+trie.get("shell"));
        System.out.println("Get shells: "+trie.get("shells"));
        System.out.println("Get by: "+trie.get("by"));

        for (String key : trie.keys()) {
            System.out.println(key);
        }
    }
}
