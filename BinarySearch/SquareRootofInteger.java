package BinarySearch;

public class SquareRootofInteger {
    public int sqrt(int A) {
        long l = 1, r = A;
        long ans = 1;
        if(A==0) return 0;
        while(l <= r){
            long m  = (l+r)/2;
            if(m*m <= A){
                ans = m;
                l = m + 1;//go right
            }else{
                r = m - 1;//go left
            }
        }
        return (int)ans;
    }
    
}
/*Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

The value of A can cross the range of Integer.

NOTE: 
   Do not use the sqrt function from the standard library. 
   Users are expected to solve this in O(log(A)) time.


Problem Constraints
0 <= A <= 1010


Input Format
The first and only argument given is the integer A.


Output Format
Return floor(sqrt(A))


Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanatino 2:
When A = 9 which is a perfect square of 3, so we return 3.
 */