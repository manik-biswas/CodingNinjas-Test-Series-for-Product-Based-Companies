public class Solution {
    public static int getMinCost(int i, int j, int [][] cost){
        if(i== -1){
            return 0;
        }
        else {
            int ans = Integer.MAX_VALUE;
            for(int k=0; k<3; k++){
                if(k!=j){
                    ans = Math.min(ans, getMinCost(i -1, k, cost)+cost[i][j]);
                }
            }
            return ans;
        }
    }

    public static int minCost(int[][] cost) {
        int n = cost.length;
        int ans = Integer.MAX_VALUE;
        for(int j =0; j<3; j++){
            ans = Math.min(ans, getMinCost(n-1, j, cost));
        }
        return ans;
        
    }   
}
