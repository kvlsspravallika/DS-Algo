package com.company.recursion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:

        Given an array of distinct integers and a target, you have to return the list of all unique combinations
        where the chosen numbers sum to target. You may return the combinations in any order.

        The same number may be chosen from the given array an unlimited number of times.
        Two combinations are unique if the frequency of at least one of the chosen numbers is different.

        It is guaranteed that the number of unique combinations that sum up to target
        is less than 150 combinations for the given input.

        Example 1:

        Input: array = [2,3,6,7], target = 7

        Output: [[2,2,3],[7]]

        Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.


        Example 2:

        Input: array = [2], target = 1

        Output: []

        Explaination: No combination is possible.

 */
public class CombinationSum1 {
    public static void main(String[] args) {
        System.out.println(uniqueCombinations(new int[]{2,3,6,7}, 7));
        System.out.println(uniqueCombinations(new int[]{2}, 1));
    }

    private static List<List<Integer>> uniqueCombinations(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        getAllUniqueCombinations(0, arr, target, result, new ArrayList<>());
        return result;
    }

    private static void getAllUniqueCombinations(int index, int[] arr, int target, List<List<Integer>> result,
                                                 List<Integer> list){
        if(index>=arr.length){
            if(target==0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index]<=target){
            list.add(arr[index]);
            // pick condition
            getAllUniqueCombinations(index, arr, target-arr[index], result, list);
            list.remove(list.size()-1);
        }
        // not pick condition
        getAllUniqueCombinations(index+1, arr, target, result, list);

    }

    /*
    Time Complexity: O(2^t * k) where t is the target, k is the average length

    Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)

    Why not (2^n) but (2^t) (where n is the size of an array)?

    Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.

    Space Complexity: O(k*x), k is the average length and x is the no. of combinations

     */
}
