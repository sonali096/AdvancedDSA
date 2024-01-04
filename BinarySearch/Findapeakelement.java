package BinarySearch;

public class Findapeakelement {
    public int solve(int[] A) {
        int n = A.length;
        int l = 0, r = n-1;
        if(n==1) return A[0];
        if(A[0]>A[1]) return A[0];
        if(A[n-1]>=A[n-2]) return A[n-1];
        while(l<=r){
            int m = (l+r)/2;
            if((m==0||A[m-1]<A[m]) && (m==n-1 || A[m+1]< A[m])){
                return A[m];
            }
            if(m==0||A[m-1]<A[m]){
                l = m + 1; //go right
            }else{
                r = m -1; //go left
            }
        }
        return -1;
    }
    
}
/*Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak. */