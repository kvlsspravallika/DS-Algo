package com.company.recursion;

/*
Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

        Note: The solution set must not contain duplicate combinations.

        Example 1:

        Input: candidates = [10,1,2,7,6,1,5], target = 8

        Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]]


        Explanation: These are the unique combinations whose sum is equal to target.

        Example 2:

        Input: candidates = [2,5,2,1,2], target = 5

        Output: [[1,2,2],[5]]

        Explanation: These are the unique combinations whose sum is equal to target.

 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(getsubsets(new int[]{10,1,2,7,6,1,5},8));
        System.out.println(getsubsets(new int[]{2,5,2,1,2},5));
    }

    private static List<List<Integer>> getsubsets(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        // sort the array as we check for duplicate condition in below recursion call
        Arrays.sort(arr);
        getUniqueSubsets(arr, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void getUniqueSubsets(int[] arr, int target, List<List<Integer>> result,
                                         List<Integer> list, int index){
           if(target==0){
               result.add(new ArrayList<>(list));
               return;
           }

       for(int i=index;i<arr.length;i++){
           // check to avoid duplicate elements
           if(i>index && arr[i]==arr[i-1]){
               continue;
           }
           if(arr[index]>target){
               break;
           }
           list.add(arr[i]);
           getUniqueSubsets(arr, target-arr[i], result, list, i+1);
           list.remove(list.size()-1);
       }
    }
}
