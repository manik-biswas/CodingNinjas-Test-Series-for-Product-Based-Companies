public class Solution {
    public static int fourSum(int n, int[] arr1, int[] arr2, int[] arr3, int[] arr4)
    {
         // Write your code here.
         int ans = 0;
         for(int i = 0; i < n; i++){
             for(int j = 0; j < n; j++){
                 for(int k = 0; k < n; k++){
                     for(int l = 0; l < n; l++){
                         if(arr1[i] + arr2[j] + arr3[k] + arr4[l] == 0){
                             ans += 1;
                         }
                     }
                 }
             }
         }
         return ans;
    }
}

