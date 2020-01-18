import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] dif = new int[n];
		long asum = 0;
		long bsum = 0;
		for(int i = 0; i < n; i++) {
			int tmpa = ni();
			a[i] = tmpa;
			asum += tmpa;
		}
		for(int i = 0; i < n; i++) {
			int tmpb = ni();
			b[i] = tmpb;
			bsum += tmpb;
			dif[i] = a[i] - b[i];
		}
		
		int result = 0;
		long csum = asum - bsum;
		
		if(asum < bsum) {
			result = -1;
		} else {
			Arrays.sort(dif);
			for(int i = 0; i < n; i++) {
				if(dif[i] < 0) {
					result++;
				} else if(dif[i] == 0){
					continue;
				} else {
					if(dif[i] <= csum) {
						csum -= dif[i];
					} else {
						result++;
					}
				}
			}
		}		
		System.out.println(result);		
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
