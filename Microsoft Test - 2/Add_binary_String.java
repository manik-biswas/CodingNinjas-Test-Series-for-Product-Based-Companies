public class Solution 
{
	public static String addBinaryString(String a, String b, int n, int m)
	{
		StringBuilder sum = new StringBuilder();
		int i=0;
		int carry=0;
		while(i<Math.max(n,m)){
			int curSum=carry;
			if(i<n){
				curSum=curSum+(a.charAt(n-1 -i) -'0');
			}
			if(i<m){
				curSum=curSum+(b.charAt(m-1-i) -'0');
			}
			sum.append((curSum)%2);
			carry=curSum/2;
			i++;
		}
		if(carry != 0){
			sum.append(1);
		}
		return sum.reverse().toString();
	}
}
