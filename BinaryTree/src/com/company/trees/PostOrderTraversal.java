package com.company.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {

    }


    /*
    Using 1 stack
     */
    private static List<Integer> postOrderTraversalIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr!=null && !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp==null){
                    TreeNode node = stack.pop();
                    result.add(node.data);
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp=stack.pop();
                        result.add(temp.data);
                    }
                }else{
                    curr=temp;
                }
            }
        }
        return result;
    }
}
