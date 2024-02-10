package Stacks;

import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < A.size(); i++){
            String str = A.get(i);
            if(isOperand(A, i)){
                int num1 = st.pop();
                int num2 = st.pop();
                if(str.equals('+')){
                    st.push(num2+num1);
                }else if(str.equals('-'))){
                    st.push(num2-num1);
                }else if(str.equals('*')){
                    st.push(num2*num1);
                }else if(str.equals('/')){
                    st.push(num2/num1);
                }
            }else{
                int val = Integer.parseInt(str);
                st.push(val);
            }
        }
        return val; 
    }
    public boolean isOperand(ArrayList<String> s, int val ){
        String str = s.get(val);
        if(str.equals('+')){
            return true;
        }else if(str.equals('-')){
            return true;
        }else if(str.equals('*')){
            return true;
        }else if(str.equals('/')){
            return true;
        }else{
            return false;
        }
    }
    
}
/*An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is string array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
A =   ["2", "1", "+", "3", "*"]
Input 2:
A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
9
Output 2:
6


Example Explanation
Explaination 1:
starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
starting from backside:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6 */