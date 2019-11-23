import java.util.*;
import java.io.*;

public class Main {
	static long mod = 1000000007;
	private static void solve(){
		//Implement solution here.
		int n = ni();
		long result = 0;
		Map<String,Long> map = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			long c1 = 1;
			long c2 = 1;
			long qmax = n / i;
			long q = 1;
			for(int j = 0; j < 10; j++) {
				c1 = modMul(c1, i);
				c2 = modMul(c2, i - 1);
				q = modMul(q,qmax);
			}
			result = modSum(result,modMul(modSum(c1 , -c2),q));
		}
		System.out.println(result > 0 ? result: result + mod);
	}

	static long modSum(long a, long b) {
		return (a % mod + b % mod) % mod;
	}
	static long modMul(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
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