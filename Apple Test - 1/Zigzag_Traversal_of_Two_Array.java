import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> zigzagTraversal(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        // Write your code here.
        int n=arr1.size();
        int m=arr2.size();
        int [] result = new int [n+m];
        int p=0, q=0;
        for(int i =0; i<n+m; i++){
            if(p==n){
                result[i]=arr2.get(q);
                q++;
            }
            else if(q==m){
                result[i]=arr1.get(p);
                p++;
            }
            else{
                if(i%2==0){
                    result[i]=arr1.get(p);
                    p++;
                }
                else{
                    result [i]=arr2.get(q);
                    q++;
                }
            }
        }
        ArrayList<Integer>sol=new ArrayList<>();
        for(int i : result){
            sol.add(i);
        }
        return sol;
    }
}