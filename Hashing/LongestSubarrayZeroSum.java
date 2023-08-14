package Hashing;

import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        map.put(sum, -1);
        for(int i = 0, i < n, i++){
            sum = sum + A[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return ans;
    }
}
