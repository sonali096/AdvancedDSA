package Queue;

public class SlidingMaxMinsum {
    public int solve(int[] A, int B) {
        int n = A.length;
        long sum = 0;
        long mod = 1000000007;
        Deque<Integer> dq1 = new ArrayDeque<>(); // dq1 is to get the max in each subarray.
        Deque<Integer> dq2 = new ArrayDeque<>(); // dq2 is to get the min in each subarray.
        for (int i = 0; i < B; i++) {
            while (dq1.size () > 0 && dq1.getLast() < A[i]) {
                dq1.removeLast();
            }
            dq1.addLast(A[i]);
            while (dq2.size() > 0 && dq2.getLast() > A[i]) {
                dq2.removeLast();
            }
            dq2.addLast(A[i]);
        }
        sum += dq1.getFirst() + dq2.getFirst();
        int s = 1;
        int e = B;
        while (e < n) {
            if (A[s - 1] == dq1.getFirst()) {
                dq1.removeFirst();
            }
            if (A[s - 1] == dq2.getFirst()) {
                dq2.removeFirst();
            }
            while (dq1.size() > 0 && dq1.getLast() < A[e]) {
                dq1.removeLast();
            }
            dq1.addLast(A[e]);
            while (dq2.size() > 0 && dq2.getLast() > A[e]) {
                dq2.removeLast();
            }
            dq2.addLast(A[e]);
            sum += dq1.getFirst() + dq2.getFirst();
            s++;
            e++;
        }
// The elements in the array can be negative and the final sum could be negative too.
// Since we need to the modulo operation, the remainder cannot be negative. So, we do the below step.
        long ans = ((sum % mod) + mod) % mod;
        return (int)ans;
    }
    
}
/*Problem Description
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:

 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
 */