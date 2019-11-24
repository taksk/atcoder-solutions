import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		long a = nl();
		long b = nl();
		long x = nl();
		long maxval = 1000000000L;
		long tmp = 1L;
		while(x >= a*tmp + b*digit(tmp)) {
			tmp *= 10;
		}
		if(x < a*tmp + b*digit(tmp))tmp /= 10;
		long tmpv = a * tmp + b * digit(tmp);
		long result = tmp + (x - tmpv)/a;
		System.out.println(result > maxval || result < 0 ? maxval : result);		
	}

	static long digit(long l) {
		if(l == 0)return 1;
		long result = 0;
		while(l > 0) {
			result++;
			l /= 10;
		}
		return result;
	}
	
	//Switch input source (stdin/file)
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		String debugDataPath = System.getenv("DD_PATH");        
		if(debugDataPath != null){
			try{
				scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File(debugDataPath)))));
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
				tokenizer = new StringTokenizer(scanner.nextLine());
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