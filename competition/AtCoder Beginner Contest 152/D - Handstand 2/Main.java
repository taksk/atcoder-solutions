import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		long N = nl();
		long result = 0;
		long i = 0;
		while(i + 1 <= N) {
			i++;			
			long h = i;
			while(h / 10 > 0)h /= 10;

			long b = i % 10;			
			if(b == 0)continue;
			if(h == b)result++;
			for(int j = 1; j < 6; j++) {
				if(b * longPow(j) + h > N)continue;
				if((b + 1) * longPow(j) + h <= N) {
					result += longPow(j - 1);					
				} else {
					long tmp = b * longPow(j) + h;
					if(tmp <= N)result++;
					while(tmp + 10 <= N) {						
						result++;
						tmp += 10;
					}
				}
			}
		}
		System.out.println(result);
	}

	static long longPow(int i) {
		return (long)Math.pow(10, i);
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
