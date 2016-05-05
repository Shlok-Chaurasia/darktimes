import array.ArrayQuestions;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by shlok.chaurasia on 11/04/16.
 */

class Student implements Comparable{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        if(other.cgpa == this.cgpa)
        {
            return fname.compareTo(other.fname);
        }
        if(other.cgpa == this.cgpa)
            return 0;
        if(other.cgpa > this.cgpa)
            return 1;
        else
            return -1;
    }
}


public class DriverClass {

    public static void insertIntoSorted(int[] ar) {
        int lastNum = ar[ar.length-1] ;
        int index = ar.length-2;
        while(index >=0)
        {
            if(ar[index]>lastNum)
            {
                ar[index+1]=ar[index];
                index--;
            }
            else
            {
                break;
            }
        }
        ar[index+1] = lastNum;
    }

    private static int returnIndex(String str)
    {
        HashMap<Integer,Integer> c = new HashMap<>();
        int leftIndex = 0;
        int rightIndex = str.length()-1;
        while(leftIndex < rightIndex)
        {
            if(str.charAt(leftIndex)== str.charAt(rightIndex))
            {
                leftIndex++;
                rightIndex--;
            }
            else{
                if(isPalindrome(str, leftIndex))
                    return leftIndex;
                else if(isPalindrome(str, rightIndex))
                    return rightIndex;
                else
                    return -1;

            }
        }
        return -1;
    }
    private static boolean isPalindrome(String str, int indexToSkip)
    {

        int leftIndex = 0;
        int rightIndex = str.length()-1;
        while(leftIndex < rightIndex)
        {
            if(leftIndex == indexToSkip)
            {
                leftIndex++;
                continue;
            }

            if(rightIndex == indexToSkip)
            {
                rightIndex--;
                continue;
            }
            if(str.charAt(leftIndex)!= str.charAt(rightIndex))
                return false;
            else
            {
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }

    static void sortArrBetweenIndex(char arr[], int startIndex, int endIndex)
    {
        char arNew [] = new char[endIndex - startIndex + 1];

        for(int i = startIndex; i<=endIndex; i++)
        {arNew[i-startIndex] = arr[i];}
        insertionSortPart2(arNew);
        for(int i = startIndex; i<=endIndex; i++){
            arr[i] = arNew[i-startIndex] ;
        }
    }
    static void printArr(int ar[])
    {
        for(int r : ar)
            System.out.print(r + ",");
    }
    static void printArr(char ar[])
    {
        for(char r : ar)
            System.out.print(r + ",");
    }
    static int findRank(String str)

    {
        int index = str.length()-1;
        int rank =0;
        int power26 = 0;
        while(index >= 0)
        {
            int temp = ((int)str.charAt(index)-96);
            rank= rank + ((int)(Math.pow(26, power26))* temp);
            index--;
            power26++;
        }
        return rank;
    }

    static String convertBack(int rank)
    {
        String output = "";
        while(rank > 0)
        {
            output=(char)(rank%26 + 96) + output;
            rank = rank/26;
        }
        return output;
    }
    public static void insertionSortPart2(int[] ar)
    {
        int outerIndex = 1;
        while(outerIndex < ar.length)
        {
            int temp = ar[outerIndex];
            int innerIndex = outerIndex -1 ;
            while(innerIndex >=0 && ar[innerIndex]> ar[innerIndex+1])
            {
                ar[innerIndex+1] = ar[innerIndex];
                innerIndex--;
            }
            ar[innerIndex+1] = temp;
//            printArray(ar);
            outerIndex++ ;
        }
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
    }
    public static void findNext(char[] charArr)
    {
        int lastIndex = charArr.length-1;
        int innerIndex = -1;
        boolean flag = false;
        while(lastIndex >= 0)
        {
            innerIndex = lastIndex-1;
            while(innerIndex>=0 && charArr[innerIndex+1] <= charArr[innerIndex])
            {
            innerIndex--;
            }
            if(innerIndex >=0)
            {
                char temp = charArr[innerIndex+1];
                charArr[innerIndex+1] = charArr[innerIndex];
                charArr[innerIndex] = temp;
                sortArrBetweenIndex(charArr,innerIndex+1,charArr.length-1);
                flag=true;
                break;
            }
            lastIndex--;
        }
        if(!flag)
        {
            System.out.println("no answer");
        }
        else{
        System.out.println(String.valueOf(charArr));
        }
    }
    public static void insertionSortPart2(char[] ar)
    {
        int outerIndex = 1;
        while(outerIndex < ar.length)
        {
            char temp = ar[outerIndex];
            int innerIndex = outerIndex -1 ;
            while(innerIndex >=0 && ar[innerIndex]> temp)
            {
                ar[innerIndex+1] = ar[innerIndex];
                innerIndex--;
            }
            ar[innerIndex+1] = temp;
//            printArray(ar);
            outerIndex++ ;
        }
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
    }

    static TreeSet<String> tree = new TreeSet<String>();
    static String[] buildSubsequences(String s) {
        tree = new TreeSet<String>();
        for(int i= 1; i<= s.length(); i++)
        {
            returnList(i, 0, "", s);
        }
        String output[] = new String[tree.size()];
        int count = 0;
        for(String out: tree )
        {
            output[count] = out;
            count++;
        }
        return output;
    }

    private static void returnList(int length, int currIndex, String output, String input)
    {
        if(currIndex == length)
        {
            tree.add(output);
            System.out.println(output);
            return;
        }
        if(input.length() > 0)
        {
            returnList(length, currIndex+1,  output + input.charAt(0), input.substring(1));
            returnList(length, currIndex,  output , input.substring(1));
        }
    }

    public static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
//        Queue<Student> priorityQueue = new PriorityQueue<>(11);
//        priorityQueue.add(new Student(1,"aish",13.1));
//        priorityQueue.add(new Student(2,"sish",13.1));
//        priorityQueue.add(new Student(3,"aais",14));
//        System.out.println(priorityQueue.remove().getFname());
//        System.out.println(priorityQueue.remove().getFname());
//        System.out.println(priorityQueue.remove().getFname());
//        System.out.println(priorityQueue.size());

        buildSubsequences("ba");
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.peek());

//        BigInteger big = new BigInteger(13);
//        System.out.print(big.isProbablePrime(13));
//        Scanner sc = new Scanner(System.in);
//        int num = Integer.parseInt(sc.nextLine());
//        int index = 0;
//        while(index < num)
//        {
//            String input = sc.nextLine();
//            findNext(input.toCharArray());
//            index++;
//        }
        //dmsym => input
        //dmyms => output
        //mdmsy - my answer

////        System.out.println(returnIndex("aaab"));
////        char[] r = {'q', 'd', 'a', 'c', 'b', 'l','k'};
//        char[] r = {'q', 'd', 'a', 'c', 'b', 'l','k'};
////        sortArrBetweenIndex(r, 1, 4);
//        findNext("dkhc".toCharArray());
////        System.out.println(findRank("abc"));
////        System.out.println(convertBack(findRank("abcd")));

    }
}
