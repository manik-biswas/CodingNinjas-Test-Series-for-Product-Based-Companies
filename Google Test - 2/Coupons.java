  

public class Solution {

	public static int pickCoupons(int n, int[] coupons) {
	 	int minDistance=n+1;
		 for(int i=0; i<n; i++){
			 for(int j=i+1; j<n; j++){
				 if(coupons[i]==coupons[j]){
					 minDistance=Math.min(minDistance,j-i+1);
					 break;
				 }
			 }
		 }
		 return minDistance==n+1?-1:minDistance;
	}

}
