import java.util.LinkedList;
import java.util.Queue;
public class Solution {
	private static final int[][] dirs = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
	public static class pair<T, E>{
		T first;
		E second;
		pair(){

		}
		pair(T first, E second){
			this.first= first;
			this.second = second;
		}
	}
    public static int minPushes(int m, int n, char[][] grid) {
		pair<Integer,Integer>box = new pair<Integer,Integer>();
		pair<Integer,Integer> player = new pair<Integer,Integer>();
		for(int i = 0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j]=='B'){
					box.first=i;
					box.second=j;
				}
				else if(grid[i][j]=='P'){
					player.first=i;
					player.second=j;
				}
			}
		}
		Queue<pair<pair<Integer,Integer>,pair<Integer,Integer>>> queue = new LinkedList<>();
		queue.add(new pair<>(box,player));
		boolean visited[][] = new boolean[m*n][m*n];
		visited[box.first*n+box.second][player.first*n+player.second] = true;
		int push = 0;
		while(!queue.isEmpty()){
			push++;
			for(int i = queue.size()-1;i>=0;i--){
				pair<pair<Integer,Integer>,pair<Integer,Integer>>state = queue.poll();
				pair<Integer,Integer>b= state.first,p=state.second;
				for(int j=0; j<dirs.length;j++){
					pair<Integer,Integer>nb = new pair<Integer,Integer>(b.first+dirs[j][0],b.second+dirs[j][1]);
				if(nb.first>=0 && nb.first<n && nb.second>=0 && nb.second<n && grid[nb.first][nb.second] !='|'){
					pair<Integer,Integer>np=new pair<>(b.first - dirs[j][0], b.second - dirs[j][1]);
					if(np.first>= 0 && np.first< m && np.second>=0 && np.second< n 
					&& grid[np.first][np.second] !='|' 
					&& !visited[nb.first*n+nb.second][np.first*n+np.second]){
						if(isReachable(grid,m,n,b,p,np)){
							if(grid[np.first][np.second]=='T'){
								return push;
							}
							visited[nb.first*n+nb.second][np.first*n +np.second]= true;
							queue.add(new pair<>(nb,b));
						}
					}
				}	
				}
			}
		}
		return -1;
	}
	private static boolean isReachable(char[][]grid, int m, int n ,pair<Integer,Integer>box,pair<Integer,Integer>from,pair<Integer,Integer>to){
		Queue<pair<Integer,Integer>>queue= new LinkedList<>();
		queue.add(from);
		boolean [][]visited= new boolean[m][n];
		visited[from.first][from.second]= true;
		while(!queue.isEmpty()){
			pair<Integer,Integer>loc=queue.poll();
			if(loc.first==to.first&&loc.second==to.second){
				return true;
			}
			for(int j=0; j<dirs.length; j++){
				int nr = loc.first+dirs[j][0], nc = loc.second+dirs[j][1];
				if(nr >=0 && nr < m && nc >=0 && nc < n && !visited[nr][nc] 
				&& grid[nr][nc] != '|'
				&& (nr!=box.first || nc != box.second)){
					visited[nr][nc]=true;
					queue.add(new pair<>(nr,nc));
				}
			}
		}
		return false;
	}

}
