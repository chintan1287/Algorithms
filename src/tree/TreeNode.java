package tree;

public class TreeNode<Value extends Comparable> {
    public Value value;
    public TreeNode left, right;

    public TreeNode(Value value) {
        this.value = value;
    }
}
