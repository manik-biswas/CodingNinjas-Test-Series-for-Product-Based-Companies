import java.util.HashSet;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		int ans = 0;
		for(int i=0; i<str.length(); i++){
			HashSet<Character>uniqueChars = new HashSet<>();
			for(int j=i; j<str.length(); j++){
				uniqueChars.add(str.charAt(j));
				if(uniqueChars.size() > k){
					break;
				}
				ans = Math.max(ans, j-i+1);
			}
		}
		return ans;
	}

}
