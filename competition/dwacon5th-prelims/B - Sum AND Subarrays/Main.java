import java.util.*;
import java.io.*;

public class Main {

	private static void solve(){
		//Implement solution here.
		int n = ni();
		int k = ni();
		long[] a = nal(n);
		List<Long> b = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			long tmp = 0;
			for(int j = i; j < n;j++) {
				tmp += a[j];
				b.add(tmp);
			}
		}
		
		long x = 0;
		for(int i = 40; i >= 0; i--) {
			int tmpcnt = 0;
			long tmpx = x + (long)Math.pow(2, i);
			for(Long bl:b) {
				if((tmpx & bl) == tmpx) {
					tmpcnt++;
				}
				if(tmpcnt >=k) {
					x += Math.pow(2, i);
					break;
				}
			}
		}
		System.out.println(x);
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