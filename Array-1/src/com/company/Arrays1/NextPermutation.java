package com.company.Arrays1;

/*
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the
lexicographically next greater permutation of numbers.

        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
Input format: Arr[] = {1,3,2}

Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are
{{1,2,3} , {1,3,2}, {2,1,3} , {2,3,1} , {3,1,2} , {3,2,1}}.
So, the next permutation just after {1,3,2} is {2,1,3}.


Input format: Arr[] = {3,2,1}

Output: Arr[] = {1,2,3}

Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position.
 So, we have to return the topmost permutation.
 */
public class NextPermutation {
    public static void main(String[] args) {
        print(nextPermutation(new int[]{1,3,2}));
        System.out.println();
        print(nextPermutation(new int[]{3,2,1}));
        System.out.println();
        print(nextPermutation(new int[]{1,2,3}));
    }

    private static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int[] nextPermutation(int[] input){
        int n = input.length;

        int index=n-2;
        while(index>=0 && input[index]>=input[index+1]){
            index--;
        }
        if(index>=0){
            int j=n-1;
            while(j>=0){
                if(input[j]>input[index]){
                    break;
                }else {
                    j--;
                }
            }
            swap(index, j, input);
        }
        reverse(input, index+1, n-1);
        return input;
    }

    private static void swap(int i,int j, int[] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void reverse(int[] input, int start, int end){
        while(start<end){
            swap(start++, end--, input);
        }
    }
}

/*
    Time Complexity: For the first iteration backward, the second interaction backward and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(N).

        Space Complexity: Since no extra storage is required. Thus, its complexity is O(1)

 */
