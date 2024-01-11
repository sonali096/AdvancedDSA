package Stacks;

public class  BalancedParanthesis {
    public int solve(String A) {
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < A.length();i++){
            char ch = A.charAt(i);
            if(isopen(ch)){
                myStack.push(ch);
            }else{
                if(myStack.isEmpty()){
                    return 0;
                }
                char top = myStack.pop();
                if(!isValid(top,ch)){
                    return 0;
                }
            }
        }
        if (myStack.isEmpty()) { //if stack is empty then we have all valid pairs
            return 1;
        }
        return 0;
    }
    public boolean isOpenParanthesis(char c){
        return c == '(' || c == '[' || c == '{';
    }
    public boolean isValid(char a, char b ){
        if(a == '(' && b == ')'){
            return true;
        }else if (a == '[' && b == ']') {
            return true;
        }else if (a == '{' && b == '}') {
            return true;
        }else {
            return false;
        }
    }
    
}
/*Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output
Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid. */