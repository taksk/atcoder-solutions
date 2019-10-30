import java.util.*;


import java.io.*;

public class Main {
	static boolean[] c;
	static Map<Integer,Long>[] ma;
	@SuppressWarnings("unchecked")
	private static void solve(){
		//Implement solution here.
		int n = ni();
		c = new boolean[n + 1];
		ma = new HashMap[n + 1]; 
		for(int i = 0; i < n + 1; i++) {
			ma[i] = new HashMap<Integer,Long>();
		}

		for(int i = 0; i < n - 1; i++) {
			int u = ni();
			int v = ni();
			long w = nl();
			ma[u].put(v, w);
			ma[v].put(u, w);
		}
		
		dfs(0,1,0);
		for(int i = 1; i < n + 1; i++) {
			System.out.println(c[i] ? "0":"1");
		}
	}
	
	static void dfs(long wsum, int target, int before) {
		if(wsum %2 == 0) {
			c[target] = true;
		}
		for(int next:ma[target].keySet()) {
			if(next != before) {
				dfs(wsum + ma[target].get(next), next, target);
			}
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

	//Get next int array from one line
	private static Integer[] nao(int n) {
		Integer[] a = new Integer[n];
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