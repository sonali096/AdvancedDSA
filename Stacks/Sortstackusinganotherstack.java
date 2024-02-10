package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class Sortstackusinganotherstack {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        int n = A.size();
        for(int i = 0; i < n; i++){
            int val = A.get(i);
            ArrayList<Integer> list=new ArrayList<>();
            if(!st.isEmpty()){
                while(!st.isEmpty() && st.pop() < val ){
                    list.add(st.pop());
                }
                st.push(val);
                for(int j=list.size()-1;j>=0;j--){
                    st.push(list.get(j));
                }
            }else{
                st.push(val);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!(stack.isEmpty())){
            ans.add(stack.pop());
        }
        return ans;
    }
}
/*Problem Description
Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 109



Input Format
The only argument is a stack given as an integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers */