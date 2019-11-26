import java.util.*;
import java.io.*;

public class Main {

	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] h = new int[n];

		int X = -1;
		int Y = -1;
		int H = -1;
		for(int i = 0; i < n; i++) {
			x[i] = ni();
			y[i] = ni();
			h[i] = ni();			
		}

		for(int i = 0; i < n; i++) {
			if(h[i] > 0) {				
				X = x[i];
				Y = y[i];
				H = h[i];
				break;
			}
		}

		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				int tmpH = H + Math.abs(X - i) + Math.abs(Y - j);
				boolean ok = true;				
				for(int k = 0; k < n; k++) {
					if(h[k] != Math.max(0, tmpH - Math.abs(x[k] - i) - Math.abs(y[k] - j))) {
						ok = false;
						break;
					}
				}
				if(ok) {
					System.out.println(i + " " + j + " " + tmpH);
					return;
				}
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