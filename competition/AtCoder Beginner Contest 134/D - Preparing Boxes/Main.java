import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		int boxcnt = 0;
		for(int i = 1; i <= n; i++) {
			a[i] = ni();
		}		

		for(int i = n; i > 0; i--) {
			int ballcnt = 0;
			for(int j = 2 * i; j <= n; j += i) {
				ballcnt += b[j];
			}
			if(ballcnt % 2 != a[i]) {
				b[i]++;
			}
			if(b[i] > 0)boxcnt++;
		}

		System.out.println(boxcnt);
		for(int i = 1; i <= n; i++) {		
			if(b[i] > 0) {
				System.out.print(i + " ");
			}
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
