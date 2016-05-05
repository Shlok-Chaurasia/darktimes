package array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shlok.chaurasia on 28/02/16.
 */
public class ArrayQuestions {

    public void mergeSortedArray(int[] arr1, int[] arr2)
    {
        int pointer1 = 0;
        int pointer2 = 0;
        int smallArr[];
        int largeArr[];
        if(arr1.length > arr2.length)
        {
            smallArr = arr2;
            largeArr = arr1;
        }
        else
        {
            smallArr=arr1;
            largeArr=arr2;
        }
        int newArr[]=new int[arr1.length+arr2.length];
        int index =0;
        while(pointer1 < smallArr.length && pointer2 < largeArr.length)
        {
            if(smallArr[pointer1] >= largeArr[pointer2])
            {
                newArr[index] = largeArr[pointer2];
                pointer2++;
            }
            else
            {
                newArr[index] = smallArr[pointer1];
                pointer1++;
            }
            index++;
        }

        if(pointer1 == smallArr.length)
        {
            while(pointer2!=largeArr.length)
            {
                newArr[index] = largeArr[pointer2];
                pointer2++;
                index++;
            }
        }

        if(pointer2 == largeArr.length)
        {
            while(pointer1!=smallArr.length)
            {
                newArr[index] = smallArr[pointer1];
                pointer1++;
                index++;
            }
        }
        printArr(newArr);
    }


    public void LIS(int[]arr)
    {
        int outputArr[] = new int[arr.length];
        outputArr[0] = 1;
        for(int i = 0;i<outputArr.length;i++)
            outputArr[i] = 1;
        for(int i =1; i < arr.length;i++)
        {
            int max = 1;
            for(int j = 0; j <i;j++)
            {
                if(arr[i] > arr[j] && max < outputArr[j] + 1)
                    max = outputArr[j]+1;
            }
            outputArr[i] = max;
        }
        printArr(outputArr);
    }

    public void maxTriangles(int []arr)
    {
        Arrays.sort(arr);
        int count =0;
        for(int i = 0 ; i< arr.length-2; i++)
        {
            int k = i+2;
            for(int j = i+1; j< arr.length-1;j++)
            {
                while(k< arr.length && arr[i]+arr[j] > arr[k])
                    k++;
                count = count + k-1-j;
            }
        }

    }

    public void maxSubarraySum(int arr[])
    {
        int maxSum = 0;
        int maxStart =0;
        int maxSumCurr = 0;
        for(int i =0; i < arr.length;i++)
        {
            maxSumCurr = maxSumCurr + arr[i];
            if(maxSumCurr > maxSum)
                maxSum = maxSumCurr;
            if(maxSumCurr < 0)
            {
                maxSumCurr = 0 ;
                maxStart = i;
            }

        }

        System.out.println(maxStart + " , " + maxSum);
    }
    public void quickSort(int [] arr, int low, int high)
    { if(low < high) {
        int partition = partitionArray(low, high, arr);

            quickSort(arr, low, partition - 1);

            quickSort(arr, partition + 1, high);
        }
    }
    public int binarySearch(int elementToSearch, int arr[], int low, int high)
    {
        if(high > low)
        {
            int mid = low+((high-low)/2);
            if(arr[mid] == elementToSearch)
                return mid;
            if(arr[mid]> elementToSearch)
            {
                return binarySearch(elementToSearch,arr,low, mid-1);
            }
            else {
                return binarySearch(elementToSearch,arr,mid+1,high);
            }
        }
        return -1;
    }
    private int partitionArray(int low, int high, int[] arr)
    {
        int pivot = arr[high];
        int leftMark = low;
        int rightMark = high -1;
        while(leftMark <  rightMark)
        {
            if(arr[leftMark] <= pivot)
                leftMark++;
            else
            {
                swap(leftMark,rightMark,arr);
                rightMark--;
            }
        }
        if(arr[leftMark] < pivot)
            leftMark++;
        swap(leftMark,high,arr);
        return leftMark;
    }

    public void mergeTwoHalves(int arr[], int l, int m, int r)
    {
        int arrNew []= new int[r-l+1];
        int leftArr = l;
        int rightArr = m+1;
        int index = 0;
        while(index < r-l+1)
        {
            if(leftArr <= m && rightArr <=r)
            {
                if(arr[leftArr] < arr[rightArr])
                {
                    arrNew[index] = arr[leftArr];
                    leftArr++;
                }
                else
                {
                    arrNew[index] = arr[rightArr];
                    rightArr++;
                }
            }
            else
            {
                break;
            }
            index++;
        }
        if(leftArr==m)
        {
            while(index < r-l+1)
            {
                arrNew[index] = arr[rightArr];
                rightArr++;
                index++;
            }
        }
        else
        {
            while(index < r-l+1)
            {
                arrNew[index] = arr[leftArr];
                leftArr++;
                index++;
            }
        }
        copyElements(arrNew, arr, l, r);
    }

    public void mergeSort(int l, int r, int arr[])
    {
        if(l<r)
        {
            int mid = (l+r)/2;
            mergeSort(l,mid, arr);
            mergeSort(mid+1,r, arr);
            mergeTwoHalves(arr, l,mid,r);
        }
    }

    public void countIncreasingSubArr(int arr[])
    {
        int maxSize = 0;
        int startIndex = 0;
        int endIndex = 1;
        while(endIndex<arr.length)
        {

            if(arr[endIndex] > arr[endIndex -1])
            {
                if(maxSize < (endIndex-startIndex)+1)
                    maxSize = (endIndex-startIndex)+1;
            }
            else
            {
                startIndex = endIndex;
            }
            endIndex++;
        }
        System.out.print(maxSize);
    }

    private void printSpiral(int arr[][], int n, int m)
    {
        int index =0;
        int i=0;
        int j=0;
        while(i < n-index && j < m-index)
        {
            for(int p = index; p <= m-index; p++)
            {
                System.out.print(arr[index][p]);
            }
            i++;
            for(int q = index+i; q<=n-index;q++)
            {
                System.out.print(arr[q][m-index]);
            }
            j++;
            for(int r = m-i-1 ; r>=i; r++)
                System.out.print(arr[n-index][r]);

            for(int s = n-index; s>=j; s++)
                System.out.print(arr[s][m-index-j]);

            index++;
        }
    }


    private void copyElements(int arr[], int arrTo[], int l, int m)
    {
        int index =0;
        for(int i=l;i<=m;i++)
        {
            arrTo[i]= arr[index++];
        }
    }
    private void swap(int i, int j, int[]arr)
    {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void printArr(int arr[])
    {
        for(int num:arr)
            System.out.print(num +" , ");
    }
}
