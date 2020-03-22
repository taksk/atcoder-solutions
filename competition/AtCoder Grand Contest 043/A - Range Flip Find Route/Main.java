import java.util.*;
import java.io.*;

public class Main {	
	static int H;
	static int W;
	static char[][] grid;
	static int[][] minblack;
	private static void solve(){
		//Implement solution here.
		H = ni();
		W = ni();
		grid = new char[H][W];
		minblack = new int[H][W];
		for(int i = 0; i < H; i++) 	grid[i] = next().toCharArray();
		for(int i = 0; i < H; i++) 	Arrays.fill(minblack[i], -1);
		steps(0,0,0,false);
		System.out.println(minblack[H - 1][W - 1]);
	}

	private static void steps(int y, int x,int cnt,boolean bbefore) {
		if(grid[y][x] == '#' && !bbefore)cnt++;
		if(grid[y][x] == '#') {
			bbefore = true;
		} else {
			bbefore = false;
		}
		if(minblack[y][x] >= 0) {
			if(cnt >= minblack[y][x]) {
				return;
			}
		} 
		minblack[y][x] = cnt;
		//go right
		if(x < W - 1)steps(y,x + 1,cnt,bbefore);
		//go down
		if(y < H - 1)steps(y + 1,x,cnt,bbefore);		
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
		boolean hasNext = true;
		while(hasNext){
			solve();	
			try{
				br.mark(1);
				if(br.read() > 0){
					br.reset();			
					System.out.println("---");
				} else {
					hasNext = false;
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			} 
		}
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