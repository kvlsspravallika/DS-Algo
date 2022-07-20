package com.company.trees;

/*
Given a binary tree and an array, the task is to find if the given array sequence is present as a root to
leaf path in given tree.
 */
public class RootToLeafPathEqualsGivenSequence {
    public static void main(String[] args) {

    }

    private static boolean checkIfRootToLeafPathSumEqualsGivenSequence(TreeNode root, int n, int[] arr){
        if(root==null){
            return false;
        }
        return checkPathUtil(root, n, arr, 0);
    }

    private static boolean checkPathUtil(TreeNode root, int n, int[] arr, int index) {

        if(root==null && index==n){
            return false;
        }

        if(root.left==null && root.right==null){
            if(root.data == arr[index] && index==n-1){
                return true;
            }
            return false;
        }

        return (index<n && root.data==arr[index] && checkPathUtil(root.left, n, arr, index+1)
                || checkPathUtil(root.right, n, arr, index+1));
    }
}
