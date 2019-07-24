package trie;

public class TrieST<Value> {

    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        Object value;
        private Node[] next = new Node[R];
    }

    public void put(String key, Value value){
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d){
        if(x==null) x = new Node();
        if(d == key.length()) {
            x.value = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d+1);
        return x;
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x==null || x.value == null) return null;
        return (Value) x.value;
    }

    private Node get(Node x, String key, int d){
        if(x==null) return null;
        if(d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void delete(String key){
        Node x = get(root, key, 0);
        if(x==null) return;
        x.value = null;
    }

    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST<>();
        trieST.put("by", 4);
        trieST.put("shell", 5);
        trieST.put("shells", 6);

        System.out.println("Get by: "+trieST.get("by"));
        System.out.println("Get shell: "+trieST.get("shell"));
        System.out.println("Get shells: "+trieST.get("shells"));

        trieST.delete("by");
        System.out.println("Get by: "+trieST.get("by"));
    }
}
