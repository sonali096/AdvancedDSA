package TwoPointer;

public class PairswithgivensumII {
    public int solve(int[] A, int B) {
        int n = A.length;
        int s = 0, e = n-1;
        long count = 0;
        long sum=0;int mod=1000000007;
        while(s<e){
            sum = (A[s] + A[e]) % mod;
            if(sum==B){
                if(A[s]==A[e] && A[s]+A[e]==B){
                    long m = (e-s);
                    long n = (e-s+1);
                    count = count + (n*m)/2;
                    break;
                }else{
                    int left=1,right=1;
                    while(A[s]==A[s+1]){
                        left++;
                        s++;
                    }
                    while(A[e]==A[e-1]){
                        right++;
                        e--;
                    }
                    s++;
                    e--;
                    count = count + left * right;
                }

            }else if(sum>B){
                e--;
            }else{
                s++;
            }
        }
        return (int) (count%mod);
    }
}
/*Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output
Output 1:

 3
Output 2:

 1 */