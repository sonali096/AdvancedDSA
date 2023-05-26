package 2DArray;

public class Sub-matrixSumQueries {
    /**
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @return
     */
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int row = A.length;
        int col = A[0].length;
        int mod=(int)Math.pow(10,9)+7;
        
        //Prefix sum on Every row
        //int prf_sum_row[][] = new int[row][col];
        //prf_sum_row[0][0] = A[0][0]
        for(int r = 0; r < row; r++){
            for(int c = 1; c < col; c++){
                A[r][c] = (A[r][c-1] + A[r][c])%mod;
            }
        }
        //Prefix sum on Every col
        for(int c = 0; c < col; c++){
            for(int r = 1; r < row; r++){
                A[r][c] = (A[r-1][c] + A[r][c])%mod;
            }
        }
        // for(int r = 0; r < row; r++){
        //     for(int c = 0; c < col; c++){
        //         System.out.print(A[r][c] + ",");
        //     }
        //     System.out.println();
        // }
        int result[] = new int[B.length];
        for(int i = 0; i < B.length; i++){
            int sx = B[i]-1, ex = C[i]-1;
            int sy = D[i]-1, ey = E[i]-1;
            int sum = 0;
            if(sx==0 && ex==0){
                sum = (A[sy][ey])%mod;
            }else if(sx > 0 && ex > 0){
                sum = (A[sy][ey]-A[sx-1][ey]-A[sy][ex-1]+A[sx-1][ex-1])%mod;
            }else if(sx > 0){
                sum = (A[sy][ey] - A[sx-1][ey])%mod;
            }else if(ex > 0){
                sum = (A[sy][ey] - A[sy][ex-1])%mod;
            }
            if(sum<0){
                result[i] = sum + mod;
            }else{
                result[i] = sum;
            }
        }
        return result;
    }
}
/*
 Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
The sum may be large, so return the answer mod 109 + 7.
Also, select the data type carefully, if you want to store the addition of some elements.
Indexing given in B, C, D, and E arrays is 1-based.
Top Left 0-based index = (B[i] - 1, C[i] - 1)
Bottom Right 0-based index = (D[i] - 1, E[i] - 1)


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.



Output Format
Return an integer array containing the submatrix sum for each query.



Example Input
Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:

 [12, 28]
Output 2:

 [22, 19]


Example Explanation
Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 
 */
