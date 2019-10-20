import java.util.*;


import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		ArrayDeque<Integer>[] qa = new ArrayDeque[n];
		for(int i = 0; i < n; i++) {
			qa[i] = new ArrayDeque<Integer>(n);
			for(int j = 0; j < n - 1; j++) {
				qa[i].add(ni());
			}
		}

		int result = 0;
		boolean[] checked = new boolean[n];
		boolean[] matchedBefore = new boolean[n];
		Arrays.fill(matchedBefore, true);
		
		while(true) {
			//Completion check
			boolean isComp = true;
			for(int i = 0; i < n; i++) {
				isComp = isComp && qa[i].isEmpty();
			}
			if(isComp)break;
			
			//Find match
			boolean matchable = false;			
			for(int i = 0; i < n; i++) {
				if(!matchedBefore[i])continue;
				if(qa[i].isEmpty() || checked[i])continue;
				int target = qa[i].peek();
				if(!checked[target - 1] && qa[target - 1].peek() == i + 1) {
					qa[i].poll();
					qa[target - 1].poll();
					checked[i] = true;
					checked[target - 1] = true;
					matchable = true;
					matchedBefore[i] = true;
					matchedBefore[target - 1] = true;
				} else {
					matchedBefore[i] = false;
				}
			}
			
			//Continue check
			if(!matchable) {
				result = -1;
				break;
			} else {
				result++;
				Arrays.fill(checked, false);
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