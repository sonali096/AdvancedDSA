package Maths;

public class VeryLargePower {
    public int solve(int A, int B) {
        long mod=1000000007;
        long fact=1;
        for(int i=1; i <= Bl i++){
            fact = (i * fact%(mod-1))
        }
        fact = fact % (mod-1);
        return fastexpo(A,(int)fact, (int)mod);
    }
    public int fastexpo(int A, int B, int P){
        if(B==0) return 1;
        long ha=fastexpo(A,B/2,P)%P;
        long hp=(ha*ha)%P;
        if(B%2==0){
            return (int)hp;
        }else{
            return (int)((hp*A)%P);
        }
    }
    
}
/*Problem Description
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,
"%" means mod, and
"!" means factorial.

Note: Ensure to handle integer overflow when performing the calculations.


Problem Constraints
1 <= A, B <= 5e5



Input Format
First argument is the integer A

Second argument is the integer B



Output Format
Return one integer, the answer to the problem



Example Input
Input 1:

A = 1
B = 1
Input 2:

A = 2
B = 2


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

 1! = 1. Hence 1^1 = 1.
Explanation 2:

 2! = 2. Hence 2^2 = 4.
 */