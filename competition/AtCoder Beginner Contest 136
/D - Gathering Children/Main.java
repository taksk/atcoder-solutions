import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		String s = next();
		int n = s.length();
		char[] lr = s.toCharArray();
		int[] d = new int[n];
		int[] result = new int[n];
		//distance to last r.
		int tmp = 0;
		for(int i = 0; i < n; i++) {
			if(lr[i] == 'L') {
				tmp++;
				d[i] = tmp; 
			} else {
				tmp = 0;
			}
		}
		//distance to next l
		tmp = 0;
		for(int i = n-1; i >= 0; i--) {
			if(lr[i] == 'R') {
				tmp++;
				d[i] = tmp; 
			} else {
				tmp = 0;
			}
		}
		
		//result children count
		for(int i = 0; i < n; i++) {
			if(lr[i] == 'R') {
				if(d[i] % 2 == 0) {
					result[i + d[i]]++;
				} else {
					result[i + d[i] - 1]++;
				}
			} else {
				if(d[i] % 2 == 0) {
					result[i - d[i]]++;
				} else {
					result[i - d[i] + 1]++;
				}
			}
		}
		Arrays.stream(result).forEach(v -> System.out.print(v + " "));
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