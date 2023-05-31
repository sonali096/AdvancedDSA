/*Problem Description
Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].


Problem Constraints
1 <= len(A) <= 105
1 <= A[i] <= 109


Input Format
The first argument is an integer array A.


Output Format
Return a single integer that is the maximum A[i] & A[j].


Example Input
Input 1:-
A = [53, 39, 88]
Input 2:-
A = [38, 44, 84, 12] 


Example Output
Output 1:-
37
Output 2:-
36


Example Explanation
Explanation 1:-
53 & 39 = 37
39 & 88 = 0
53 & 88 = 16
Maximum among all these pairs is 37
Explanation 2:-
Maximum bitwise and among all pairs is (38, 44) = 36
 */
package BITM;

public class MaximumANDPair {
    public boolean checkBit(int N, int index){
        return ((N >> i) & 1) == 1
    }
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        //count set bits
        for(int i = 30; i >= 0; i++){
            int c = 0;
            for(int j = 0; j < n; j++){
                if(checkBit(A[j],i)){
                    c = c + 1;
                }
            }
            if(c >= 2){
                ans = ans + (1 << i);
                //set unwanted numbers to 0
                for(int j = 0; j < n; j++){
                    if(!checkBit(A[j],i)){
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
//brute Force
// public class Solution {
//     public int solve(int[] A) {
//         int ans = 0;
//         int n = A.length;
//         for(int i = 0; i < n; i++){
//             int val = 0;
//             for(int j = i+1; j < n; j++){
//                 val = A[i] & A[j];
//                 //System.out.print(val + " ");
//                 ans = Math.max(ans, val);
//                 //System.out.println(ans + " ");
//             }
            
            
//         }
//         return ans;
//     }
// }