package Sorting;

import java.util.Collection;
import java.util.Comparator;

public class Factorssot {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collection.Sort(A, Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                Integer fa = factors(a);
                Integer fb = factors(b);
                if(fa==fb){
                    return a-b;
                }
                return fa-fb;
                
            }
        });
        return A;
    }
    Integer factors(Integer n){
        Integer cnt = 0;
        for(Integer i = 1; i*i <= n; i++){
            if(n%i==0){
                cnt++;
                if(i*i != n){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new factorClass());
        return A;
    }
    public class factorClass implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            int fa = factors(a), fb = factors(b);
            if(fa<fb) return -1;
            else if(fb < fa) return 1;
            else{
                return a-b;
            }
        }
    }
    public int factors(int N){
        int cnt = 0;
        for(int i = 1; i * i <=N; i++){
            if(N%i==0){
                if(i == N/i){
                    cnt++;
                }else{
                    cnt = cnt + 2;
                }
            }
        }
        return cnt;
    }
}
/*You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space


Problem Constraints
1 <= N <= 104
1 <= A[i] <= 104


Input Format
First argument A is an array of integers.


Output Format
Return an array of integers.


Example Input
Input 1:
A = [6, 8, 9]
Input 2:
A = [2, 4, 7]


Example Output
Output 1:
[9, 6, 8]
Output 2:
[2, 7, 4]


Example Explanation
For Input 1:
The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
For Input 2:
The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors. */