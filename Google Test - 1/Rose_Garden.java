public class Solution {
    public static int roseGarden(int n, int[] arr, int r, int b) {
        if(r*b > n){
            return -1;
        }
        int days=1;
        while(true){
            int cntR=0, cntB=0;
            for(int i=0; i<n; i++){
                if(arr[i]<=days){
                    cntR++;
                }
                else{
                    cntR =0;
                }
                if(cntR == r){
                    cntB++;
                    cntR=0;
                }
            }
            if(cntB>=b){
                return days;
            }
            days++;
        }
    }
}