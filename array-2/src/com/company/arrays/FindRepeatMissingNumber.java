package com.company.arrays;

/*
Problem Statement: You are given a read-only array of N integers with values also in the range [1, N]
both inclusive. Each integer appears exactly once except A which appears twice and B which is missing.
The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Input Format:  array[] = {3,1,2,5,3}

Result: {3,4)

Explanation: A = 3 , B = 4
Since 3 is appearing twice and 4 is missing

Input Format: array[] = {3,1,2,5,4,6,7,5}

Result: {5,8)

Explanation: A = 5 , B = 8
Since 5 is appearing twice and 8 is missing
 */
public class FindRepeatMissingNumber {

    public static void main(String[] args) {
        System.out.print(findMissingAndRepeatingNumber(new int[]{3,1,2,5,3})[0]+" "+findMissingAndRepeatingNumber(new int[]{3,1,2,5,3})[1]);
        System.out.println();
        System.out.print(findMissingAndRepeatingNumber(new int[]{3,1,2,5,4,6,7,5})[0]+" "+findMissingAndRepeatingNumber(new int[]{3,1,2,5,4,6,7,5})[1]);

    }

    private static int[] findMissingAndRepeatingNumber(int[] arr){
        int[] result = new int[2];
        int xor1=arr[0];

        for(int i=1;i<arr.length;i++){
            xor1 = xor1 ^ arr[i];
        }

        for(int i=1;i<=arr.length;i++){
            xor1 = xor1 ^ i;
        }

        int setBit = xor1 & ~(xor1 - 1);

        int x=0, y=0;
        for(int i=0;i<arr.length;i++){
            if((setBit & arr[i])!=0){
                x=x^arr[i];
            }else{
                y=y^arr[i];
            }
        }

        for(int i=1;i<= arr.length;i++){
            if((i&setBit)!=0){
                x=x^i;
            }else{
                y=y^i;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=x){
                result[0]=y;
                result[1]=x;
            }else{
                result[0]=x;
                result[1]=y;
            }
        }

        return result;
    }

    /*
    Time Complexity: O(N)

Space Complexity: O(1)
     */


}
