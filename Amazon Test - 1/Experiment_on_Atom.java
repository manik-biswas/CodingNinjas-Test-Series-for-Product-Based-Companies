import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static boolean bfs(HashMap < Integer, ArrayList < Integer >> graph, int s, boolean [] visited, int [] color){
		// write your code here

		visited[s] = true;
		color [s] = 1;
		Queue < Integer > q = new LinkedList <> ();
		q.add(s);
		while(q.size () != 0){
			int u = q.poll();
			if(graph.containsKey(u)){
				for(int v : graph.get(u)){
					if(visited[v] == false){
						if(v == u){
							return false;
						}
						visited[v] = true;
						color[v] = 1- color[u];
						q.add(v);
					}
					else if (color[u] == color[v]){
						return false;
					}
				}
			}
		}
		return true;
	}
	public static int isSuccessful(int n, int [][] interactions, int e){
		HashMap < Integer, ArrayList < Integer >> graph = new HashMap <> ();
		for(int i = 0; i < e; i++){
			int x = interactions[i][0];
			int y = interactions[i][1];
			x -=1;
			y -= 1;
			if(graph.containsKey(x)){
				graph.get(x).add(y);
			}
			else{
				ArrayList < Integer > list = new ArrayList <> ();
				list.add(y);
				graph.put(x,list);
			}
			if(graph.containsKey(y)){
				graph.get(y).add(x);
			}
			else{
				ArrayList < Integer > list = new ArrayList <> ();
				list.add(x);
				graph.put(y, list);
			}
		}
		boolean [] visited = new boolean [n];
		int [] color = new int [n];
		for(int u = 0; u < n; u++){
			if(visited[u] == false){
				boolean res = bfs (graph, u, visited, color);
				if(!res){
					return 0;
				}
			}
		}
		return 1;
	}
}