import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<String> getUsernames(int n, ArrayList<String> usernames)
    {
        ArrayList<String>database = new ArrayList < String >();
        for(int i=0; i<n; i++){
            if(!database.contains(usernames.get(i))){
                database.add(usernames.get(i));
                continue;
            }
            Integer count = 0;
            while(true){
                String check = usernames.get(i);
                check = check + count;
                if(!database.contains(check)){
                    database.add(check);
                    break;
                }
                count++;
            }
        }
        return database;
    }
}