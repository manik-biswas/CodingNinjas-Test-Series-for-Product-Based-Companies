

import java.lang.Math;
public class Solution{
    public static int maxSubarraySum(int []arr, int n){
        int answer =arr[0];
        int current= arr[0];
        for(int i=1; i<n; ++i){
            current = arr[i] + Math.max(current, 0);
            answer =Math.max(answer, current);

        }
        int [] rigthSum=new int [n];
        rigthSum[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rigthSum[i] = rigthSum[i+1]+ arr[i];

        }
        int [] maxRigth = new int[n];
        maxRigth[n-1]= arr[n-1];
        for(int i=n-2; i>=0; i--){
            maxRigth[i]=Math.max(maxRigth[i+1],rigthSum[i]);
        }
        int [] leftSum =new int[n];
        leftSum[0]=arr[0];
        for(int i=1; i<n; ++i){
            leftSum[i] = leftSum[i-1] + arr[i];
        }
        for(int i =0; i<n-2; i++){
            answer=Math.max(answer,leftSum[i] + maxRigth[i+2]);
        }
        return answer;
    }
}
