package Heap;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Minimumlargestelement {
    class Pair{
        int val,ind;
        //int val;
        Pair(int x, int y){
            ind = y;
            val = x;
        }
    }
    public int solve(int[] A, int B) {
        int n = A.length;
        int state[] = A.clone();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sortVal());
        for(int i = 0; i < n; i++){
            int data = state[i] + state[i];
            Pair p = new Pair(data, i);
            pq.add(p);
        }
        //B time opertaion
        for(int i = 0; i < B; i++){
            int value = pq.peek().val;
            int index = pq.peek().ind;
            pq.remove();
            state[index] = value;
            Pair p = new Pair(value+A[index], index);
            pq.add(p);
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(state[i], max);
        }
        return max;

    }
    public class sortVal implements Comparator<Pair>{
        @Override
        public int compare(Pair a, Pair b){
            return a.val - b.val;
        }
    }
    
}
/*Problem Description
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.



Problem Constraints
1 <= N <= 106
0 <= B <= 105
-104 <= A[i] <= 104



Input Format
The first argument is an integer array A.
The second argument is an integer B.



Output Format
Return an integer denoting the minimum possible largest element after B operations.



Example Input
Input 1:

 A = [1, 2, 3, 4] 
 B = 3
Input 2:

 A = [5, 1, 4, 2] 
 B = 5


Example Output
Output 1:

 4
Output 2:

 5
 */