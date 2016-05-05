package ds.union;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public abstract class UnionFindDS<T> {

    public Node<T> findParent(Node<T> childNode){
        if(childNode.getParent() == null)
        {
            return null;
        }
        return find(childNode);
    }
    abstract Subset<T> union(Subset<T> subset1, Subset<T> subset2);

    private Node<T> find(Node<T> childNode)
    {
        if(childNode.getParent()==null)
        {
            return (Node<T>)childNode.getParent();
        }
        return find((Node<T>)childNode.getParent());
    }

}
