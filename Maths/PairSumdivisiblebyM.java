package Maths;

import java.util.HashMap;

public class PairSumdivisiblebyM {
    public int solve(int[] A, int B) {
        int n=A.length;
        long count=0;
        int mod=1000000007;
        //create hash map with remainder
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int val=0;
            if(A[i]>0){
                val=A[i]%B;
            }else{
                val=(A[i]%B)+B;//handle -ve value
            }
           // update hashmap
            if(map.containsKey(val)){
                map.put(val,hm.get(val)+1l);
            }else{
                map.put(val,1l);
            }  
        } 
        //handle 0 remainder
        if(map.get(0)!=null){
            long k=map.get(0);
            k=k%mod;
            count = count + (k*(k-1))/2;
        }
        //handle even numeber
        if(B%2 == 0){
            if(map.get(B/2)!=null){
                long k = map.get(B/2);
                k = k % mod;
                count = count + (k*(k-1))/2;
            }
        }
        //handle all other elements
        int i = 1, j = B - 1;
        while(i<j){
            if(map.get(i)!= null && map.get(j)!=null){
                count = count + map.get(i) * map.get(j);
            }
            i++;
            j--;
        }
        if(count<0){
            return (int)(count+mod)%mod;
        }
        return (int)count%mod;
    }
    
}
/*Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).

Note: Ensure to handle integer overflow when performing the calculations.


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:

 A = [5, 17, 100, 11]
 B = 28


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
Explanation 2:
 There is only one pair which is divisible by 28 is (17, 11)
 */