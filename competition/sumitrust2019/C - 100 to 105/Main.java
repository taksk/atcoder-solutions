import java.util.*;
import java.io.*;

public class Main {
	private static int[] goods = {100,101,102,103,104,105};
	private static void solve(){
		//Implement solution here.
		int x = ni();
		int result = rec(x,0);
		System.out.println(result > 0 ? 1 : 0);
	}
	
	private static int rec(int rest, int idx) {		
		if(idx > 5)return 0;
		if(rest%goods[idx] == 0) return 1;
		int tmp = 0;
		int result = 0;
		while(rest - tmp >= 0) {			
			if(rec(rest - tmp, idx + 1) > 0)return 1;
			tmp += goods[idx];
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