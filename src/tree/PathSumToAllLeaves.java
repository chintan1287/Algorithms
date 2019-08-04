package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumToAllLeaves {

    public static List<ArrayList<Integer>> pathSum(TreeNode<Integer> node, int sum){
        if(node==null) return null;
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(node.value);
        dfs(node, sum-node.value, arrayList, result);
        return result;
    }


    public static void dfs(TreeNode<Integer> node, int sum, ArrayList<Integer> array, List<ArrayList<Integer>> result) {
        if(node==null) return;
        if(isLeafNode(node) && sum==0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(array);
            result.add(temp);
        }

        if(node.left!=null) {
            array.add((Integer) node.left.value);
            dfs(node.left, sum-(Integer)node.left.value, array, result);
            array.remove(array.size()-1);
        }

        if(node.right!=null) {
            array.add((Integer) node.right.value);
            dfs(node.right, sum-(Integer)node.right.value, array, result);
            array.remove(array.size()-1);
        }
    }

    private static boolean isLeafNode(TreeNode node){
        return node.left==null && node.right==null;
    }
}
