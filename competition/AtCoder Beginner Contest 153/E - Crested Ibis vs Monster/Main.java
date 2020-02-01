import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int H = ni();
		int N = ni();
		int[] A = new int[N];
		int[] B = new int[N];
		double maxe = 0;
		int maxidx = -1;
		
		for(int i = 0; i < N; i++) {
			A[i] = ni();
			B[i] = ni();
		}
		
		int[] dp = new int[H + 1];
		dp[0] = 0;
		
		for(int i = 0; i <= H; i ++) {
			if(i > 0 && dp[i] == 0)continue;
			for(int j = 0; j < N; j++) {
				int next = i + A[j];
				if(next > H) next = H;
				dp[next] = dp[next] == 0 ? dp[i] + B[j] : Math.min(dp[next], dp[i] + B[j]);
			}
		}
		System.out.println(dp[H]);
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
