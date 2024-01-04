package Sorting;

public class Inversioncountinanarray {
    static long count;
    public static int[] mergeTwoSortedArray(int[] A , int[] B){
        int n = A.length;
        int m = B.length;
        long mod =  1000000000 + 7;
        int i = 0 , j = 0 , k = 0;
        int[] ans = new int[n + m];
        while(i < n && j < m){
            if(A[i] > B[j]){
                ans[k] = B[j];
                j++;
                count = (count + (n - i) ) % mod;;
            }
            else{
                ans[k] = A[i];
                i++;
            }
            k++;
        }
        while(i < n){
            ans[k] = A[i];
            i++;
            k++;
        }
        while(j <  m){
            ans[k] = B[j];
            j++;
            k++;
        }
        return ans;
    }
    public static int[] mergeSort(int[] arr , int l , int r){
        if(l == r){
            int bres[] = int[1];
            bres[0] = arr[l];
            return bres;
        }
        int m = (l+r)/2;
        int A[] = mergeSort(arr, l, m);
        int B[] = mergeSort(arr, m+1, r);
        int C[] = mergeTwoSortedArray(A, B);
        return C;
    }
    public int solve(int[] A) {
        int n = A.length;
        count = 0;
        int ans[] = mergeSort(A, 0, n-1);
        return (int)count;
    }
}
/*Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 105

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [3, 4, 1, 2]


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
Explanation 2:

The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3] */