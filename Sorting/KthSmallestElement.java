package Sorting;

public class KthSmallestElement {
    public int kthsmallest(final int[] A, int B) {
        int n = A.length;
        for(int i = 0; i < n; i++){
            int min = A[i], index = i;
            for(int j = i+1; j<n;j++){
                if(A[j]<min){
                    min = A[j];
                    index = j;
                }
            }
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
        }
        return A[B-1];
    }
    
}
/*Problem Description
Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
The first argument is an integer array A.

The second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2 */