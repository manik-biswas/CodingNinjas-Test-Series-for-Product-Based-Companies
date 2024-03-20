

import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static int help(int i, int j, int[] arr){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;

        }
        if(arr[i] != arr[i+1]){
            int  ans = 1 + help(i+1, j, arr);
            for(int k=i+1; k<=j; k++){
                if(arr[i] == arr[k]){
                    ans = Math.min(ans, help(i+1, k-1, arr) + help(k+1, j, arr));
                }
            }
            return ans;
        }
        else {
            int ans = 1+help(i+1, j, arr);
            ans = Math.min(ans, 1+help(i+2, j, arr));
            for(int k=i+2; k<=j; k++){
                if(arr[i] == arr[k]){
                    ans = Math.min(ans, help(i+1, k-1, arr) +  help(k+1, j, arr));
                }
            }
            return ans;
        }
    }
    public static int takeAwayTheBottle(int [] arr, int n){
        return help(0, n-1, arr);
    }
}




