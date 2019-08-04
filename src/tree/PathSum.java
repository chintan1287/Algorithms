package tree;

public class PathSum {

    public static boolean hasPathSum(Tree tree, int sum){
        if(tree==null || tree.root==null) return false;
        return hasPathSum(tree.root, sum);
    }

    private static boolean hasPathSum(TreeNode<Integer> node, int sum){
        if(node==null) return false;
        if(node.value == sum && (node.left==null && node.right==null))
            return true;
        return hasPathSum(node.left, sum-node.value) || hasPathSum(node.right, sum-node.value);
    }
}
