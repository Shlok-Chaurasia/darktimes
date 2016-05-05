import ds.graph.UndirectedGraph;
import ds.graph.UndirectedVertex;
import ds.linkedList.DLL;
import ds.linkedList.DLLImpl;
import ds.linkedList.LinkedListImpl;
import ds.linkedList.RandomQuestions;
import ds.lru.LRUCacheImpl;
import ds.lru.LRUWithLinkedListImpl;
import ds.tree.BinaryTreeDs;
import ds.tree.TreeNode;
import ds.tree.TreeQuestions;
import thread.Answer;
import thread.Chat;
import thread.Question;

import java.util.*;

/**
 * Created by shlok.chaurasia on 27/01/16.
 */
public class ArrayT {





    public static void dutchNationalFlag(int arr[]) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid < high) {
            if (arr[mid] == 0) {
                int swap = arr[low];
                arr[low] = 0;
                arr[mid] = swap;
                low++;
                mid++;
            }

            if (arr[mid] == 1) {
                mid++;
            }

            if (arr[mid] == 2) {
                int swap = arr[high];
                arr[high] = 2;
                arr[mid] = swap;
                high--;
            }
            System.out.println("low: " + low + ", mid: " + mid + ", high:" + high);
            displayArr(arr);
        }
        displayArr(arr);
    }

    public static int LIS(final int arr[], int n) {
        int[] LIS = new int[n];
        LIS[0] = 1;
        HashMap<Integer, List<Integer>> intInLIS = new HashMap<Integer, List<Integer>>();
        for (int index = 1; index < n; index++) {
            int LISCountAtIndex = 0;
            for (int subIndex = 0; subIndex < index; subIndex++) {
                if (arr[index] > arr[subIndex] && LISCountAtIndex < LIS[subIndex] + 1) {
                    LISCountAtIndex = LIS[subIndex] + 1;
                }
            }
            if (LIS[index - 1] < LISCountAtIndex || LIS[index - 1] == 1) {
                if (!intInLIS.containsKey(index - 1))
                    intInLIS.put(index - 1, new ArrayList<Integer>());
                intInLIS.get(index - 1).add(arr[index]);
            }
            LIS[index] = Math.max(LIS[index - 1], LISCountAtIndex);
        }
        System.out.println(intInLIS.toString());
        return LIS[n - 1];
    }

    public static int editDist(String str1, String str2) {
        int editDist[][] = new int[str1.length() + 1][str2.length() + 1];


        for (int str1Index = 0; str1Index <= str1.length(); str1Index++) {
            for (int str2Index = 0; str2Index <= str2.length(); str2Index++) {
                if (str1Index == 0) {
                    editDist[str1Index][str2Index] = str2Index;
                    continue;
                }
                if (str2Index == 0) {
                    editDist[str1Index][str2Index] = str1Index;
                    continue;
                }

                if (str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1)) {
                    editDist[str1Index][str2Index] = editDist[str1Index - 1][str2Index - 1];
                } else {
                    int delete = 1 + editDist[str1Index - 1][str2Index];
                    int replace = 1 + editDist[str1Index - 1][str2Index - 1];
                    int insert = 1 + editDist[str1Index][str2Index - 1];
                    editDist[str1Index][str2Index] = Math.min(Math.min(delete, replace), insert);
                }
            }
        }
        return editDist[str1.length()][str2.length()];
    }

    public static void displayArr(int arr[]) {
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println("");
    }

    public static UndirectedGraph<Integer, Integer> createGraph() {
        UndirectedGraph<Integer, Integer> graph = new UndirectedGraph<Integer, Integer>();
        for (int i = 1; i < 3; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(new UndirectedVertex<Integer>(1), new UndirectedVertex<Integer>(2), 1);
        graph.addEdge(new UndirectedVertex<Integer>(2), new UndirectedVertex<Integer>(3), 1);
        graph.addEdge(new UndirectedVertex<Integer>(3), new UndirectedVertex<Integer>(1), 1);
        return graph;
    }

    public static void mergeO1(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[0])
                arr1[i] = insertElementToRight(arr2, 0, arr1[i]);
        }
    }

    private static int insertElementToRight(int[] arr, int startPosition, int numberToInsert) {
        int elementDisappering = arr[startPosition];
        while (startPosition + 1 < arr.length && arr[startPosition + 1] < numberToInsert) {
            arr[startPosition] = arr[startPosition + 1];
            startPosition++;
        }
        arr[startPosition] = numberToInsert;
        return elementDisappering;
    }

    public static void numOfZeros(int arr[], int m) {
        int Wl = 0;
        int Wr = 0;
        int zeroCount = 0;
        int bestL = 0;
        int maxLen = 0;
        while (Wr < arr.length) {
            if (arr[Wr] == 1) {
                Wr++;
                if (maxLen < Wr - Wl) {
                    maxLen = Wr - Wl;
                    bestL = Wl;
                }
                continue;
            }

            if (arr[Wr] == 0) {
                if (zeroCount < m) {
                    Wr++;
                    zeroCount++;
                    if (maxLen < Wr - Wl) {
                        maxLen = Wr - Wl;
                        bestL = Wl;
                    }
                } else {
                    while (arr[Wl] != 0) Wl++;
                    Wl++;
                    zeroCount--;
                }
            }
        }
        System.out.println(bestL);
        System.out.println(maxLen);
    }

    public static void lruCache() {
        LRUWithLinkedListImpl<Integer> lruCache = new LRUWithLinkedListImpl<Integer>(4);
        lruCache.getData(1);
        lruCache.getData(2);
        lruCache.getData(3);
//        lruCache.getData(4);
//        lruCache.printCache();
        lruCache.getData(1);
//        lruCache.printCache();
        lruCache.getData(4);
//        lruCache.printCache();
        lruCache.getData(5);
//        lruCache.getData(2);
        lruCache.printCache();
//        lruCache.getData(2);
//        lruCache.printCache();
//        lruCache.getData(6);
//        lruCache.printCache();

    }

    private static void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            int curr = stack.peek();
            if (curr < next) {
                while (!stack.empty() && stack.peek() < next) {
                    System.out.println(stack.pop() + " ===> " + next);
                }
            }
            stack.push(next);
        }
        while (!(stack.empty())) {
            System.out.println(stack.pop() + " ===> " + -1);
        }

    }

    private static void histogram(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int max_area = -1;
        while (i < arr.length) {
            if (stack.empty() || arr[i] >= arr[stack.peek()]) {
                stack.push(i++);
            } else {
                int tp = stack.peek();  // store the top index
                stack.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                int area_with_top = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (stack.empty() == false) {
            int tp = stack.peek();
            stack.pop();
            int area_with_top = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        System.out.print(max_area);
    }

    public static List<String> operators = new ArrayList<String>() {{
        add("+");
        add("/");
        add("-");
        add("*");
    }};

    private static void convertFromPostToPreFix(String postFix) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < postFix.length(); i++) {
            String character = postFix.charAt(i) + "";
            if (operators.contains(character)) {
                String rightOperand = stack.pop();
                String leftOperand = stack.pop();
                stack.push(character + leftOperand + rightOperand);
            } else {
                stack.push(character);
            }
        }

        System.out.print(stack);
    }
    private static void convertFromPreToPostFix(String postFix) {
        Stack<String> stack = new Stack<String>();
        for (int i = postFix.length()-1; i > -1; i--) {
            String character = postFix.charAt(i) + "";
            if (operators.contains(character)) {
                String leftOperand = stack.pop();
                String rightOperand = stack.pop();
                stack.push(leftOperand + rightOperand + character );
            } else {
                stack.push(character);
            }
        }

        System.out.print(stack);
    }

    private static void convertFromPostToInFix(String postFix) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < postFix.length(); i++) {
            String character = postFix.charAt(i) + "";
            if (operators.contains(character)) {
                String rightOperand = stack.pop();
                String leftOperand = stack.pop();
                stack.push( "("+leftOperand + character +rightOperand+")");
            } else {
                stack.push(character);
            }
        }

        System.out.print(stack);
    }

    private static BinaryTreeDs<Integer> createTree()
    {
        BinaryTreeDs<Integer> binaryTreeDs = new BinaryTreeDs<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        node8.setLeft(binaryTreeDs.getRoot());
        node8.setRight(node9);
        binaryTreeDs.getRoot().setLeft(node2);
        binaryTreeDs.getRoot().setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        binaryTreeDs.setRoot(node8);
        return binaryTreeDs;
    }

    private static TreeNode<Integer> convertTreeToDLL(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode<Integer> prev = convertTreeToDLL(root.getLeft());
        TreeNode<Integer> next = convertTreeToDLL(root.getRight());
        if(prev!=null)
        {
            TreeNode<Integer> node = getEndNode(prev);
            root.prev=getEndNode(node);
            node.next=root;
        }

        if(next!=null)
        {
            next.prev=root;
            root.next = next;
        }

        if(prev!=null)
            return prev;
        return root;
    }

    private static void printPrevNext(TreeNode<Integer> root)
    {
        while(root.getLeft()!=null)
            root=root.getLeft();
        TreeNode<Integer> lastNode = root;
        while (root!=null) {
            System.out.print(root.getData() + " <=> ");
            if(root.next==null)
            {
                lastNode=root;
            }
            root=root.next;
        }
        System.out.println();
        while(lastNode!=null)
        {
            System.out.print(lastNode.getData() + " <=> ");
            lastNode=lastNode.prev;
        }

    }
    private  static TreeNode<Integer> getEndNode(TreeNode<Integer> root)
    {
        while(root.next!=null)
            root=root.next;
        return root;
    }
    public static void main(String s[]) {
        int ar1[] = {1, 5, 9, 10, 15, 20, -4, 4, 7, 6, 60, 30, 100};
        int ar2[] = {2, 3, 8, 13};
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int arr3[] = {13, 7, 6, 12};
        int arr4[] = {6, 2, 5, 4, 5, 2, 6, 2};
        int sortArr1[]= {5,6,19,30};
        int sortArr2[]= {2,4,8,11,29,40};
        int arr33 [] = {10,40,53,30,67,12,89,100};
        int paliArr[]= {1,2,3,4,5,6,6,6,6,6,6,4,3,2,1};
//        RandomQuestions randomQuestions= new RandomQuestions();
//        TreeQuestions treeQuestions= new TreeQuestions();
//        LinkedListImpl<Integer> head =randomQuestions.createListWithArray(arr33);
        chatThreadDemo();
//        randomQuestions.printLinkedList(head);
//        randomQuestions.splitAscDesc(head);
//        RandomQuestions.leftSide=head;
//        System.out.print(randomQuestions.isPalindrome(head));
//        randomQuestions.printLinkedList(randomQuestions.reverseKNodes(10, head));
//        System.out.print(randomQuestions.returnMiddle(head).data);

//        LinkedListImpl<Integer> head1 =randomQuestions.createListWithArray(sortArr1);
//        LinkedListImpl<Integer> head2 =randomQuestions.createListWithArray(sortArr2);
//
//        LinkedListImpl<Integer> merged = randomQuestions.mergeLinkedList(head1, head2);
//        randomQuestions.printLinkedList(merged);
//        randomQuestions.printLinkedList(head);
//        head = randomQuestions.reverseList(head);
//        randomQuestions.printLinkedList(head);

//        BinaryTreeDs<Integer> t = createTree();
//        t.printTree();
//        System.out.print(treeQuestions.isBST(t.getRoot()));
//        convertTreeToDLL(t.getRoot());
//        printPrevNext(t.getRoot());
//        convertFromPreToPostFix("+*AB/CD");
//        convertFromPreToPostFix("/*A+BCD");
//        convertFromPreToPostFix("*A+B/CD");
//        convertFromPostToInFix("ABCD/+*");
//        convertFromPostToInFix("ABC+*D/");
//        convertFromPostToInFix("AB*CD/+");
//        histogram(arr4);
//        printNGE(arr3);
//        numOfZeros(arr, 2);
//        MaxHeapDS maxHeapDS = new MaxHeapDS();
//        for(int intgr: ar1)
//        {
//            maxHeapDS.insert(intgr);
//        }
//        maxHeapDS.decreaseKey(100, -100);
//        for(int intgr: ar1)
//        {
//            System.out.println(maxHeapDS.getMax());
//        }

//        mergeO1(ar1,ar2);
//        displayArr(ar1);
//        displayArr(ar2);
//        System.out.print(createGraph().isCyclic());

//        int[] newInt = { 100, 22, 9, 33, 21, 50, 41, 60, 80 };
//        System.out.print(LIS(newInt, newInt.length));
//        System.out.println(editDist("sunday", "sunday"));
//        dutchNationalFlag(newInt);


//        DLLImpl<Integer> dll = new DLLImpl<Integer>();
//        for(int i : ar1)
//        {
//            dll.addToHead(i);
//        }
//        for(int i : ar2)
//        {
//            dll.addToTail(i);
//        }
//        dll.printDLL();
//
    }

    private static void chatThreadDemo()
    {
        Chat chat= new Chat();
        Question q = new Question(chat);
        Answer ans = new Answer(chat);
        Thread thread1= new Thread(q);
        Thread thread2= new Thread(ans);
        thread1.start();
        thread2.start();
    }
}
