package com.company.greedy;

/*
Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the
denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000}
valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

Example 1:

Input: V = 70

Output: 2

Explaination: We need a 50 Rs note and a 20 Rs note.

Example 2:

Input: V = 121

Output: 3

Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
 */
public class MinCoins {

    public static void main(String[] args) {
        System.out.println(minCoins(70, new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}));
        System.out.println(minCoins(121, new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}));
    }


    private static int minCoins(int v, int[] coins){
        int sum=v;
        int minCoins=0;
        for(int i=coins.length-1;i>=0;i--){
            while(sum>=coins[i]){
                sum=sum-coins[i];
                minCoins++;
            }
        }
        return minCoins;
    }


}
