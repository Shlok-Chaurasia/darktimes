package ds.union;

import ds.common.GenericNode;
import ds.common.NodeTypeEnum;
import ds.graph.Vertex;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */

public class Node<T> implements GenericNode<T> {
    T data;
    GenericNode<T> parent;
    NodeTypeEnum nodeTypeEnum;

    //move creation of parent to factory
    public Node(GenericNode<T> parent, NodeTypeEnum nodeTypeEnum) {
        if(nodeTypeEnum == NodeTypeEnum.VERTEX)
            this.parent = (Vertex<T>) parent;
    }


    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public GenericNode<T> getParent() {
        return parent;
    }

    public void setParent(GenericNode<T> parent) {
        if(nodeTypeEnum == NodeTypeEnum.VERTEX)
            this.parent = (Vertex<T>) parent;
    }
}
