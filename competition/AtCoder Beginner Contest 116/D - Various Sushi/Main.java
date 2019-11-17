import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int k = ni();
		Map<Integer,Queue<Integer>> map = new HashMap<>();
		Queue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> eq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			int t = ni();
			int d = ni();
			if(!map.containsKey(t)) {
				map.put(t, new PriorityQueue<Integer>(Collections.reverseOrder()));
			} 
			map.get(t).add(d);
		}
		
		for(int key:map.keySet()) {
			nq.add(map.get(key).poll());
			while(!map.get(key).isEmpty()) {
				eq.add(map.get(key).poll());
			}
		}

		long dsum = 0;
		long var = 0;
		Queue<Integer> rq = new PriorityQueue<>();
		while(rq.size() < k && !nq.isEmpty()) {
			int dd = nq.poll();			
			rq.add(dd);
			dsum += dd;
			var++;
		}
		
		long result = dsum + var * var;
		
		for(int i = 0; i < k; i++) {
			if(eq.isEmpty())break;
			int dd = eq.poll();
			dsum += dd;
			if(rq.size() >= k) {				
				dsum -= rq.poll();			
				var--;
			}
			rq.add(dd);
			result = Math.max(result, dsum + var * var);
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
