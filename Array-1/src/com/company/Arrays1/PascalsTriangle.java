package com.company.Arrays1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: Given an integer N, return the first N rows of Pascal’s triangle.

 */
public class PascalsTriangle {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> pascalsTriangle(int n){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> subList=new ArrayList<>();
            subList.add(1);
            for(int j=0;i!=0 && j<i-1;j++){
                subList.add(result.get(i-1).get(j) + result.get(i-1).get(j+1));
            }
            if(i!=0){
                subList.add(1);
            }
            result.add(subList);
        }
        return result;
    }
}
/*

    Time Complexity: We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows), and we are traversing through each of the cells to update it with its correct value, so Time Complexity = O(numRows2).

        Space Complexity: Since we are creating a 2D array, space complexity = O(numRows2).

 */
