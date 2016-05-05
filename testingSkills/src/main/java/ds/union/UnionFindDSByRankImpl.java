package ds.union;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class UnionFindDSByRankImpl<T> extends UnionFindDS<T> {


    public Subset<T> union(Subset<T> subset1, Subset<T> subset2) {
        if(subset1.getRank() > subset2.getRank())
        {
            Node<T> rootSubset1 = (Node<T>)subset1.getRoot();
            Node<T> rootSubset2 = (Node<T>)subset2.getRoot();
            rootSubset2.setParent(rootSubset1);
            subset1.getNodes().addAll(subset2.getNodes());
            return subset1;
        }
        else
        {
            GenericNode<T> rootSubset1 = (GenericNode<T>)subset1.getRoot();
            GenericNode<T> rootSubset2 = (GenericNode<T>)subset2.getRoot();
//            rootSubset1.setParent(rootSubset2);
            subset2.getNodes().addAll(subset1.getNodes());
            return subset2;
        }
    }
}
