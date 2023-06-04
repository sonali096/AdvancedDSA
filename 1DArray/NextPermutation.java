public class NextPermutation {
    public void reverse(int []A, int startindex){
        int n = A.length;
        int i = startindex, j = n-1;
        while(i<j){
            swap(i,j,A);
            i++;
            j--;
        }
    }
    public void swap(int []A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int[] nextPermutation(int[] A) {
        int n = A.length;
        if(n==1){
            return A;
        }
        //find the first breaking point
        int index = -1;
        for(int i = n-1; i >= 1; i--){
            if(A[i]>A[i-1]){
                index = i;
                break;
            }
        }
        //return sorted array if there is not DIP found
        if(index == -1){
            reverse(A, 0);
            return A;
        }
        //find the next Large value which is just greater than breaking index
        int swapIdx = -1;
        reverse(A, index);
        for(int i = index; i < n; i++){
            if(A[i]>A[index-1]){
                swapIdx = i;
                break;
            }
        }
        swap(A, index-1, swapIdx);
        return A;
        
    }
    
}
/*Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format
The first and the only argument of input has an array of integers, A.



Output Format
Return an array of integers, representing the next permutation of the given array.



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order. */