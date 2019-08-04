package tree;

import java.util.*;

public class TreeTraversal<Value extends Comparable> {

    public static void printInOrder(Tree tree){
        System.out.println("Inorder Treversal: ");
        printInOrder(tree.root);
        System.out.println();
    }

    private static void printInOrder(TreeNode node){
        if(node!=null) {
            printInOrder(node.left);
            System.out.print(node.value+" ");
            printInOrder(node.right);
        }
    }

    public static void printInOrderIterative(Tree tree){
        if(tree==null || tree.root== null) return;
        System.out.println("In Order Traversal Iterative: ");
        TreeNode node = tree.root;
        Stack<TreeNode> stack = new Stack<>();
        while (node!=null){
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.value+" ");
            treeNode = treeNode.right;
            while (treeNode!=null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
        }

        System.out.println();
    }

    public static void printPreOrder(Tree tree){
        System.out.println("Preorder Treversal: ");
        printPreOrder(tree.root);
        System.out.println();
    }

    private static void printPreOrder(TreeNode node){
        if(node!=null) {
            System.out.print(node.value+" ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public static void printPreOrderIterative(Tree tree){
        if(tree==null || tree.root==null) return;
        System.out.println("Pre Order Traversal Iterative: ");
        TreeNode node = tree.root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.value+" ");
            if(treeNode.right!=null) stack.push(treeNode.right);
            if(treeNode.left!=null) stack.push(treeNode.left);
        }
        System.out.println();
    }

    public static void printPostOrder(Tree tree){
        System.out.println("PostOrder Treversal: ");
        printPostOrder(tree.root);
        System.out.println();
    }

    private static void printPostOrder(TreeNode node){
        if(node!=null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value+" ");
        }
    }

    public static void printPostOrderIterative(Tree tree){
        if(tree==null || tree.root==null) return;
        System.out.println("Post Order Traversal Iterative: ");
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(tree.root);

        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left!=null) s1.push(node.left);
            if(node.right!=null) s1.push(node.right);
        }

        while (!s2.isEmpty()) System.out.print(s2.pop().value+" ");
        System.out.println();
    }

    public static void printLevelOrder(Tree tree){
        TreeNode node = tree.root;
        if(node==null) return;
        System.out.println("Level Order Traversal: ");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.value+" ");
            if(treeNode.left!=null) queue.add(treeNode.left);
            if(treeNode.right!=null) queue.add(treeNode.right);
        }
        System.out.println();
    }

    public static void printReverseLevelOrder(Tree tree){
        if(tree==null || tree.root == null) return;
        System.out.println("Reverse Level Order: ");
        TreeNode node = tree.root;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            stack.push(treeNode);
            if(treeNode.right!=null) queue.add(treeNode.right);
            if(treeNode.left!=null) queue.add(treeNode.left);
         }

         while (!stack.isEmpty())
             System.out.print(stack.pop().value+" ");
        System.out.println();
    }

    public static Map<Integer, Integer> verticalOrder(Tree tree){
        if(tree==null || tree.root==null) return null;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        verticalOrder(tree.root, treeMap, 0);
        return treeMap;
    }

    private static void verticalOrder(TreeNode<Integer> node, TreeMap<Integer, Integer> treeMap, int count){
        if(node==null) return;
        treeMap.put(count, treeMap.getOrDefault(count, 0)+node.value);
        if(node.left!=null) verticalOrder(node.left, treeMap, count-1);
        if(node.right!=null) verticalOrder(node.right, treeMap, count+1);
    }
}
