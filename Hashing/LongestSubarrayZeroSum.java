package Hashing;

import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        map.put(0L, -1);
        for(int i = 0, i < n, i++){
            sum = sum + A[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return ans;
    }
}
/*Problem Description
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0. */