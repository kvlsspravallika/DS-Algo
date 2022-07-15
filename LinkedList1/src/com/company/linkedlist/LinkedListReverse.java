package com.company.linkedlist;

/*
Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list,
and return the head pointer to the reversed list.
Input Format:
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.

Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10.
 */
public class LinkedListReverse {
    public static void main(String[] args) {

    }


    /*
    TC - O(n)
    SC - O(1)
     */
    private static ListNode reverse(ListNode head){
        ListNode current = head, prev=null, next=null;
        while(current!=null){
            current = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /*
   TC - O(n)
   SC - O(1)
    */
    private static ListNode reverseByRecursion(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
