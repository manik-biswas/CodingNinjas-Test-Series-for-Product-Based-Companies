import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> sortBinaryArray(ArrayList<Integer> arr, int n) {
		//	Write your code here.
		int countZero = 0;
		for(int i : arr){
			if(i == 0){
				countZero++;
			}
		}
		for(int i = 0; i < n; i++){
			if(i < countZero){
				arr.set(i, 0);
			}
			else{
				arr.set(i, 1);
			}
		}
		return arr;
	}
}