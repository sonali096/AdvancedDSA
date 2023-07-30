package Maths;

public class ModSum {
    public int solve(int[] A) {
        long ans = 0l;
        long mod = 1000000000 + 7;
        int arr[] = new int[1001];
        for(int i = 0; i < A.length; i++){
            for(int j = 1; j <= 1000; j++){
                if(i!=j && arr[i] != 0 && arr[j]!=0){
                    int val = ((i%j)*arr[j]*arr[i]);
                    sum = ((sum % mod) + (val % mod)) %mod;
                }
            }
        }
        return (int)sum;
    }
    

}
//ALGo:
// Calculate the frequency of all the elements from 1 to 1000.
// For all values i from 1 to 1000 calculate sumi as sum of i % A[j] , where 1 <= j <= n
// Sum of all such ((sumi) * (frequency of i)) would be the final answer.
/*Problem Description
Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 105

1 <= A[i] <= 103



Input Format
The only argument given is the integer array A.



Output Format
Return a single integer denoting sum % (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 61 */
 //TLE
// public class Solution {
//     public int solve(int[] A) {
//         long sum = 0l;
//         long mod = 1000000000 + 7;
//         for(int i = 0; i < A.length; i++){
//             for(int j = 0; j < A.length; j++){
//                 sum = (sum + A[i] % A[j])%mod;
//             }
//         }
//         return (int)sum;
//     }
// }