package com.company.Arrays1;

/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
        has the largest sum and return its sum and print the subarray.

        Example 1:

        Input: arr = [-2,1,-3,4,-1,2,1,-5,4]

        Output: 6

        Explanation: [4,-1,2,1] has the largest sum = 6.

        Examples 2:

        Input: arr = [1]

        Output: 1

        Explanation: Array has only one element and which is giving positive sum of 1.

 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSum(new int[]{1}));
    }


    private static int maxSum(int[] arr){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere =0;
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            maxEndingHere = maxEndingHere+arr[i];
            if(maxEndingHere>maxSoFar){
                maxSoFar=maxEndingHere;
                end=i;
            }

            if(maxEndingHere<0){
                maxEndingHere=0;
                start=i+1;
            }
        }
        return maxSoFar;
    }
}
/*
    Time Complexity: O(N)

        Space Complexity:O(1)

 */
