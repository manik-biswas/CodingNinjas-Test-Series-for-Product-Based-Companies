import java.util.HashMap;
import java.util.HashSet;
class Ans{
    char[] ans;

    public Ans(){
        this.ans=null;
    }
}

public class Solution{
    public static char[] getAlienLanguage(int n, String[] dictionary){
        HashSet<Character> set = new HashSet<>();
        for(String str : dictionary){
            for(int i=0; i<str.length(); i++){
                set.add(str.charAt(i));
            }
        }
        if(set.isEmpty()){
            return new char[0];
        }
        StringBuilder str1 = new StringBuilder();
        for(Character ch : set){
            str1.append(ch);
        }
        Ans ans = new Ans();
        findPermutations(dictionary, str1.toString().toCharArray(),0,set.size()-1,ans);
        return ans.ans;
    }
    private static void findPermutations(String[] words, char[] str, int start, int end, Ans ans){
        if(start == end){
            if(satisfiesAlienLanguage(words, str)){
                ans.ans = new String(str).toCharArray();

            }
        }
        else{
            if(ans.ans == null){
                for(int i= start; i<=end; i++){
                    char temp = str[start];
                    str[start] = str[i];
                    str[i] = temp;
                    findPermutations(words, str, start +1, end, ans);
                    temp =str[start];
                    str[start] = str[i];
                    str[i]=temp;
                }
            }
        }
    }
    private static boolean satisfiesAlienLanguage(String[] words, char[] arr){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
            }
        }
        outer:
        for(int i=0; i< words.length -1; i++){
            String currWord = words[i];
            String nextWord = words[i+1];

            for(int j=0; j< Math.min(currWord.length(), nextWord.length()); j++){
                if(currWord.charAt(j) != nextWord.charAt(j)){
                    if(!map.containsKey(currWord.charAt(j)) || !map.containsKey(nextWord.charAt(j)) ||
                    map.get(nextWord.charAt(j)) < map.get(currWord.charAt(j))){
                        return false;
                    }
                    else{
                        continue outer;
                    }
                }
            }
            if(currWord.length() > nextWord.length()){
                return false;
            }
        }
        return true;
    }
}