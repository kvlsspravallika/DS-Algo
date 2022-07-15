package com.company.linkedlist;

/*
Problem Statement: Given the heads of two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two
numbers and return the sum as a linked list.

Input Format:
(Pointer/Access to the head of the two linked lists)

num1  = 342, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]

Result: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumsAsLL {

    public static void main(String[] args) {

    }

    private static ListNode addTwoLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode tail =result;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            ListNode temp = new ListNode((sum%10));
            carry = (sum/10)%10;
            tail.next = temp;
            tail=temp;

            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int sum = l1.val+carry;
            ListNode temp = new ListNode(sum%10);
            carry = (sum/10)%10;
            tail.next = temp;
            tail=temp;
            l1=l1.next;
        }

        while(l2!=null){
            int sum = l2.val+carry;
            ListNode temp = new ListNode(sum%10);
            carry = (sum/10)%10;
            tail.next = temp;
            tail=temp;
            l2=l2.next;
        }

        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return result.next;
    }
}

/*
TC- O(max(m, n))
SC - O(max(m, n))
 */
