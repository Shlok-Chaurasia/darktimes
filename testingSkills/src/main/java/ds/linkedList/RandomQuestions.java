package ds.linkedList;

import sun.awt.image.ImageWatched;

/**
 * Created by shlok.chaurasia on 22/02/16.
 */
public class RandomQuestions {

    public LinkedListNode<Integer> mergeSortList(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> a = head;
        LinkedListNode<Integer> b = getOtherHalfNode(head);
        mergeSortList(a);
        mergeSortList(b);
        return sortedList(a,b);
    }
    private LinkedListNode<Integer> sortedList(LinkedListNode<Integer>a, LinkedListNode<Integer> b)
    {
        LinkedListNode<Integer> result =null;
        if(a==null)
            return b;
        if(b== null)
            return a;
        if(a.getData()>b.getData())
        {
            result = b;
            LinkedListNode<Integer> temp = sortedList(a, b.getNext());
//            result.setNext(temp);
        }

        return result;
    }
    private LinkedListNode<Integer> getOtherHalfNode(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while(fast!=null)
        {
            slow = slow.getNext();
            fast = fast.getNext();
            if(fast==null)
                break;
            fast=fast.getNext();
        }
        return slow;
    }


    public LinkedListImpl<Integer> createListWithArray(int arr[])
    {
        LinkedListImpl<Integer> temp = new LinkedListImpl<Integer>();
        temp.data=arr[0];
        LinkedListImpl<Integer> head = temp;
        for (int i = 1 ;i<arr.length;i++)
        {
            LinkedListImpl<Integer> temp1 = new LinkedListImpl<Integer>();
            temp1.data=arr[i];
            temp.nextNode=temp1;
            temp = temp1;
        }
        return head;
    }
    static LinkedListImpl<Integer> asc;
    static LinkedListImpl<Integer> desc;

    public void splitAscDesc(LinkedListImpl<Integer> head)
    {
        LinkedListImpl<Integer> curr=head;
        LinkedListImpl<Integer> tempAsc = head;
        LinkedListImpl<Integer> tempDesc = head.nextNode;
        int i =0;
        asc=tempAsc;
        desc = tempDesc;
        while(curr!=null)
        {
            if(i%2 ==0)
            {
                tempAsc.nextNode=curr.nextNode.nextNode;
                tempAsc=tempAsc.nextNode;
            }
            else
            {
                tempDesc.nextNode=curr.nextNode.nextNode;
                tempDesc=tempDesc.nextNode;
            }
            i++;
            curr=curr.nextNode;
        }
        printLinkedList(asc);
        printLinkedList(desc);
    }

    public LinkedListImpl<Integer> returnMiddle(LinkedListImpl<Integer> head)
    {
        LinkedListImpl<Integer> slow = head;
        LinkedListImpl<Integer> fast = head.nextNode;
//        while(fast!=null && fast.nextNode!=null)
//        {
//            if(fast.nextNode.nextNode==null)
//                break;
//            slow= slow.nextNode;
//            fast=fast.nextNode.nextNode;
//        }
        while(fast!=null && fast.nextNode!=null)
        {
            slow= slow.nextNode;
            fast=fast.nextNode.nextNode;
        }
        return slow;
    }
    public LinkedListImpl<Integer> randomList(int n)
    {
        LinkedListImpl<Integer> temp = new LinkedListImpl<Integer>();
        temp.data=1;
        LinkedListImpl<Integer> head = temp;
        for (int i = 2 ; i< n;i++)
        {
            LinkedListImpl<Integer> temp1 = new LinkedListImpl<Integer>();
            temp1.data=i;
            temp.nextNode=temp1;
            temp = temp1;
        }
        return head;
    }
    public LinkedListImpl<Integer> reverseList(LinkedListImpl<Integer> head)
    {
        LinkedListImpl<Integer> prev = null;
        LinkedListImpl<Integer> current = head;
        while(current!=null)
        {
            LinkedListImpl<Integer> temp = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current=temp;
        }
        return prev;
    }

    public LinkedListImpl<Integer> mergeLinkedList(LinkedListImpl<Integer> head1, LinkedListImpl<Integer> head2)
    {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        LinkedListImpl<Integer> temp;
        if(head1.data>head2.data)
        {
            temp = head2;
            head2.nextNode = mergeLinkedList(head1, head2.nextNode);
        }
        else
        {
            temp = head1;
            head1.nextNode = mergeLinkedList(head1.nextNode, head2);
        }
        return temp;
    }

    public void printLinkedList(LinkedListImpl<Integer> head)
    {
        LinkedListImpl<Integer> temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data +" => ");
            temp=temp.nextNode;
        }
        System.out.println("");
    }

    public LinkedListImpl<Integer> reverseKNodes(int k, LinkedListImpl<Integer> head)
    {
        if(head==null)
            return null;
        LinkedListImpl<Integer> curr = null;
        LinkedListImpl<Integer> next = head;
        int i =0;
        while(i<k && next!=null)
        {
            LinkedListImpl<Integer> temp = next.nextNode;
            next.nextNode=curr;
            curr=next;
            next=temp;
            i++;
        }
        head.nextNode = reverseKNodes(k, next);
        return curr;

    }
    public static LinkedListImpl<Integer> leftSide = null;
    public boolean isPalindrome(LinkedListImpl<Integer> head)
    {
        if(head==null)
            return true;
        boolean x = isPalindrome(head.nextNode);
        if(head.data==leftSide.data)
        {
            leftSide=leftSide.nextNode;
            return x;
        }
        else
            return false;
    }

    public LinkedListImpl<Integer> removeDuplicate(LinkedListImpl<Integer> head)
    {
        LinkedListImpl<Integer> prev = head;
        LinkedListImpl<Integer> cur = head.nextNode;
        while(cur!=null)
        {
            if(cur.data== prev.data)
            {
                LinkedListImpl<Integer> temp =cur.nextNode;
                prev.nextNode=cur.nextNode;
                cur=temp;
            }
            else
            {
                prev = cur;
                cur=cur.nextNode;
            }
        }

        return head;
    }
}
