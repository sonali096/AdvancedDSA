package 2DArray;

public class MinimumSwaps {
    public int solve(int[] A) {
        int count=0;
        int i=0;
        while(i<A.length){
            if(A[i]==i){
                i++;
            }else{
                count++;
                int temp=A[i];
                A[i]=A[temp];
                A[temp]=temp;
            }
        }
        return count;
    }
}