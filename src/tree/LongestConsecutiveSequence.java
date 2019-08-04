package tree;

import java.time.temporal.ValueRange;

public class LongestConsecutiveSequence {

    public static int longestSequence(Tree tree){
        if(tree==null || tree.root==null) return 0;
        return longestSequence(tree.root, (Integer) tree.root.value, 0, 0);
    }

    private static int longestSequence(TreeNode<Integer> node, int expectedValue, int currentLength, int maxLength){
        if(node == null) return maxLength;
        if(node.value == expectedValue){
            currentLength++;
            maxLength = Math.max(maxLength, currentLength);
        } else {
            currentLength = 1;
        }
        if(node.left!=null) longestSequence(node.left, node.value+1, currentLength, maxLength);
        if(node.right!=null) longestSequence(node.right, node.value+1, currentLength, maxLength);
        return maxLength;
    }
}
