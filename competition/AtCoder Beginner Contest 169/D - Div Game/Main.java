import java.util.*;
import java.io.*;

public class Main {	
	static List<Long> pfs;
	static List<Integer> pfcnts;
	private static void solve(){
		//Implement solution here.
		pfs = new ArrayList<Long>();
		pfcnts = new ArrayList<Integer>();
		long N = nl();
		primeFactorization(N);
		int result = 0;
		for(int i = 0; i < pfcnts.size(); i++) {
			int a = pfcnts.get(i);
			int cmd = 1;
			while(a >= cmd) {
				a -= cmd;
				cmd++;
				result++;
			}
		}
		System.out.println(result);
	}

	/**
	 * Get prime factors list
	 * @param a: Target number to find prime factors
	 * @return List of prime factors
	 */
	static void primeFactorization(long a){
		//pfs.add(1L);
		for(int i = 2; i <= Math.sqrt(a) + 1; i++) {
			
			if(a % i == 0) {
				int cnt = 0;
				pfs.add((long)i);
				while(a % i == 0) {
					a /= i;
					cnt++;
				}
				pfcnts.add(cnt);
			}				
		}
		if(a > 1) {
			pfs.add(a);
			pfcnts.add(1);
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
