package BITM;

import java.util.ArrayList;
import java.util.Collection;

public class MinXORvalue {
    public int findMinXor(ArrayList<Integer> A) {
        //sorting the array to bring the elements having least difference close to each other.
        //we are doing this becoz the number with least difference will give us the min xor value.
        Collections.sort(A);
        int min_xor=Integer.MAX_VALUE;
        for(int i=0;i<A.size()-1;i++){
            int val = (A.get(i)^A.get(i+1));
            min_xor = Math.min(min_xor,val);
        }
        return min_xor;
    }
}
/*Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting minimum xor value.



Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 0 xor 2 = 2 */