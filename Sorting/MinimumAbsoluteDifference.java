package Sorting;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n-1;i++){
            int ans = Math.abs(A[i] - A[i+1]);
            res = Math.min(res,ans);
        }
        return res;
    }
}

/*Problem Description
Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.



Problem Constraints
2 <= length of the array <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum value of | A[i] - A[j] |.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 The absolute difference between any two adjacent elements is 1, which is the minimum value.
Explanation 2:

 The minimum value is 6 (|11 - 5| or |17 - 11|). */