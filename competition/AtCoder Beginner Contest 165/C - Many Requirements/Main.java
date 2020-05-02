import java.util.*;
import java.io.*;

public class Main {	
	static int[][] map;
	static int N;
	static int M;
	static int Q;
	private static void solve(){
		//Implement solution here.
		N = ni();
		M = ni();
		Q = ni();
		map = new int[Q][4];
		for(int i = 0; i < Q; i++) map[i] = na(4);		
		int result = rec(new int[M + 1], 1, N);
		System.out.println(result);
	}
	
	private static int rec(int[] A, int idx, int last) {
		int result = 0;
		int[] NA = A.clone();
		
		for(int i = 0; i <= last; i ++) {			
			NA[idx] = i;
			if(last - i > 0) {
				if(idx < M) {
					result = Math.max(result, rec(NA, idx + 1, last - i));
				}				
			} else {
				result = Math.max(result, getScore(NA));
			}
		}
		return result;
	}
	
	private static int getScore(int[] A) {		
		int score = 0;
		for(int j = 0; j < Q; j++) {
			if(getAval(A,map[j][1]) - getAval(A,map[j][0]) == map[j][2])score += map[j][3];
		}
		return score;
	}
	
	private static int getAval(int[] A, int cnt) {
		int result = 0;
		for(int i = 1; i < A.length; i++) {
			if(A[i] >= cnt) {
				result = i;
				break;
			} else {
				cnt -= A[i];
			}
		}
		return result;
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