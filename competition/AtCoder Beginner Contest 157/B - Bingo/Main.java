import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int[][] map = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = ni();
			}
		}
		int N = ni();
		for(int k = 0; k < N; k++) {
			int tmp = ni();
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(map[i][j] == tmp)map[i][j] = 0;
				}
			}
		}
		
		//H
		for(int i = 0; i < 3; i++) {
			if(map[i][0] == 0 && map[i][1] == 0 && map[i][2] == 0) {
				System.out.println("Yes");
				return;
			}
		}
		//V
		for(int i = 0; i < 3; i++) {
			if(map[0][i] == 0 && map[1][i] == 0 && map[2][i] == 0) {
				System.out.println("Yes");
				return;
			}
		}
		//Slash
		if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0) {
			System.out.println("Yes");
			return;
		}
		if(map[0][2] == 0 && map[1][1] == 0 && map[2][0] == 0) {
			System.out.println("Yes");
			return;
		}
		
		System.out.println("No");
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
