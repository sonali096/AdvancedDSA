package Stacks;

public class MAXandMIN {
    public int solve(int[] A) {
        long mod = (long) 1000000007;
        long ans = 0;
        int [] ngl_ar = nglIndex(A);
        int [] ngr_ar = ngrIndex(A);

        int [] nsl_ar = nslIndex(A);
        int [] nsr_ar = nsrIndex(A);

        for (int i = 0; i < A.length; i++) {
            int s1 = ngl_ar[i] + 1, e1 = ngr_ar[i] -1;
            long total_max = 1L * (i-s1+1) * (e1-i+1);
            int s2 = nsl_ar[i] + 1, e2 = nsr_ar[i] -1;
            long min = 1L * (i-s2+1) * (e2-i+1);
            ans = ans + (total_max - total_min) * A[i];
        }
        return (int) (ans % mod);
    }
    public int[] nglIndex(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            int val = A[i];
            while(stk.size() > 0 && A[stk.peek()] <= val){
                stk.pop();
            }
            if(stk.size()>0){
                res[i] = stk.peek();
            }else{
                res[i] = -1;
            }
            stk.push(i);
        }
        return res;

    }
    public int[] ngrIndex(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            int val = A[i];
            while(stk.size() > 0 && A[stk.peek()] <= val){
                stk.pop();
            }
            if(stk.size()>0){
                res[i] = stk.peek();
            }else{
                res[i] = n;
            }
            stk.push(i);
        }
        return res;
    }
    public int[] nslIndex(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            int val = A[i];
            while(stk.size() > 0 && A[stk.peek()] >= val){
                stk.pop();
            }
            if(stk.size()>0){
                res[i] = stk.peek();
            }else{
                res[i] = -1;
            }
            stk.push(i);
        }
        return res;
    }
    public int[] nsrIndex(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(nt i=n-1 ;i>=0; i--){
            int val = A[i];
            while(stk.size() > 0 && A[stk.peek()] >= val){
                stk.pop();
            }
            if(stk.size()>0){
                res[i] = stk.peek();
            }else{
                res[i] = n;
            }
            stk.push(i);
        }
        return res;
    }
}
/*Problem Description
Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26 */