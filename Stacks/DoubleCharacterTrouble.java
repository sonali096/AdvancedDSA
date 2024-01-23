package Stacks;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public String solve(String A) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < A.length();i++){
            char ch = A.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }else if(st.peek() == ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
/*Problem Description
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.


Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is string A.



Output Format
Return the final string.



Example Input
Input 1:

 A = "abccbc"
Input 2:

 A = "ab"


Example Output
Output 1:

 "ac"
Output 2:

 "ab" */