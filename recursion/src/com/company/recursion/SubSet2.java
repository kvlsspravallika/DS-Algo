package com.company.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets.
 Return only unique subsets and they can be in any order.

        Example 1:

        Input: array[] = [1,2,2]

        Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]

        Explanation: We can have subsets ranging from  length 0 to 3.
        which are listed above. Also the subset [1,2] appears twice but is printed only once as we
        require only unique subsets.

        Input: array[] = [1]

        Output: [ [ ], [1] ]

        Explanation: Only two unique subsets are available

 */
public class SubSet2 {

    public static void main(String[] args) {
        System.out.println(getUniqueSubsets(new int[]{1,2,2}));
        System.out.println(getUniqueSubsets(new int[]{1}));
    }

    private static List<List<Integer>> getUniqueSubsets(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        // sorting given input for duplicate check in recursive method
        Arrays.sort(arr);
        returnUniqueSubsets(0, arr, new ArrayList<>(), result);
        return result;
    }

    private static void returnUniqueSubsets(int index, int[] arr, List<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        // looping from index to length of array
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            // as array is sorted, elements are picked like wise and avoid duplicate elements bcoz of above for loop
            returnUniqueSubsets(i+1, arr, list, result);
            list.remove(list.size()-1);
        }
    }

    /*
    Time Complexity: O(2^n) for generating every subset and O(k)  to insert every subset in another data structure if the average length of every subset is k. Overall O(k * 2^n).

    Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.

     */
}
