package ds.union;

import ds.common.GenericNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */

public class Subset<T> {
    Set<GenericNode<T>> nodes = new HashSet<GenericNode<T>>();
    int rank;
    GenericNode<T> root;

    public Subset(GenericNode<T> root) {
        this.root = root;
    }

    public GenericNode<T> getRoot() {
        return root;
    }

    public void setRoot(GenericNode<T> root) {
        this.root = root;
    }



    public int getRank() {
        return nodes.size();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Set<GenericNode<T>> getNodes() {
        return nodes;
    }

    public void setNodes(Set<GenericNode<T>> nodes) {
        this.nodes = nodes;
    }
}
