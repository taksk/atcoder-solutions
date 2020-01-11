import java.util.*;
import java.io.*;

public class Main {

	private static void solve(){
		//Implement solution here.
		int n = ni();
		int m = ni();
		long[] a = nal(n);
		
		
		int[] div2 = new int[n];
		long result = 0;
		for(int i = 0; i < n; i++)a[i] /= 2;
		for(int i = 0; i < n; i++) {
			long tmp = a[i];
			while(tmp %2 == 0) {
				div2[i]++;
				tmp /= 2;
			}
			if(i > 0 && div2[i] != div2[i - 1]) {
				System.out.println(0);
				return;
			}
		}
		long lcm = 1;
		for(int i = 0; i < n; i++) {
			lcm = lcm(lcm,a[i]);
		}

		result = m / lcm;
		result = result % 2 == 1 ? result / 2 + 1 : result / 2;
		System.out.println(result);
	}
	
	//Find greatest common divisor
	static long gcd (long a, long b) {
		return b > 0 ? gcd(b, a%b) : a;
	}
	//Find least common multiple
	static long lcm (long a, long b) {
		return a * b / gcd(a, b);
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