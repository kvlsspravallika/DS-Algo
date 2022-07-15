package com.company.linkedlist;

/*
Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
Input Format:
( Pointer / Access to the head of a Linked list )
head = [1,2,3,4,5]

Result: [3,4,5]
( As we will return the middle of Linked list the further linked list will be still available )

Explanation: The middle node of the list is node 3 as in the below image.

 */
public class MiddleOfLL {

    public static void main(String[] args) {

    }

    /*
    TC - O(n)
    SC - O(1)
     */
    private static ListNode findMiddle(ListNode head){
        ListNode sp=head, fp=head;
        while (fp.next!=null && fp.next.next!=null){
            sp=sp.next;
            fp=fp.next.next;
        }
        if(fp.next==null){
            return sp;
        }else{
            return sp.next;
        }
    }
}
