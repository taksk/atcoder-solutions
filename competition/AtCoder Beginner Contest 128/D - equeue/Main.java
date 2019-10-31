import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int k = ni();
		int[] v = na(n);
		int result = 0;
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i <= Math.min(n, k); i++) {
			for(int a = 0; a <= i; a++) {
				for(int oa = 1; oa <= a; oa++) {
					pq.add(v[oa - 1]);
				}				
				for(int ob = 1; ob <= i - a; ob++) {
					pq.add(v[n - ob]);
				}				
				int remcnt = k - i;
				while(!pq.isEmpty() && pq.peek() < 0 && remcnt > 0) {
					pq.poll();
					remcnt--;
				}
				int tmpresult = 0;
				while(!pq.isEmpty()) {
					tmpresult += pq.poll();
				}
				result = Math.max(result, tmpresult);
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