import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int N = ni();
		int M = ni();		
		
		boolean[] da = new boolean[N + 1];
		int[] dv = new int[N + 1];
		boolean ok = true;
		for(int i = 0; i < M; i++) {
			int s = ni();
			int c = ni();
			if(!da[s]) {
				if(N > 1 && s == 1 && c == 0) {
					ok = false;
					break;
				}
				dv[s] = c;
				da[s] = true;
			} else {
				if(c == dv[s]) {
					continue;
				} else {
					ok = false;
					break;
				}
			}
		}
		
		if(ok) {
			int result = 0;
			if(N > 1 && !da[1])result += Math.pow(10, N - 1);
			for(int i = 1; i <= N; i ++) {
				result += dv[i] * Math.pow(10, N - i);
			}
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
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
