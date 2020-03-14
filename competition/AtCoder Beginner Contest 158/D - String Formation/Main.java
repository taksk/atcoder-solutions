import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		String S = next();
		int Q = ni();
		boolean reverse= false;
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		for(int i = 0; i < Q; i++) {
			int T = ni();
			if(T == 1) {
				reverse = !reverse;
			} else {
				int F = ni();
				char c = next().charAt(0);
				if(F == 1) {
					if(!reverse) {
						left.add(c);
					} else {
						right.add(c); 
					}
				} else {
					if(!reverse) {
						right.add(c);
					} else {
						left.add(c); 
					}
				}
			}
		}
		
		if(!reverse) {
			while(!left.isEmpty()) System.out.print(left.pollLast());
			System.out.print(S);
			while(!right.isEmpty())System.out.print(right.pollFirst());
		} else {
			while(!right.isEmpty()) System.out.print(right.pollLast());
			for(int i = S.length() - 1; i >= 0; i--) System.out.print(S.charAt(i));
			while(!left.isEmpty())System.out.print(left.pollFirst());
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
