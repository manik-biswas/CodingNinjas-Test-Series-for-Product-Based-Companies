

public class Solution {

	public static int largestNumber(int[] arr, int n) {
	int ans =-1;
	for(int i=0; i<n; i++){
		int current=arr[i];
		for(int j=i+1; j<n; j++){
			if(arr[j] == -1*current){
				ans = Math.max(ans , Math.abs(current));
			}
		}
	}
	return ans;
	}

}
