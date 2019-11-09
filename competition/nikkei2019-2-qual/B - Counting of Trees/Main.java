import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[] d = na(n);
		long mod = 998244353L;
		
		if(d[0] > 0) {
			System.out.println(0);
			return;
		}
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		Arrays.sort(d);	
		
		if(d[1] == 0) {
			System.out.println(0);
			return;
		}

		long result = 1L;		
		int now = 0;
		long pcnt = -1L;
		long cnt = 1L;

		for(int i = 1; i < n; i++) {			
			if(d[i] == now) {
				cnt++;
			} else {
				if(d[i] == now + 1) {					
					if(pcnt > 0) {
						for(int j = 0; j < cnt; j++) {
							result = ((result % mod) * (pcnt % mod)) % mod;
						}											
					}
					now = d[i];
					pcnt = cnt;
					cnt = 1L;					
				} else {
					result = 0L;
					break;
				}
			}
		}

		for(int j = 0; j < cnt; j++) {
			result = ((result % mod) * (pcnt % mod)) % mod;
		}		
		System.out.println(result);
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