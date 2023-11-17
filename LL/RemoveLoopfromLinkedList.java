package LL;
/**
 * Definition for singly-linked list.*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class RemoveLoopfromLinkedList {
    public ListNode solve(ListNode A) {
        ListNode slow = A, fast = A;
        //detect if loop present

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
            if(slow==fast) break;
        }
        //find the starting point of loop
        slow = A;
        while(slow!=fast){
            slow = slow.next;
            if(slow==fast.next){
                fast.next = null;
                break;
            }
            fast = fast.next;
        }
        return A;
    }

    
}
/*Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.



Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.

 */