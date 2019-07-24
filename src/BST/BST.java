package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    class Node {
        Key key;
        Value value;
        Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public Value get(Key key){
        Node node = root;
        while (node!=null) {
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

    private Node put(Node node, Key key, Value value){
        if(node==null) return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if(cmp<0) node.left = put(node.left, key, value);
        else if(cmp>0) node.right = put(node.right, key, value);
        else node.value = value;
        return node;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node node, Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp<0) node.left = delete(node.left, key);
        else if(cmp>0) node.right = delete(node.right, key);
        else {
            if(node.left==null) return node.right;
            if(node.right==null) return node.left;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node node){
        if(node==null) return null;
        if(node.left==null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    private Node min(Node node){
        if(node==null) return null;
        while (node.left!=null)
            node = node.left;
        return node;
    }

    public Value min(){
        Node node = root;
        while (node.left!=null) {
            node = node.left;
        }
        return node.value;
    }

    public Value max(){
        Node node = root;
        while (node.right!=null) {
            node = node.right;
        }
        return node.value;
    }

    public Value floor(Key key){
        Node node = floor(root, key);
        if(node==null) return null;
        return node.value;
    }

    private Node floor(Node node, Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp==0) return node;
        else if (cmp<0) return floor(node.left, key);
        else if(cmp>0) {
            Node t = floor(node.right, key);
            if(t!=null) return t;
            else return node;
        }
        return null;
    }

    public Value ceil(Key key){
        Node node = ceil(root, key);
        if(node==null) return null;
        return node.value;
    }

    private Node ceil(Node node, Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp==0) return node;
        else if (cmp>0) return ceil(node.right, key);
        else if(cmp<0) {
            Node t = ceil(node.left, key);
            if(t!=null) return t;
            else return node;
        }
        return null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node==null) return 0;
        return 1+size(node.left)+size(node.right);
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node node, Key key){
        if(node==null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp<0) return rank(node.left, key);
        else if(cmp>0) return 1+size(node.left)+rank(node.right, key);
        else if(cmp==0) return size(node.left);
        return 0;
    }

    public void printInOrder(){
        System.out.println("Inorder: ");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node){
        if(node==null) return;
        printInOrder(node.left);
        System.out.print(node.value+" ");
        printInOrder(node.right);
    }

    public void printPreOrder(){
        System.out.println("PreOrder: ");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node){
        if(node==null) return;
        System.out.print(node.value+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(){
        System.out.println("PostOrder: ");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node node){
        if(node==null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value+" ");
    }

    public void printLevelOrder(){
        System.out.println("LevelOrder: ");
        Node node = root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            System.out.print(x.value+" ");
            if(x.left!=null) queue.add(x.left);
            if(x.right!=null) queue.add(x.right);
        }
    }

    public static void main(String[] args) {

        /**
         * Tree
         *          50
         *         /  \
         *        25   75
         *       /  \  / \
         *      15  35 65 85
         *                 \
         *                 95
         */
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(50, 50);
        bst.put(25, 25);
        bst.put(75, 75);
        bst.put(15, 15);
        bst.put(35, 35);
        bst.put(65, 65);
        bst.put(85, 85);
        bst.put(95, 95);
        System.out.println("BST get 65: "+bst.get(65));
        System.out.println("Max: "+bst.max());
        System.out.println("Min: "+bst.min());
        System.out.println("Floor of 80: "+bst.floor(80));
        System.out.println("Ceil of 80: "+bst.ceil(80));
        System.out.println("Size of the tree: "+bst.size());
        System.out.println("Rank of 76: "+bst.rank(76) );
        bst.printInOrder();
        bst.printPreOrder();
        bst.printPostOrder();
        bst.printLevelOrder();
    }
}
