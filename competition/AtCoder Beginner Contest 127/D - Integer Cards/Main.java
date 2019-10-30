import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int m = ni();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < n; i++) {
			int a = ni();
			if(map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			}else {
				map.put(a, 1);
			}
		}
		
		for(int i = 0; i < m; i++) {
			int b = ni();
			int c = ni();
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + b);
			}else {
				map.put(c, b);
			}
		}
		
		Set<Integer> keySet = map.keySet();
		Integer[] keyArray = keySet.toArray(new Integer[keySet.size()]);
		Arrays.sort(keyArray);
		
		int cnt = 0;
		int kidx = keyArray.length - 1;
		long result = 0;
		while(cnt < n) {
			int d = keyArray[kidx];
			int dcnt = map.get(d);
			
			if(cnt + dcnt <= n) {
				result += (long)d * (long)dcnt;
				cnt += dcnt;
			} else {
				result += (long)d*(long)(n - cnt);
				cnt = n;
			}
			kidx--;
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