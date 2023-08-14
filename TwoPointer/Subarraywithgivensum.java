package TwoPointer;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class Subarraywithgivensum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int i = 0, j = 0, sum = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(j<n){
            if(sum<B){
                sum = sum + A.get(j);
                j++;
            }
            if(sum>B){
                sum = sum - A.get(i);
                i++;
            }
            if(sum == B){
                for(int i1 = i; i1<j; i++){
                    ans.add(A.get(i1));
                }
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
    
}
/*Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110
 */