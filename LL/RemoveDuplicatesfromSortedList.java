package LL;
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next
            }else{
                temp = temp.next;
            }
        }
        return A;

    }
}
/*Given a sorted linked list, delete all duplicates such that each element appears only once.



Problem Constraints
0 <= length of linked list <= 106



Input Format
First argument is the head pointer of the linked list.



Output Format
Return the head pointer of the linked list after removing all duplicates.



Example Input
Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output
Output 1:

 1->2
Output 2:

 1->2->3 */
