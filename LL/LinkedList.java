package LL;

public static ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }
}
public class LinkedList {
    public static ListNode head = null;
    public static int size = 0;
    //insert
    public static void insert_node(int position, int a){
        if(position==1){
            ListNode node = new ListNode(a);
            node.next = head;
            head = node;
        }else if(position > size+1){
            return;
        }else{
            ListNode temp = head;
            ListNode node = new ListNode(a);
            for(int i = 1; i < position-1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }
    //delete
    public static void delete_node(int position){
        if(position==1){
            head = head.next;
        }else if(position > size + 1){
            return;
        }else{
            ListNode temp = head;
            for(int i = 1; i < position-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
    //print
    public static void print_ll(){
        ListNode temp = head;
        while(temp.next!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
}

    
}

/*Problem Description
Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node.

It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in a new line.


Problem Constraints
1 <= value <= 105
1 <= position <= n where, n is the size of the linked-list.



Input Format
First line contains an integer denoting number of cases, let's say t. Next t line denotes the cases.


Output Format
When there is a case of print_ll(), Print the entire linked list, such that each element is followed by a single space.

There should not be any trailing space.

NOTE: You don't need to return anything.


Example Input
Input 1:
5
i 1 23
i 2 24
p
d 1
p
Input 2:
3
i 1 54
d 10
p


Example Output
Output 1:
23 24
24
Output 2:
54


Example Explanation
Explanation 1:
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
Explanation 2:
After the first case,  linked list contains: 54

At second case delete value at 10th position,  
Since the position is higher than the length of the linkedlist. 
It does not satisfy the constraint, So no action is required.

At third case print: 54. */