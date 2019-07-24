package BST;

public class RBT<Key extends Comparable<Key>, Value> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;

    public Value get(Key key){
        Node node = root;
        while (node!=null){
            int cmp = key.compareTo(node.key);
            if(cmp<0) node = node.left;
            else if(cmp>0) node = node.right;
            else return node.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    public Node put(Node h, Key key, Value value){
        if(h==null) return new Node(key, value, RED);
        int cmp = key.compareTo(h.key);
        if(cmp<0) h.left = put(h.left, key, value);
        else if(cmp>0) h.right = put(h.right, key, value);
        else h.value = value;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private boolean isRed(Node node){
        return node.color == RED;
    }
}
