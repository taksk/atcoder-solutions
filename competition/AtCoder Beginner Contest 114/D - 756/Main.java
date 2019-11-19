import java.util.*;
import java.io.*;

public class Main {
	static int[] f = new int[101];
	static int n;
	private static void solve(){
		//Implement solution here.
		n = ni();
		int result = 0;
		f[1] = 1;
		for(int i = 2; i <= n; i++) {
			primeFactorization(i);						
		}

		for(int i = 2; i <= n; i++) {
			if(f[i] < 2)continue;
			if(f[i] >= 74)result++;
			for(int j = i + 1; j <= n;j++) {
				if(f[j] < 2)continue;			
				if(f[i] >= 24 && f[j] >= 2)result++;
				if(f[j] >= 24 && f[i] >= 2)result++;
				if(f[i] >= 14 && f[j] >= 4)result++;
				if(f[j] >= 14 && f[i] >= 4)result++;
				for(int k = j + 1; k <= n;k++) {
					if(f[k] < 2)continue;
					if(f[i] >= 2 && f[j] >= 4 && f[k] >= 4)result++;
					if(f[i] >= 4 && f[j] >= 2 && f[k] >= 4)result++;
					if(f[i] >= 4 && f[j] >= 4 && f[k] >= 2)result++;
				}
			}
		}
		System.out.println(result);
	}

	static int pattern(int cnt) {
		int result = 0;
		if(cnt <= 2) {

			for(int i = 2; i <= n; i++) {

			}
		}
		return result;
	}

	static void primeFactorization(int a){
		for(int i = 2; i <= Math.sqrt(a) + 1; i++) {
			if(a % i == 0) {
				while(a % i == 0) {
					f[i]++;
					a /= i;
				}		
			}				
		}
		if(a > 1) {
			f[a]++;
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
