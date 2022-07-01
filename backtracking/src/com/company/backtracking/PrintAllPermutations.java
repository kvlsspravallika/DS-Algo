package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Problem Statement: Given an array arr of distinct integers, print all permutations of String/Array.

        Example 1:

        Input: arr = [1, 2, 3]

        Output:
        [
        [1, 2, 3],
        [1, 3, 2],
        [2, 1, 3],
        [2, 3, 1],
        [3, 1, 2],
        [3, 2, 1]
        ]

        Explanation: Given an array, return all the possible permutations.

        Example 2:

        Input: arr = [0, 1]

        Output:
        [
        [0, 1],
        [1, 0]
        ]

        Explanation: Given an array, return all the possible permutations.

 */

public class PrintAllPermutations {
    public static void main(String[] args) {
        System.out.println(permute1(new int[]{1,2,3}));
        System.out.println(permute1(new int[]{0,1}));
        System.out.println(permute2(new int[]{1,2,3}));
        System.out.println(permute2(new int[]{0,1}));
    }

    private static List<List<Integer>> permute1(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] fre = new boolean[arr.length];
        permuteRecursion1(arr, fre, result, new ArrayList<>());
        return result;
    }


    /*
    Time Complexity:  N! x N

    Space Complexity:  O(N)

     */
    private static void permuteRecursion1(int[] arr, boolean[] fre, List<List<Integer>> result,
                                          List<Integer> list){
        if(list.size()==arr.length){
            result.add(new ArrayList<>(list));
        }
        for(int i=0;i<arr.length;i++){
            if(!fre[i]){
                fre[i]=true;
                list.add(arr[i]);
                permuteRecursion1(arr, fre, result, list);
                list.remove(list.size()-1);
                fre[i]=false;
            }
        }
    }

    private static List<List<Integer>> permute2(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        permuteRecursion2(arr, result, 0);
        return result;
    }

    /*
    Time Complexity: O(N! X N)

    Space Complexity: O(1)

     */
    private static void permuteRecursion2(int[] arr, List<List<Integer>> result, int index){
        if(index==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i:arr){
                list.add(i);
            }
            result.add(list);
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(index,i, arr);
            permuteRecursion2(arr, result,index+1);
            swap(index, i, arr);
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }




}
