package ds.tree;

/**
 * Created by shlok.chaurasia on 03/03/16.
 */
public class TreeQuestions {
    public static TreeNode<Integer> prev = null;

    public boolean isBST(TreeNode<Integer> root) {
        if (root == null)
            return true;
        boolean left = isBST(root.getLeft());
        if(!left)
            return false;
        if (prev != null) {
            return prev.getData().intValue() <= root.getData().intValue();
        }
        prev = root;
        boolean right = isBST(root.getRight());
        return left && right;
    }
}
