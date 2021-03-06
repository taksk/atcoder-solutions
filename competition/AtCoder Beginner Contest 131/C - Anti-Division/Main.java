import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		long a = nl();
		long b = nl();
		long c = nl();
		long d = nl();
		long lcm = lcm(c,d);

		long result = b - a + 1; 
		result -= countDiv(a, b, c);
		result -= countDiv(a, b, d);
		result += countDiv(a, b, lcm);
		System.out.println(result);		
	}

	static long countDiv(long a, long b, long t) {		
		long result = 0;
		if(a > 0) {
			result = b / t - (a - 1) / t; 
		} else {
			result = b / t;
		}
		return result;
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