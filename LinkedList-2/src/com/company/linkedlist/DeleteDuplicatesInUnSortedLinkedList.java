package com.company.linkedlist;

/*
Write a removeDuplicates() function that takes a list and deletes any duplicate nodes from the list.
The list is not sorted.
 For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the
 list to 12->11->21->41->43.
 */
public class DeleteDuplicatesInUnSortedLinkedList {
    public static void main(String[] args) {

    }

    /*
    Approach -1 : we can use two pointers and achieve this in O(n^2)
    Approach - 2: we can sort the linked list first using merge sort and simply
    delete duplicates nodes from that sorted list, from this TC will be O(nlog n) for merging
    and O(n) for deleting duplicate nodes from sorted lists
     */

    private static ListNode removeDuplicates(ListNode head){
        ListNode sortedList = mergeSort(head);
        ListNode curr = sortedList;
        while(curr!=null){
            ListNode temp=curr;
            while(temp!=null && temp.val == curr.val){
                temp=temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return sortedList;
    }


    private static ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = mergeSort(middle);
        ListNode right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        ListNode result = null;
        if(left.val <= right.val){
            result = left;
            result.next = merge(left.next, right);
        }else{
            result=right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode fp=head, sp=head;
        while(fp.next!=null && fp.next.next!=null){
            sp=sp.next;
            fp=fp.next.next;
        }
        return sp;
    }
}
