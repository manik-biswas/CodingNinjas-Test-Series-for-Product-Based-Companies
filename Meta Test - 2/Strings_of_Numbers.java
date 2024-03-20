import java.util.HashSet;
public class Solution {
    static StringBuilder answer= new StringBuilder();
    static HashSet<String>visited = new HashSet<String>();
    static boolean dfs (int n, int k){
        if(visited.size()==(int)Math.pow((k + 1), n)){
            return true;
        }
        for(int i =0; i<k; i++){
            String currNode = answer.substring(answer.length()-n+1);
            currNode +=((char)(i+'0'));
            if(!visited.contains(currNode)){
                visited.add(currNode);
                answer.oppend((char)(i+'0'));
                if(dfs(n.k)==true){
                    return true;
                }
                answer.setLength(answer.length()-1);
                visited.remove(currrNode);
            }
        }
        return false;
    }
    public static String getMinString(int n, int k) {
        // Write your code here.
        answer = new StringBuilder();
        for(int i = 0; i<n; i++){
            answer.append('0');
    }
    visited= new HashSet<String>();
    visited.add(answer.toString());
    defs (n,k);
    return answer.toString();

            }

}