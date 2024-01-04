package LL;

import java.nio.file.FileStore;
import java.util.List;

import javax.swing.text.Position;

/**
 * Definition for singly-linked list. */
class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}

public class RemoveNthNodefromListEnd {
    private int findlen(ListNode A){
        int c = 0;
        ListNode hc = A;
        while(hc != null){
            c++;
            hc = hc.next;
        }
        return c;
    }
    public ListNode removeNthFromEnd(ListNode A, int B){
        ListNode temp = A;
        int c = findlen(A); //size of LL
        if(c==1) return null;
        //check if B is >= c //check if B is greater than or equal to the size of the linkedlist,
        //then remove the first head node
        if(B>=c){
            A = A.next;
            return A;
        }
        //remove the B-th node from the end of the list and return its head.
        int position = c - B;
        ListNode temp = A;
        for(int i = 1, i < Position; i++){
            temp = temp.next;
        }
        //remove the node
        temp.next = temp.next.next;
        return A;
    }
}

/*Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.


Problem Constraints
1 <= |A| <= 106


Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.


Output Format
Return the head of the linked list after deleting the B-th element from the end.


Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1


Example Output
Output 1:
1->2->3->5
 */