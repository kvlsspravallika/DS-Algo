package com.company.linkedlist;

/*
Given a linked list, and a number N. Find the Nth node from the end of this linked list and delete it.
Return the head of the new modified linked list.

Input: head = [1,2,3,4,5], n = 2

Output: [1,2,3,5]

Input: head = [7,6,9,4,13,2,8], n = 6

Output: [7,9,4,13,2,8]

 */
public class RemoveNthNodeFromBackOfLL {
    public static void main(String[] args) {

    }

    private static ListNode removeNthNode(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode refPointer=dummy;
        ListNode mainPointer=dummy;
       for(int i=1;i<=n;i++){
           refPointer=refPointer.next;
       }
        while(refPointer.next!=null){
            mainPointer = mainPointer.next;
            refPointer = refPointer.next;
        }
        mainPointer.next = mainPointer.next.next;
        return dummy.next;
    }
}

/*
TC - O(n)
SC - O(1)
 */
