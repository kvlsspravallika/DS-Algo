package com.company.linkedlist;

/*
Problem Statement: Given two singly linked lists that are sorted in increasing order of node values,
merge two sorted linked lists and return them as a sorted list. The list should be made by splicing
together the nodes of the first two lists.

Input Format :
l1 = {3,7,10}, l2 = {1,2,5,8,10}

Output :
{1,2,3,5,7,8,10,10}
 */
public class MergeSortedLL {
    public static void main(String[] args) {

    }

    /*
    TC - O(N+M)
    SC- O(1)
     */
    private static ListNode mergeLists(ListNode list1, ListNode list2){

        if(list1==null && list2==null){
            return list1;
        }
        if(list1==null && list2!=null){
            return list2;
        }
        if(list1!=null && list2==null){
            return list1;
        }
        ListNode head1=list1, head2=list2;
        ListNode mergedHead;

        if(list1.val<list2.val){
            mergedHead = head1;
            head1=head1.next;
        }else{
            mergedHead = head2;
            head2= head2.next;
        }

        ListNode mergedTail = mergedHead;

        while(head1!=null && head2!=null){
            ListNode temp=null;
            if(head1.val< head2.val){
                temp=head1;
                head1=head1.next;
            }else{
                temp=head2;
                head2=head2.next;
            }
            mergedTail.next=temp;
            mergedTail=temp;
        }
        if(head1!=null){
            mergedTail.next=head1;
        }
        if(head2!=null){
            mergedTail.next = head2;
        }
        return mergedHead;

    }
}
