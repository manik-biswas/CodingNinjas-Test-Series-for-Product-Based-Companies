import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static int countSwaps(String string) {
		char str[]= string.toCharArray();
		int n= string.length();
		HashMap<Character, Integer> d = new HashMap<>();
		for(int i=0; i<n; ++i){
			if(d.containsKey(str[i])){
				d.put(str[i], d.get(str[i]) +1);
			}
			else{
				d.put(str[i], 1);
			}
		}
		int count =0;
		ArrayList<Integer>vals = new ArrayList<>(d.values());
			for(int i : vals){
				if(i%2 != 0){
					++count;
				}
			}
			if(count>1){
				return -1;
			}
			count=0;
			int i=0; 
			int j= n-1;
			while(i<j){
				if(str[i] == str[j]){
					++i;
					--j;
				}
				else{
					int temp = j;
					while(str[temp] != str[i]){
						--temp;
					}
					if(temp ==i){
						char tempChar = str[temp];
						str[temp] = str[temp+1];
						str[temp + 1] = tempChar;
						++count;
					}
					else{
						for(int k=temp; k<j; ++k){
							char tempChar = str[k];
							str[k] = str[k+1];
							str[k+1] = tempChar;
							++count;
						}
						++i;
						--j;
					}
				}
			}
			return count;
	}

}
