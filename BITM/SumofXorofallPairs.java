package BITM;

import java.util.ArrayList;

public class SumofXorofallPairs {
    public boolean checkBit(int N, int index){
        return ((N << i) & 1) == 1;
    }
    public int solve(ArrayList<Integer> A){
        int n = A.size();
        int paircount = (n * (n-1))/2;
        int ans = 0, totalcount = 0;
        int mod = 1000000007;
        for(int i = 0; i <= 30; i++){
            long set = 0, unset = 0;
            for(int j = 0; j < n; j++){
                if(checkBit(A.get(j), i)){
                    set = set + 1;
                }else{
                    unset = unset + 1;
                }
            }
            if(n == set || n == unset){
                totalcount = 0;
            }else{
                totalcount = set * unset;
            }
            ans = ans + ((1 << i) * totalcount);
            ans = ans % mod;
        }
        return (int)ans%mod;

    }
}
/*Problem Description
Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder after the dividing the answer by 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] < 109



Input Format
Only argument A is an array of integers



Output Format
Return an integer denoting the sum of xor of all pairs of number in the array.



Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [3, 4, 2]


Example Output
Output 1:
6
Output 2:
14


Example Explanation
For Input 1:
Pair    Xor
{1, 2}  3
{1, 3}  2
{2, 3}  1
Sum of xor of all pairs = 3 + 2 + 1 = 6.
For Input 2:
Pair    Xor
{3, 4}  7
{3, 2}  1
{4, 2}  6
Sum of xor of all pairs = 7 + 1 + 6 = 14. */

/* */