package Queue;

import java.util.Queue;

import LL.LinkedList;

public class PerfectNumbers {
    public String solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        for(int i = 1; i < A; i++){
            String element = q.peek();
            q.offer(element + "1");
            q.offer(element + "2");
            q.poll();
        }
        StringBuilder sb = new StringBuilder(q.peek());
        sb.reverse();
        String ans = q.poll() + sb;
        return ans;
    }
    
}
/*Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.

 */