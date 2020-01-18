import java.util.*;
import java.io.*;
/**
 * Search shortest distance on grid with BFS.
 */
public class BFS {
	private static char[][] s;
	private static int h;
	private static int w;
	private static void solve(){
		//Implement solution here.
		h = ni();
		w = ni();
		s = new char[h][w];
		for(int i = 0; i < h; i++) s[i] = next().toCharArray();
		int result = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(s[i][j] == '#')continue;
				int[][] dmap = new int[h][w];
				for(int[] ia:dmap)Arrays.fill(ia, Integer.MAX_VALUE);
				
				//BFS
				Queue<String> q = new ArrayDeque<String>();//Create queue for storing request arguments
				q.add(i + ":" + j + ":0");//Add request arguments
				while(!q.isEmpty()) {
					String[] args = q.poll().split(":");
					//Call method with queued arguments
					distance(dmap,Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),q);
				}
				
				
				result = Math.max(result, maxDistance(dmap));
			}
		}
		System.out.println(result);
	}
	
	/**
	 * Check whether cursor can move to up/down/right/left
	 * If cursor can move to, This method add recursive method call request to the queue
	 * @param dmap Map for storing distance from start point
	 * @param y Y axis coordinate
	 * @param x X axis coordinate
	 * @param steps Steps from start point
	 * @param q Queue stores request arguments
	 */
	private static void distance(int[][] dmap, int y, int x, int steps,Queue<String> q){
		if(dmap[y][x] <= steps) {
			return;
		} else {
			dmap[y][x] = steps;
		}
		
		//up
		if(y - 1 > -1 && s[y - 1][x] == '.' && dmap[y - 1][x] > steps + 1) {
			q.add((y - 1) + ":" + x + ":" + (steps + 1));//Add recursive call arguments to the queue
		}
		//right
		if(x + 1 < w && s[y][x + 1] == '.' && dmap[y][x + 1] > steps + 1) {
			q.add(y + ":" + (x + 1) + ":" + (steps + 1));
		}
		//down
		if(y + 1 < h && s[y + 1][x] == '.' && dmap[y + 1][x] > steps + 1) {
			q.add((y + 1) + ":" + x + ":" + (steps + 1));
		}
		//left
		if(x - 1 > - 1 && s[y][x - 1] == '.' && dmap[y][x - 1] > steps + 1) {
			q.add(y + ":" + (x - 1) + ":" + (steps + 1));
		}
	}

	private static int maxDistance(int[][] dmap){
		int result = 0;
		for(int[] ia:dmap) {
			for(int i:ia) {
				if(i == Integer.MAX_VALUE)continue;
				result = Math.max(result, i);
			}
		}
		return result;
	}


	public static void main(String[] args){
		solve();
	}
}
