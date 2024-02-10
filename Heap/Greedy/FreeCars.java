import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    class Node{
        int time;
        int profit;
        Node(int t, int p){
            time = t;
            profit = p;
        }
    }
    class CustomComparator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b){
            return a.time - b.time;
        }
    }
    public int solve(int[] A, int[] B) {
        ArrayList<Node> list = new ArrayList<>();
        //add time and profit
        for(int i = 0; i < A.length; i++){
            list.add(new Node(A[i], B[i]));
        }
        Collection.sort(lsit, new CustomComparator());

        //build min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time = 0;
        int mod = 1000000000 + 7;
        for(int i = 0; i < A.length; i++){
            if(time <= list.get(i).time-1){
                pq.add(list.get(i).profit);
            }else{
                time--;
                if(pq.peek() < list.get(i).profit){
                    pq.poll();
                    pq.add(list.get(i).profit);
                }
            }
            time++;
        }
        long ans = 0;
        while(!pq.isEmpty()){
            ans = ans + pq.poll();
            ans = ans % mod;
        }
        return (int)ans;

    }
}

/*Problem Description
Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.

B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.

Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:

You can start buying from time = 0.
Return your answer modulo 109 + 7.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109



Input Format
The first argument is an integer array A represents the deadline for buying the cars.
The second argument is an integer array B represents the profit obtained after buying the cars.



Output Format
Return an integer denoting the maximum profit you can earn.



Example Input
Input 1:

 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
Input 2:

 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]


Example Output
Output 1:

 20
Output 2:

 30


Example Explanation
Explanation 1:

 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
Explanation 2:

 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30. */