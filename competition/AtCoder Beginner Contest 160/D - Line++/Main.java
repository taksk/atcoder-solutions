import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {	

	private static void solve(){
		//Implement solution here.
		int N = ni();
		int X = ni();
		int Y = ni();
		int start = Math.min(X, Y);
		int mid = (Y + X)/2;
		int end = Math.max(X, Y);
		int[] ans = new int[N];
		for(int i = 1; i < N; i++) {
			if(i <= start) {
				for(int j = i + 1; j <= mid; j++) {
					ans[j - i]++;
				}
				for(int j = mid + 1; j < end; j++) {
					ans[end - j + 1 + start - i]++;
				}
				for(int j = end; j <= N; j++) {
					ans[j - end + 1 + start - i]++;
				}
			} else if(i > start && i < mid) {
				for(int j = i + 1; j < end; j++) {
					ans[Math.min(j - i, i - start + 1 - j + end)]++;
				}
				for(int j = end; j <= N; j++) {
					ans[j - end + Math.min(i - start + 1, j - i)]++;
				}
				
			}else {
				for(int j = i + 1; j <= N; j++) {
					ans[j - i]++;
				}
			}
		}

		for(int i = 1; i <= N -1; i++) {
			System.out.println(ans[i]);
		}

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
		boolean hasNext = true;
		while(hasNext){
			solve();	
			try{
				br.mark(1);
				if(br.read() > 0){
					br.reset();			
					System.out.println("---");
				} else {
					hasNext = false;
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			} 
		}
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