import java.util.Arrays;
public class Solution {
    public static int recursion(int [] loads, int index, int sum, int server1, int[][] dp){
        if(index==0){
            return Math.abs(sum - server1 - server1);
        }
        int answer = dp[index][server1];
        if(answer != -1){
            return answer;
        }
        answer=recursion(loads, index-1, sum, server1, dp);
        answer = Math.min(answer, recursion(loads, index-1, sum,server1+loads[index-1], dp));
        dp[index][server1]=answer;
        return answer;
    }

    public static int minAbsDiff(int n, int[] loads) {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=loads[i];
        }
        int[][] dp = new int[n+1][sum+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int server1 = 0;
        return recursion(loads, n, sum, server1, dp);
    }
}