package BinarySearch;

public class SingleElementinSortedArray {
    public int solve(int[] A) {
        int n = A.length;
        if(n == 1) return A[0];
        if(A[0] != A[1]) return A[0];
        if(A[n-1]!= A[n-2]) return A[n-1];
        int l = 1, r = n-2;
        while(l <= r){
            int m = (l+r)/2;
            int x = A[m-1];
            int y = A[m];
            int z = A[m+1];
            if(y!=x && y!=z){
                return y;
            }
            //If the mid is at first occurance, bring it to second occurance   
            if(y==z){
                m = m+1;
            }
            // 1st occurance is even, go to left side
            if(m%2 == 0){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }
    
}
/*Single Element in Sorted Array
 * Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2
 */