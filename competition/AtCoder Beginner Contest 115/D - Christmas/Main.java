import java.util.*;
import java.io.*;

public class Main {
	static long[] a;
	static long[] p;
	private static void solve(){
		//Implement solution here.
		int n = ni();
		long k = nl();
		a = new long[n];
		p = new long[n];
		a[0] = 1;
		p[0] = 1;
		for(int i = 1; i < n; i++) {
			a[i] = a[i - 1] * 2 + 3;
			p[i] = p[i - 1] * 2 + 1;
		}
		System.out.println(burger(n,k));		
	}

	static long burger(int n, long x) {
		
		if(n == 0) {
			System.out.println(n + " " + x);
			return x > 0 ? 1 : 0;
		}else if(x <= a[n - 1] + 1) {
			return burger(n - 1, x - 1);
		} else {
			return p[n - 1] + burger(n - 1, x - a[n - 1] - 2) + 1;
		}
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
