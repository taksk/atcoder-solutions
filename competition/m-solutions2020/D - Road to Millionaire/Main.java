import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int N = ni();
		int[] A = na(N);
		int[] trends = new int[N];
		long result = 1000;
		long stocks = 0;
		
		for(int i = 1; i < N; i++) {
			if(A[i] < A[i - 1]) {
				trends[i] = - 1;
			} else if(A[i] == A[i - 1]) {
				trends[i] = trends[i - 1];
			} else {
				trends[i] = 1;
			}
		}
		
		for(int i = N - 2; i >= 0; i--) {
			if(trends[i] == 0)trends[i] = trends[i + 1];
		}
		
		if(trends[1] > 0) {			
			stocks = result / A[0];
			result = result % A[0];			
		}
		
		for(int i = 1; i < N - 1; i++) {
			if(trends[i] > 0 && trends[i + 1] < 0) {
				//sell
				result += A[i] * stocks;
				stocks = 0;
			} else if (trends[i] < 0 && trends[i + 1] > 0) {
				//buy
				stocks = result / A[i];
				result = result % A[i];				
			}
		}
		
		result += A[N - 1] * stocks;
		stocks = 0;
		System.out.println(result);
//		for(int i:trends)System.out.print(i + " ");
//		System.out.println();
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
