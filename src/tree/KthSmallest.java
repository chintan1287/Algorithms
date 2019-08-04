package tree;

import java.util.Stack;

/**
 * Given a binary search tree,
 * write a function kthSmallest to find the kth smallest element in it.
 * (1 ≤ k ≤ BST's total elements)
 */

public class KthSmallest {

    public TreeNode kthSmallestNode(Tree tree, int k){
        if(tree==null || tree.root==null) return null;
        // Use iterative inorder traversal approach

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree.root;

        while (!stack.isEmpty() || node!=null) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            } else {
              TreeNode treeNode = stack.pop();
              k--;
              if(k==0) return treeNode;
              node = treeNode.right;
            }
        }
        return null;
    }


}
