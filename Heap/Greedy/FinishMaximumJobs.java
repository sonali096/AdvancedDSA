package Heap.Greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.RunElement;

public class FinishMaximumJobs {
    class Pair{
        int start;
        int end;
        Pair(int s, int e){
            start = s;
            end = e;
        }
    }
    class CustomComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair a, Pair b){
            return a.end - b.end;
        }
    }
    public int solve(int[] A, int[] B) {
        ArrayList<Pair> jobs = new ArrayList<>();
        for(int i = 0; i < A.length;i++){
            jobs.add(new Pair(A[i],B[i]));
        }
        Collection.sort(jobs, new CustomComparator());
        
        int ans = 1, end_lastjob = jobs.get(0).end;
        for(int i = 1; i < A.length; i++){
            if(jobs.get(i).start >= end_lastjob){
                end_lastjob = jobs.get(i).end;
                ans++;
            }
        }
        return ans;
    }
    
}
/*Problem Description
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.



Problem Constraints
1 <= N <= 105

1 <= A[i] < B[i] <= 109



Input Format
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.



Output Format
Return an integer denoting the maximum number of jobs you can finish.



Example Input
Input 1:

 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:

 A = [3, 2, 6]
 B = [9, 8, 9]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:

 Since all three jobs collide with each other. We can do only 1 job.
 */