public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
	    
	    int carry = 1;
	    int num;
	    int size = A.size();
	    
	    // traversing the digits of the number in reverse order
	    for (int i = size - 1; i >= 0; i--) {
	        
	        num = A.get(i);
	        num = num + carry;
	        carry = 0;
	        
	        if (num == 10) {
	            num = 0;
	            carry = 1;
	        }
	        
	        A.set(i, num);
	        
	    }
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    if (carry == 1)
	        res.add(1);
	    
	    for (int x : A) {
	        if (x == 0 && res.size() == 0)
	            continue;
	        res.add(x);
	    }
	    
	    return res;
	    
	}
}
//Alog
/* 
1. reverse the array
2. Add one in the beginning using carry technique
3. check if you need to add 1 element to the array
4. Remove all leading zeros
5. Reverse the array

Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

*/