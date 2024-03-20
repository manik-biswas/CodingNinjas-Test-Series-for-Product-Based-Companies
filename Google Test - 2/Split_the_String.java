

public class Solution{
	public static int splitString(String s){
		int ans=0;
		for(int i=0; i<=(s.length()-2); i++){
			int [] freqX=new int [26];
			int [] freqY=new int [26];
			for(int j=0; j<26; j++){
				freqX[j]=0;
				freqY[j]=0;
			}
			int cntX=0, cntY=0;
			for(int j=0; j<s.length(); j++){
				if(j<=i){
					if(freqX[s.charAt(j)-'a']==0){
						freqX[s.charAt(j)-'a']=1;
						cntX++;
					}
				}
				else {
					if(freqY[s.charAt(j)-'a']==0){
						freqY[s.charAt(j)-'a']=1;
						cntY++;
					}
				}
			}
			if(cntX==cntY){
				ans++;
			}
		}
		return ans;
	}
}