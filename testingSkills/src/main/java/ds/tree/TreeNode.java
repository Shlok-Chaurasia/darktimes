package ds.tree;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class TreeNode<T> implements GenericNode<T> {
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    private TreeNode<T> left;
    private TreeNode<T> right;
    public TreeNode<T> prev;
    public TreeNode<T> next;

    public T getData() {
        return data;
    }
}
