 

 
import java.util.HashSet;
public class Solution {
	private static int dfs(String [] strings, String currString, int position){
		HashSet<Character> st = new HashSet<>();
		for(int i=0; i<currString.length(); i++){
			char ch = currString.charAt(i);
			st.add(ch);
		}
		if(st.size() != currString.length()){
			return 0;
		}
		int res= currString.length();
		for(int currPos = position; currPos<strings.length; currPos++){
			String str = strings[currPos];
			res = Math.max(res, dfs(strings,str + currString, currPos +1));
		}
		return res;
	}
	public static int stringConcatenation(String[] arr) {
		String str ="";
		return dfs(arr, str, 0);

		// Write your code here
	}

}
