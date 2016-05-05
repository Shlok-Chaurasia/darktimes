package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class BinaryTreeDs<T> {
    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    private TreeNode<T> root;
    private Map<Integer, List<T>> map;
    public BinaryTreeDs(T x) {
        this.root = new TreeNode<T>(x);
        map= new HashMap<Integer, List<T>>();
    }

    private void doLevelOrder(int level, TreeNode<T> root)
    {
        if(!map.containsKey(level))
        {
            map.put(level, new ArrayList<T>());
        }

        if(root==null)
        {
            map.get(level).add(null);
            return;
        }
        map.get(level).add(root.getData());
        doLevelOrder(level+1, root.getLeft());
        doLevelOrder(level+1, root.getRight());
    }
    public void printTree()
    {
        doLevelOrder(1, this.root);
        for(Integer level: map.keySet())
        {
            System.out.println(map.get(level).toString());
        }
    }
}
