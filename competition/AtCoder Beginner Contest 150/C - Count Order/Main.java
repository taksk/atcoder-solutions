import java.util.*;
import java.io.*;

public class Main {

	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[] p = na(n);
		int[] q = na(n);
		System.out.println(Math.abs(count(n,p) - count(n,q)));
	}
	
	private static int count(int n, int[] a) {
		int[] factorial = {0,1,2,6,24,120,720,5040};
		int usedcnt = 0;
		boolean[] used = new boolean[n];
		int result = 1;
		for(int ai:a) {
			int cnt = 0;
			used[ai - 1] = true;
			usedcnt++;
			for(int i = 0; i < ai; i++)if(!used[i])cnt++;
			result += cnt * factorial[n - usedcnt];
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