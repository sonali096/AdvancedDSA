public class MaximumSubmatrixSum {
    public long solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long suff[][] = new long[n][m];
        suff[n - 1][m - 1] = A[n - 1][m - 1];
        long ans = suff[n - 1][m - 1];
        for(int j = m - 2 ; j >= 0 ; j--){
            suff[n - 1][j] = suff[n - 1][j + 1] + A[n - 1][j];
            ans = Math.max(ans, suff[n - 1][j]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            suff[i][m - 1] = suff[i + 1][m - 1] + A[i][m - 1];
            ans = Math.max(ans, suff[i][m - 1]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = m - 2 ; j >= 0 ; j--){
                suff[i][j] = A[i][j] + suff[i + 1][j] + suff[i][j + 1] - suff[i + 1][j + 1];
                ans = Math.max(ans, suff[i][j]);
            }
        }
        return ans;
    }
}
/*
Problem Description
Given a row-wise and column-wise sorted matrix A of size N * M.
Return the maximum non-empty submatrix sum of this matrix.


Problem Constraints
1 <= N, M <= 1000
-109 <= A[i][j] <= 109


Input Format
The first argument is a 2D integer array A.


Output Format
Return a single integer that is the maximum non-empty submatrix sum of this matrix.


Example Input
Input 1:-
    -5 -4 -3
A = -1  2  3
     2  2  4
Input 2:-
    1 2 3
A = 4 5 6
    7 8 9


Example Output
Output 1:-
12
Output 2:-
45


Example Explanation
Expanation 1:-
The submatrix with max sum is 
-1 2 3
 2 2 4
 Sum is 12.
Explanation 2:-
The largest submatrix with max sum is 
1 2 3
4 5 6
7 8 9
The sum is 45.



Imagine you had the same problem but with a 1D array. 
That is if the array was sorted and find the maximum subarray.

What would be the answer? The answer will be the sum of one of the suffixes right? 
So we could check over all suffix arrays
and return the maximum sum. 

The sum of all suffix arrays can be computed in O(N).
Now apply the same logic on a 2D matrix.

What is a suffix matrix? 
     A matrix whose right lower corner is always the N*M th element. 

Now we can have iterate over all the possible top left corners which is N*M. So N*M matrices.
The sum of each of these matrices can be computed in O(1) with a precomputation of O(N*M).
Return the maximum sum of all these matrices. 

Time Complexity - O(N * M)
Space Complexity - O(N * M)
*/