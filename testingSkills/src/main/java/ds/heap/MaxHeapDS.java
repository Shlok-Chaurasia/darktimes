package ds.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 17/02/16.
 */
public class MaxHeapDS {
    ArrayList<HeapNode> heapNodes;
    Map<Integer, Integer> valueToNode;

    public MaxHeapDS() {
        this.heapNodes = new ArrayList<HeapNode>();
        this.heapNodes.add(new HeapNode()); // dummy Node
        this.valueToNode = new HashMap<Integer, Integer>();
    }

    public int getMax() {
        int max = this.heapNodes.get(1).getData();
        swap(1, this.heapNodes.size()-1);
        this.heapNodes.remove(this.heapNodes.size()-1);
        if(this.heapNodes.size()>1)
            bubbleDown(1);
        return max;
    }

    public void insert(int data) {
        HeapNode heapNode = new HeapNode();
        heapNode.setData(data);
        this.heapNodes.add(heapNode);
        int newIndex = bubbleUp(heapNodes.size() - 1);
        this.valueToNode.put(data, newIndex);
    }

    public void delete(int data)
    {

    }
    public void decreaseKey(int oldData, int newData) {
        this.heapNodes.get(this.valueToNode.get(oldData)).setData(newData);
        int newIndex = bubbleDown(this.valueToNode.get(oldData));
        this.valueToNode.put(oldData, newIndex);
    }

    private int bubbleUp(int index) {
        if (index == 1)
            return index;
        HeapNode currentNode = this.heapNodes.get(index);
        HeapNode parent = this.heapNodes.get(index / 2);
        if (parent.compareTo(currentNode) > 0)
            return index;
        swap(index, index / 2);
        return bubbleUp(index / 2);
    }

    private int bubbleDown(int index) {
        int leftChildren = 2*index;
        int rightChildren = 2*index + 1;
        HeapNode parent = this.heapNodes.get(index);
        if(leftChildren > this.heapNodes.size() - 1)
            return index;
        HeapNode leftHeapNode = this.heapNodes.get(leftChildren);
        if (rightChildren > this.heapNodes.size() - 1)
        {
            if(leftHeapNode.compareTo(parent)>0)
            {
                swap(index,leftChildren);
                return bubbleDown(leftChildren);
            }
            return index;
        }
        HeapNode rightHeapNode = this.heapNodes.get(rightChildren);
        if(leftHeapNode.compareTo(rightHeapNode) > 0)
        {
            swap(index, leftChildren);
            return bubbleDown(leftChildren);
        }
        else
        {
            swap(index, rightChildren);
            return bubbleDown(rightChildren);
        }

    }

    private void swap(int index1, int index2) {
        HeapNode heapNode1 = this.heapNodes.get(index1);
        HeapNode heapNode2 = this.heapNodes.get(index2);
        this.heapNodes.set(index1, heapNode2);
        this.heapNodes.set(index2, heapNode1);
        this.valueToNode.put(heapNode2.getData(), index1);
        this.valueToNode.put(heapNode1.getData(), index2);
    }

}
