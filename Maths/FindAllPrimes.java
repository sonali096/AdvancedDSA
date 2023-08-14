package Maths;

import java.util.Arrays;

public class FindAllPrimes {
    public int[] solve(int A) {
        boolean isprime[] = new boolean[A+1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for(int i =2; i*i <= A; i++){
            if(isprime[i]==true){
                for(int j = i*i; j >)
            }
        }
    }
    
}
/*Problem Description
Given an integer A. Find the list of all prime numbers in the range [1, A].


Problem Constraints
1 <= A <= 106



Input Format
Only argument A is an integer.



Output Format
Return a sorted array of prime number in the range [1, A].



Example Input
Input 1:
A = 7
Input 2:
A = 12


Example Output
Output 1:
[2, 3, 5, 7]
Output 2:
[2, 3, 5, 7, 11] */