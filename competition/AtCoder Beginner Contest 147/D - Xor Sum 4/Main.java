import java.util.*;
import java.io.*;

public class Main {

	private static void solve(){
		//Implement solution here.
		int n = ni();
		long[] la = nal(n);
		long[] da = new long[60];
		long result = 0;
		for(int i = 0; i < n; i++) {
			char[] ca = Long.toBinaryString(la[i]).toCharArray();
			for(int j = 0; j < ca.length;j++) {
				if(ca[ca.length - 1 - j] == '1')da[j]++;
			}
		}

		for(int i = 0; i < da.length; i++) {
			final long l = (long)Math.pow(2, i) % mod;
			final long i1 = da[i] * (n - da[i]) % mod;
			result += (l * i1) % mod;
            result %= mod;
		}
		System.out.println(result);
	}
	
	static int mod = 1000000007;


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