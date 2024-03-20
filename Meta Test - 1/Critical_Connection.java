import java.util.ArrayList;

public class Solution {
        private static void dfs(int s, ArrayList<ArrayList<Integer>>  ans, int p, ArrayList<Integer> disc, ArrayList<Integer>low, ArrayList<Integer>visited, ArrayList<ArrayList<Integer>> graph, int timer){
            visited.set(s,1);
            timer++;
            disc.set(s,timer);
            low.set(s,timer);
            for(int i=0; i<graph.get(s).size();i++){
                int adj=graph.get(s).get(i);
                if(visited.get(adj)==0){
                    dfs(adj,ans,s,disc,low,visited,graph,timer);
                    low.set(s,Math.min(low.get(adj),low.get(s)));
                    if(low.get(adj)>disc.get(s)){
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        temp.add(s);
                        temp.add(adj);
                        ans.add(temp);
                    }
                }
                else if(adj!=p);
                low.set(s,Math.min(low.get(adj),low.get(s)));
            }
        }
     return;
    }
    public static ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> connections){
        int timer = 0;
        ArrayList <Integer> disc= new ArrayList<Integer>(n);
        ArrayList<Integer> low= new ArrayList<Integer>(n);
        ArrayList<Integer> visited = new ArrayList<Integer>(n);
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int m = connections.size();
        for(int i=0; i<m; i++){
            int u = connections.get(i).get(0);
            int v= connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n;i++){
            disc.add(0);
            low.add(Integer.MAX_VALUE);
            visited.add(0);
        }
        for(int i=0; i<n;i++){
            if(visited.get(i)==0){
                dfs(i,ans,-1,disc,low,visited,graph,timer);
            }
        }
        return ans;
     }
 }
