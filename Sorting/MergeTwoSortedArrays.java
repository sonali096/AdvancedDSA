package Sorting;

public class MergeTwoSortedArrays {
    public int[] solve(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int c[] = new int[n+m];
        int i =0, j = 0,k=0;
        while(i<n && j<m){
            if(A[i]<B[j]){
                c[k] = A[i];
                i++;
                k++
            }else{
                c[k] = A[j];
                j++;
                k++;
            }
        }
        if(i<n){
            while(i<n){
                c[k] = A[i];
                i++;
                k++;
            }
        }else{
            while(j<m){
                c[k] = B[j];
                j++;
                k++;
            }
        }
        return c;
    }
    
}
/*Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.


Problem Constraints
-1010 <= A[i], B[i] <= 1010


Input Format
First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.


Output Format
Return a 1-D vector which you got after merging A and B.


Example Input
Input 1:

A = [4, 7, 9]
B = [2, 11, 19]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above. */