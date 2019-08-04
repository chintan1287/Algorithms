package tree;

import java.util.Map;

public class Tree<Value extends Comparable<Value>> {

    TreeNode<Value> root;

    public TreeNode get(Value value){
        TreeNode<Value> node = root;
        while (node!=null) {
            int cmp = value.compareTo(node.value);
            if(cmp<0) node = node.left;
            else if(cmp>0) node = node.right;
            else return node;
        }
        return null;
    }

    public void put(Value value){
        root = put(root, value);
    }

    private TreeNode put(TreeNode<Value> node, Value value){
        if(node == null) return new TreeNode(value);
        int cmp = value.compareTo(node.value);
        if(cmp<0) node.left = put(node.left, value);
        else if(cmp>0) node.right = put(node.right, value);
        return node;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.put(50);
        tree.put(25);
        tree.put(75);
        tree.put(12);
        tree.put(37);
        tree.put(62);
        tree.put(87);

        // Tree Traversals

        // 1. In Order
        TreeTraversal.printInOrder(tree);
        TreeTraversal.printInOrderIterative(tree);
        // 2. Pre Order
        TreeTraversal.printPreOrder(tree);
        TreeTraversal.printPreOrderIterative(tree);
        // 3. Post Order
        TreeTraversal.printPostOrder(tree);
        TreeTraversal.printPostOrderIterative(tree);
        // 4. Level Order
        TreeTraversal.printLevelOrder(tree);
        // 5. Lever Oder in Reverse
        TreeTraversal.printReverseLevelOrder(tree);


        // Invert Tree
        InvertTree.invertTree(tree);
        TreeTraversal.printLevelOrder(tree);
        InvertTree.invertTree(tree);

        //Vertical Sum
        Map<Integer, Integer> map = TreeTraversal.verticalOrder(tree);
        for (Integer key : map.keySet())
            System.out.println("key: "+key+" val: "+map.get(key));

        // Valid BST
        System.out.println("Tree is valid BST: "+ValidBST.isValidBST(tree));
    }
}
