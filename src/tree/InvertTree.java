package tree;

/**
 * Invert binary tree
 */
public class InvertTree {

    public static void invertTree(Tree tree){
        if(tree==null || tree.root==null) return;
        invertTree(tree.root);
    }

    private static void invertTree(TreeNode node) {
        if(node==null) return;
        invertTree(node.left);
        invertTree(node.right);
        TreeNode treeNode = node.left;
        node.left = node.right;
        node.right = treeNode;
    }
}
