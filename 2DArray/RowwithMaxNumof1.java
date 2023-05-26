package 2DArray;

public class RowwithMaxNumof1 {
    public int solve(int[][] A) {
        int N = A.length;
        int i = 0; //Starting from first row
        int j= N-1 ; //Starting from last column
        //int count = 1;
        int ans = 0 ; // for storing the index number

        while (i< N && j >= 0) {
            if ( A[i][j] == 0) {
                i++;
            }else if (A[i][j]== 1){
                j--; 
                //count++; 
                ans = i;
            }      
        }
        return ans;
    }
}
