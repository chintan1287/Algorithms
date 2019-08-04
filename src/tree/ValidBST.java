package tree;

public class ValidBST {

    public static boolean isValidBST(Tree tree){
        if(tree==null || tree.root==null) return true;
        return isValidBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode<Integer> node, int min, int max) {
        if(node==null) return true;
        if(node.value<=min || node.value>=max) return false;
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }
}
