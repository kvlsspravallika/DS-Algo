package com.company.greedy;

import java.util.Arrays;

/*
Problem Statement: We are given two arrays that represent the arrival and departure times of trains that
stop at the platform. We need to find the minimum number of platforms needed at the railway station so
that no train has to wait.

Input: N=6,
arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00}
dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}

Output:3

Input Format: N=2,
arr[]={10:20,12:00}
dep[]={10:50,12:30}

Output: 1
 */
public class MinimumPlatforms {

    public static void main(String[] args) {
        System.out.println(minimumPlatforms1(6, new int[]{900, 945, 955, 1100, 1500, 1800},
        new int[]{920, 1200, 1130, 1150, 1900, 2000}));
        System.out.println(minimumPlatforms2(6, new int[]{900, 945, 955, 1100, 1500, 1800},
                new int[]{920, 1200, 1130, 1150, 1900, 2000}));
    }

/*
Time Complexity: O(n^2)  (due to two nested loops).

Space Complexity: O(1)  (no extra space used).
 */
    private static int minimumPlatforms1(int n, int[] arr, int[] dept){
        int minPlatforms=1;
        for(int i=0;i<=arr.length-1;i++){
            int count=1;
            for(int j=i+1;j<=dept.length-1;j++){
                if((arr[i]>=arr[j] && arr[i]<=dept[j]) ||
                        (arr[j]>=arr[i] && arr[j]<=dept[i])){
                    count++;
                }
                minPlatforms = Math.max(minPlatforms, count);
            }
        }
        return minPlatforms;
    }

    /*
    Time Complexity: O(nlogn)   (Sorting takes O(nlogn) and traversal of arrays takes O(n) so
    overall time complexity is O(nlogn)).

Space complexity: O(1)   (No extra space used).
     */
    private static int minimumPlatforms2(int n, int[] arr, int[] dept){
        int minPlatforms = 1;
        int result=1;
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i=1, j=0;
        while(i<n && j<n){
            if(arr[i]<=dept[j]){
                minPlatforms++;
                i++;
            }
            else if(arr[i]>dept[j]){
                minPlatforms--;
                j++;
            }
            result = Math.max(minPlatforms, result);
        }
        return result;
    }
}
