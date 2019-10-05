import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.

		char[] s = next().toCharArray();
		char[] ds = new char[s.length * 2];
		System.arraycopy(s, 0, ds, 0, s.length);
		System.arraycopy(s, 0, ds, s.length, s.length);

		long k = (long)ni();
		long result = 0;

		long singlesum = 0;
		char stmp = s[0];			
		for(int i = 1; i < s.length; i++) {
			if(s[i] == stmp) {
				singlesum++;
				s[i] = '!';
			}
			stmp = s[i];
		}
		
		long doublesum = 0;
		char dtmp = ds[0];
		for(int i = 1; i < ds.length; i++) {
			if(ds[i] == dtmp) {
				doublesum++;
				ds[i] = '!';
			}
			dtmp = ds[i];
		}
		
		if(s[0] != s[s.length -1]) {
			result = singlesum * k;
		} else {
			if(ds[0] != ds[ds.length - 1]) {
				result = doublesum*(k/2);
				if(k % 2 != 0)result += singlesum;
			}else {
				result += (doublesum - singlesum) * (k - 1);
				result += singlesum;
			}
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