public class Solution {
    public static boolean isPossible(char[] str){
        if(str[0] > '2'){
            return false;
        }
        if(str[0] == '2' && str[1] > '3'){
            return false;
        }
        if(str[3] > '5'){
            return false;
        }
        return true;
    }

    public static void findMax(char[] str, char[] res){
        for(int i=0; i<5; ++i){
            if(str[i] >  res[i]){
               for(int j=0; j<5; j++){
                   res[j] = str[j];
               }
               return; 
            }
            else if(str[i] < res[i]){
                return;
            }
        }
    }

    public static void helper(char[] str, char [] res, int idx){
        if(idx == 5){
            if(isPossible(str)){
                findMax(str, res);
            }
            return;
        }
        if(str[idx] !='#' || str[idx] == ':'){
            helper(str, res, idx +1);
        }
        else{
            for(int i=0; i<=9; i++){
                char[] nxt = str.clone();
                nxt[idx] = (char)(i +'0');
                helper(nxt, res, idx+1);
            }
        }
    }
   public static String maxTime(String str)
   {
        // Write your code here.

        char[] res ={'0','0',':','0','0'};
        int idx =0;
        helper(str.toCharArray(), res, idx);
        return new String(res);
   }
}

