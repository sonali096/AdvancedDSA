public class RainWaterTrapped {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        //Prefix
        int pr_sum[] = new int[n];
        pr_sum[0] = A[0];
        for(int i = 1; i < n; i++){
            pr_sum[i] = Math.max(A[i], pr_sum[i-1]);
            //System.out.print(pr_sum[i]);
        }
        // 0 1 1 2
        //System.out.println();
        //Suffix
        int sf_sum[] = new int[n];
        sf_sum[n-1] = A[n-1];
        for(int i = n-2; i > 0; i--){
            sf_sum[i] = Math.max(A[i], sf_sum[i+1]);
            //System.out.print(sf_sum[i]);
        }
        //System.out.println();
        int ans = 0;
        for(int i = 1; i < n-1; i++){
            int leftmax = pr_sum[i-1];
            int rightmax = sf_sum[i+1];
            int height = Math.min(leftmax, rightmax);
            int w = height - A[i];
            if(w>0){
                ans = ans + w;
            }
        }
        return ans;

    }
}
/*
1. Create Prefix Sum - Max Sum til point from left
2. Create Suffix Sum - Max sum till point from right
3. Calculate watr = Min(lefmax, rightMax) - height

*/
/*Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped. */