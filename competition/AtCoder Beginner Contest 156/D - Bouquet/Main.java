import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int a = ni();
		int b = ni();
		long result = power(2, n) - 1;
		result = ((result - combiWithMod(n, a)) % mod + mod) % mod;
		result = ((result - combiWithMod(n, b)) % mod + mod) % mod;
		System.out.println(result);
	}



	static int mod = 1000000007;

	/**
	 * nCk with mod calculation. "mod" is instance variable.
	 * @param n
	 * @param k
	 * @return nCk with mod calculation.
	 */
	static long combiWithMod(int n, int k) {
		long[] x = new long[k];
		long[] y = new long[k];
		x[0] = n;
		y[0] = k;
		for(int i = 1; i < k; i++) {
			x[i] = (x[i - 1] * (n - i)) % mod; 
			y[i] = (y[i - 1] * (k - i)) % mod; 
		}
		return modMul(x[k - 1], modInverse(y[k - 1]));
	}
	/**
	 * Mod multiply calculation
	 * @param a
	 * @param b
	 * @return
	 */
	static long modMul(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
	}
	static long modInverse(long n) {
		return power(n, mod-2);
	}
	static long power(long a, long b) {
		long result = 1;
		a = a % mod;
		while (b > 0) {
			if (b % 2 == 1)
				result = (result * a) % mod;
			b = b >> 1;
			a = (a * a) % mod;
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
