public class Solution {

	private static boolean canPartitionKSubsetsHelper(int [] nums, int k, boolean[] vis, int targetSubsetSum, int curSubsetSum, int checkIdx){
		if(k==0){
			return true;
		}
		
			if(curSubsetSum == targetSubsetSum){
			return canPartitionKSubsetsHelper(nums, k-1, vis, targetSubsetSum,0,0);
		}
		for(int i=checkIdx; i<nums.length; i++){
			if(vis[i] == false && curSubsetSum + nums[i] <= targetSubsetSum){
				vis[i]=true;
				if(canPartitionKSubsetsHelper(nums, k, vis, targetSubsetSum, curSubsetSum +nums [i], i+1)){
					return true;
				}
				vis[i] = false;
			}
		}
		return false;
	}
	public static boolean canPartitionKSubsets(int[] nums, int n, int k) {
		int sum =0; 
		int maxNum=0;
		for(int i=0; i<nums.length; i++){
			sum +=nums[i];
			maxNum = Math.max(maxNum, nums[i]);
		}
		
			if (sum % k != 0 || maxNum > sum / k){	
			return false;
		}
		boolean[] vis= new boolean[n];
		return canPartitionKSubsetsHelper(nums, k, vis, sum / k, 0, 0);

	}
}
