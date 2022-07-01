package com.company.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

        Input: N = 3, arr[] = {5,2,1}

        Output: 0,1,2,3,5,6,7,8

        Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are
        [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8


        Input: N=3,arr[]= {3,1,2}

        Output: 0,1,2,3,3,4,5,6

        Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are
        [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
*/
public class SubsetSums {

    public static void main(String[] args) {
        System.out.println(subsetsSum(3, new int[] {5,2,1}));
        System.out.println(subsetsSum(3, new int[] {3,1,2}));
    }

    private static List<Integer> subsetsSum(int n, int[] arr){
        List<Integer> result = new ArrayList<>();
        getSubSetsSum(n, arr, 0, 0, result);
        // sort result as expecting result in increasing order
        Collections.sort(result);
        return result;
    }

    private static void getSubSetsSum(int n, int[] arr, int index, int sum, List<Integer> result){
        if(index==n){
            result.add(sum);
            return;
        }
        // pick condition
        getSubSetsSum(n, arr, index+1, sum+arr[index], result);
        // dont pick condition
        getSubSetsSum(n, arr, index+1, sum, result);
    }

    /*
    Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it. So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

    Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.

     */
}
