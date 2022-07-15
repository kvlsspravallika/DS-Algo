package com.company.greedy;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a
knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        System.out.println(fractionalKnapsackValue(3, new int[]{100,60,120}, new int[]{20,10,30}, 50));
    }

    private static double fractionalKnapsackValue(int n, int[] values, int[] weight, int W){
        double maxValue=0.0;
        List<Item> items = new ArrayList<>();
        for(int i=0;i<n;i++){
            items.add(new Item(values[i], weight[i]));
        }
        items.sort((item1, item2) -> {
            double r1 = (double)(item1.value) / (double)(item1.weight);
            double r2 = (double)(item2.value) / (double)(item2.weight);
            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        });
        int currentWeight=0;
        for(int i=0;i<n;i++){

            if(currentWeight+weight[i]<=W){
                currentWeight = currentWeight+weight[i];
                maxValue = maxValue+values[i];
            }else{
                int remaining = W-currentWeight;
                maxValue = maxValue + ((double)items.get(i).value/ (double)items.get(i).weight) * (double)remaining;
            }
        }


        return maxValue;
    }
}

/*
Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through all the items for calculating the answer.

Space Complexity: O(1), no additional data structure has been used.
 */

class Item{
    int value;
    int weight;

    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}
