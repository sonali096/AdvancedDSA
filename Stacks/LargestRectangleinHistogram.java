package Stacks;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] A) {
        int ans = 0;
        int n = A.length;
        int nearestLeft[] = new int[n];
        int nearestReft[] = new int[n];
        for(int i = 0 ; i < n; i++){
            int h = A[i];
            int s = nearestLeft[i], e = nearestReft[i];
            int w = e - s - 1;
            int area = h * w;
            ans = Math.max(ans, area);
        }
        return ans;
    }
    public int[] nearestLeft(int [] A){
        int n = A.length;
        Stack<Integer> myStack = new Stack<>();
        int ans[] = new int[n];
        for(int i = 0 ; i < n; i++){
            while(myStack.size() > 0 && A[myStack.peek()] >= A[i]){
                myStack.pop();
            }
            if(myStack.size() > 0){
                ans[i] = myStack.peek();
            }else{
                ans[i] = -1;
            }
            myStack.push(i);
        }
        return ans;
    }
    public int[] nearestReft(int [] A){
        int n = A.length;
        Stack<Integer> myStack = new Stack<>();
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(myStack.size() > 0 && A[myStack.peek()] >= A[i]){
                myStack.pop();
            }
            if(myStack.size() > 0){
                ans[i] = myStack.peek();
            }else{
                ans[i] = n;
            }
            myStack.push(i);
        }
        return ans;
    }
    
}
// TLE - Bruteforce
// public class Solution {
//     public int largestRectangleArea(ArrayList<Integer> A) {
//         int ans = 0;
//         int n = A.size();
//         for(int i = 0; i < n ; i++){
//             int h = A.get(i);
//             for(int j = i; j < n; i++){
//                 h = Math.min(h,A.get(j));
//                 int w = j - i + 1;
//                 ans = Math.max(ans, h*w);
//             }
//         }
//         return ans;
//     }
// }
/*Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2. */