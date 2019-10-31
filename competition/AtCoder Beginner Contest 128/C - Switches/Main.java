import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int m = ni();
		int[][] map = new int[m][];
		for(int i = 0; i < m; i++) {
			int k = ni();
			map[i] = new int[k];
			for(int j = 0; j < k; j++) {
				map[i][j] = ni();
			}
		}
		int[] p = na(m);
		int result = 0;
		
		int max = (int)Math.pow(2, n);
		for(int i = 0; i < max; i++) {
			boolean isMatch = true;
			char[] ca = String.format("%0" + n + "d",Integer.parseInt(Integer.toBinaryString(i))).toCharArray();
			for(int j = 0; j < m; j++) {
				int k = map[j].length;
				int cnt = 0;
				for(int l = 0; l < k; l++) {
					if(ca[map[j][l] - 1] == '1') {
						cnt++;
					}
				}
				if(cnt % 2 == p[j]) {
					continue;
				} else {
					isMatch = false;
					break;
				}
			}
			result += isMatch ? 1:0;
		}
		System.out.println(result);
	}

	//Switch input source (stdin/file)
	private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args){
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