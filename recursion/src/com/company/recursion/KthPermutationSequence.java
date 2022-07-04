package com.company.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: Given N and K, where N is the sequence of numbers from 1 to N([1,2,3….. N]) find the Kth permutation sequence.

        For N = 3  the 3!  Permutation sequences in order would look like this:-
   123, 132, 213,231,312,321

        Example 1:

        Input: N = 3, K = 3

        Output: “213”

        Explanation: The sequence has 3! permutations as illustrated in the figure above. K = 3 corresponds to the third sequence.

        Example 2:

        Input: N = 3, K = 5

        Result: “312”

        Explanation: The sequence has 3! permutations as illustrated in the figure above. K = 5 corresponds to the fifth sequence.
*/
public class KthPermutationSequence {
    public static void main(String[] args) {
        System.out.println(getKthPermutation(3,5));
        System.out.println(getKthPermutation(3,3));
    }

    private static String getKthPermutation(int n, int k){
        int fact=1;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        String result="";
        k=k-1; //since we are using 0 based indexing
        while(true){
            result = result+list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/list.size();
        }
        return result;
    }
}
