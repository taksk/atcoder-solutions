import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int n = ni();
		int m = ni();		
		boolean[] broken = new boolean[n + 1];
		for(int i = 0; i < m; i++) {
			broken[ni()] = true;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		int mod = 1000000007;
		
		if(n <= 1) {
			System.out.println(1);
		}else {
			dp[1] = broken[1] ? 0 : 1;
			for(int i = 2; i < n; i++) {
				dp[i] = broken[i] ? 0 : ((dp[i - 2]%mod) + (dp[i - 1]%mod))%mod;
			}
			System.out.println(((dp[n - 2]%mod) + (dp[n - 1]%mod))%mod);
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