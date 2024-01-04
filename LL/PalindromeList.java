package LL;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class PalindromeList {
    public int lPalin(ListNode A) {
        int l = findlen(A);
        ListNode a = getkthelemenet(A, (l - 1)/2);
        ListNode hc = a.next;
        a.next = null;
        hc = reverseList(hc);

        //Compare
        ListNode i = A;
        ListNode j = hc;
        while(j!=null){
            if(i.val != j.val) return 0;
            i = i.next;
            j = j.next;
        }
        return 1;
    }
    private ListNode reverseList(ListNode A){
        if( A == null || A.next == null) return A;
        ListNode prev = null;
        ListNode curr = A;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode getkthelemenet(ListNode A, int k){
        ListNode hc = A;
        for(int i = 0; i < k; i++){
            hc = hc.next;
        }
        return hc;
    }
    private int findlen(ListNode A){
        int c = 0;
        ListNode hc = A;
        while(hc != null){
            c++;
            hc = hc.next;
        }
        return c;
    }
    
}
/*Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1 
Output 2:

 0 


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1]. */