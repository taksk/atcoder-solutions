import java.util.*;
import java.io.*;

public class Main {
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
				
				Queue<String> q = new ArrayDeque<String>();
				q.add(i + ":" + j + ":0");
				while(!q.isEmpty()) {
					String[] args = q.poll().split(":");
					distance(dmap,Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),q);
				}
				result = Math.max(result, maxDistance(dmap));
			}
		}
		System.out.println(result);
	}
	
	private static void distance(int[][] dmap, int y, int x, int steps,Queue<String> q){
		if(dmap[y][x] <= steps) {
			return;
		} else {
			dmap[y][x] = steps;
		}
		
		//up
		if(y - 1 > -1 && s[y - 1][x] == '.' && dmap[y - 1][x] > steps + 1) {
			q.add((y - 1) + ":" + x + ":" + (steps + 1));
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


	//Switch input source (stdin/file)
	private static BufferedReader br;
	public static void main(String[] args){
		br = new BufferedReader(new InputStreamReader(System.in));
		String debugDataPath = System.getenv("DD_PATH");        
		if(debugDataPath != null){
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(debugDataPath))));
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		solve();
	}

	//Input read utility
	private static StringTokenizer tokenizer = null;
	public static String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	//Get next single int
	private static int ni() {
		return Integer.parseInt(next());
	}
	//Get next single long
	private static long nl() {
		return Long.parseLong(next());
	}
	//Get next single double
	private static double nd() {
		return Double.parseDouble(next());
	}
	//Get next int array from one line
	private static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	//Get next char array from one line
	private static char[] ns() {
		return next().toCharArray();
	}
	//Get next long array from one line
	private static long[] nal(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
	}
}
