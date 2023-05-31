package BITM;
import java.util.ArrayList;
import java.util.Collection;

public class SingleNumberIII {
    public boolean checkBit(int N, int index){
        return (( N >> i ) & 1) == 1;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int position = 0, val = 0;
        //do xor of all elements
        for(int i = 0; i < n; i++){
            val = val ^ A.get(i);
        }
        //find the set bit position
        for(int i = 0 ; i <= 30; i++){
            if(checkBit(val, i)){
                position = i;
            }
        }
        //split the array
        int set = 0, unset = 0;
        for(int i = 0; i < n; i++){
            if(checkBit(A.get(i), position)){
                set = set ^ A.get(i);
            }else{
                unset = unset ^ A.get(i);
            }
        }
        //add set and unset to array and sort it
        ans.add(set);
        ans.add(unset);
        Collection.sort(ans);
        return ans;

    }
    
}
/*Q1. Single Number III
Solved
Hint bulb icon
Stuck somewhere?
Using hints is now penalty free
Check Now
Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
The first argument is an array of integers of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:
[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:

1 and 2 appear only once. */