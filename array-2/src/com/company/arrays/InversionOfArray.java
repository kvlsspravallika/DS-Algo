package com.company.arrays;

/*
Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to
find pair (A[i],A[j]) such that A[j] < A[i].

Input Format: N = 5, array[] = {1,2,3,4,5}

Result: 0

Explanation: we have a sorted array and the sorted array
has 0 inversions as for i < j you will never find a pair
such that A[j] < A[i]. More clear example: 2 has index 1
and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an
inversion.

Input Format: N = 5, array[] = {5,4,3,2,1}

Result: 10

Explanation: we have a reverse sorted array and we will
get the maximum inversions as for i < j we will always
find a pair such that A[j] < A[i].
Example: 5 has index 0 and 3 has index 2 now (5,3) pair
is inversion as 0 < 2 and 5 > 3 which will satisfy out
conditions and for reverse sorted array we will get
maximum inversions and that is (n)*(n-1) / 2.

For above given array there is 4 + 3 + 2 + 1 = 10 inversions.
 */
public class InversionOfArray {

    public static void main(String[] args) {
        System.out.println(countInversions(new int[]{5,4,3,2,1},5 ));
        System.out.println(countInversions(new int[]{1,2,3,4,5},5 ));
        System.out.println(countInversions(new int[]{5,3,2,1,4},5 ));
    }

    private static int countInversions(int[] arr, int n){
        return merge(arr, 0, n-1, n, new int[n]);
    }

    private static int merge(int[] arr, int start, int end, int n, int[] temp){
        int count=0;
        if(start<end){
            int mid = (start+end)/2;
            count+=merge(arr, start, mid, n, temp);
            count+=merge(arr, mid+1, end, n, temp);
            count+=mergeAndCount(arr, start, mid+1, end, n, temp);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int start, int mid,int end, int n, int[] temp){
        int inversionCount=0;
        int i=start;
        int j =mid;
        int k =start;
        while(i<=mid-1 && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
                inversionCount=inversionCount+(mid-i);
            }
        }

        while(i<=mid-1){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }

        for(i=start;i<=end;i++){
            arr[i]=temp[i];
        }
        return inversionCount;
    }
}

/*
TC - O(nlogn)
SC- O(n)
 */
