package Recurssion;

public class GenerateParenthesis {
    public void generate(String str, int O, int C, int A,ArrayList<String> result){
        if(O==A && C==A){
            result.add(str);
            return;
        }
        if(O<A){
            generate(str+'(', O+1, C, A,result);
        }
        if(C<O){
            generate(str+')', O, C+1, A,result);
        }
    }
    public ArrayList<String> generateP(int A) {
        ArrayList<String> result = new ArrayList<String>();
        generate("",0,0,A,result);
        //result.add(str);
        return result;
    }
    
}
/*Q2. Generate all Parentheses II
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 10



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible parenthesis.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.
 */