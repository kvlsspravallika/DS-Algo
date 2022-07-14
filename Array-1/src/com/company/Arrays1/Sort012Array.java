package com.company.Arrays1;

/*
Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place
sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Input: nums = [0]
 */
public class Sort012Array {
    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        print(sort(arr));
        System.out.println();
        arr = new int[]{2,0,1};
        print(sort(arr));

    }

    private static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int[] sort(int[] arr){
        int low=0, mid=0, high=arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(low, mid, arr);
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(mid, high, arr);
                high--;
            }
        }
        return arr;
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
/*
    Time Complexity: O(N)

        Space Complexity: O(1)

 */
