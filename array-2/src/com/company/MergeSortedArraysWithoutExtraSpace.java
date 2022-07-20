package com.company;

/*
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted
order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last
M elements.


Example 1:

Input:
n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:

Input:
n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]

Output:
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:
After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
 */
public class MergeSortedArraysWithoutExtraSpace {

    /*
    Intuition: We can think of Iterating in arr1 and whenever we encounter an element that is greater than the first element of arr2,
    just swap it. Now rearrange the arr2 in a sorted manner, after completion of the loop we will get
    elements of both the arrays in non-decreasing order.
     */
    public static void main(String[] args) {

    }
}

/*
Time complexity: O(n*log(n))+O(n)+O(n)

Space Complexity: O(n)
 */
