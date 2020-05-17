import java.util.*;
import java.io.*;

public class Main {
	static int[] distance;
	static int[] result;
	private static void solve(){
		//Implement solution here.
		
		int N = ni();
		int M = ni();
		
		result = new int[N + 1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++)graph[i] = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			int A = ni();
			int B = ni();
			graph[A].add(B);
			graph[B].add(A);
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		while(!q.isEmpty()) {
			int idx = q.poll();
			for(int next: graph[idx]) {
				if(result[next] == 0) {
					result[next] = idx;
					q.add(next);
				}
			}
		}

		boolean ok = true;
		for(int i = 2; i <= N; i++) {
			if(result[i] == 0) {
				ok = false;
			}
		}
		
		if(ok) {
			System.out.println("Yes");
			for(int i = 2; i <= N; i++) {				
				System.out.println(result[i]);
			}
		} else {
			System.out.println("No");
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
