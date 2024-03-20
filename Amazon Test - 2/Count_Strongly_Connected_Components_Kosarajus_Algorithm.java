import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	public static Stack <Integer> stk;
	public static ArrayList <Boolean> visited;
	public static void dfs (int u , ArrayList<ArrayList<Integer>> graph){
		if(visited.get(u) ==true){
			return;
		}
		visited.set(u, true);
		int edges = graph.get(u).size();
		for(int i=0; i<edges; i++){
			int v = graph.get(u).get(i);
			dfs(v, graph);
		}
	return;
	} 
	public static ArrayList<ArrayList<Integer>>getTranspose(int vertices, ArrayList<ArrayList<Integer>>graph){
		ArrayList<ArrayList<Integer>> transposeGraph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++){
			transposeGraph.add(new ArrayList<>());
		}
		for(int i=0; i<vertices; i++){
			int edges=graph.get(i).size();
			for(int j=0; j<edges; j++){
				int u=graph.get(i).get(j);
				transposeGraph.get(u).add(i);
			}
		}
		return transposeGraph;
	}
	public static void dfsToFindFineshTime(int u, ArrayList<ArrayList<Integer>> graph){
		if(visited.get(u) == true){
			return;
		}
		visited.set(u, true);
		int edges=graph.get(u).size();
		for(int i=0; i<edges; i++){
			int v= graph.get(u).get(i);
			dfsToFindFineshTime(v, graph);
		}
		stk.push(u);
		return;
	}

	public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>>graph = new ArrayList<>(v);
		for(int i=0; i<v; i++){
			graph.add(new ArrayList<Integer>());
		}
		int e = edges.size();
		for(int i=0; i<e; i++){
			int a= edges.get(i).get(0);
			int b= edges.get(i).get(1);
			graph.get(a).add(b);
		}
		stk = new Stack<>();
		visited = new ArrayList<>(v);
		for(int i=0; i< v;i++){
			visited.add(false);
		}
		for(int i=0; i<v; i++){
			if(visited.get(i)==false){
				dfsToFindFineshTime(i, graph);
			}
		}
		ArrayList<ArrayList<Integer>>transposeGraph = getTranspose(v, graph);
		for(int i=0; i<v; i++){
			visited.set(i, false);
		}
		int count = 0;
		while(stk.isEmpty() == false){
			int node = stk.peek();
			stk.pop();
			if(visited.get(node) == false){
				dfs(node, transposeGraph);
				++count;
			}
		}
		return count;
	}
}