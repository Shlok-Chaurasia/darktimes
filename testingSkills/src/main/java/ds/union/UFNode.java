package ds.union;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 12/02/16.
 */
public interface UFNode<T> extends GenericNode<T>{
    GenericNode<T> getParent();
    void setParent(GenericNode<T> parent);
}
