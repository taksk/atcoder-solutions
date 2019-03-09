import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int m = ni();
		int nsum = 0;
		long result = 0;
		List<Shop> s = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			s.add(new Shop(ni(),ni()));
		}
		
		s.sort((a, b) -> a.v - b.v);
		for(Shop s1:s) {
			//System.out.println(nsum + " " + s1.v + " " + s1.n);
			if(nsum + s1.n <= m) {
				nsum += s1.n;
				result += (long)s1.v * s1.n;
			} else {
				result += (long)s1.v * (m - nsum);
				break;
			}
		}
		System.out.println(result);
		
	}
	
	static class Shop {
		int v;
		int n;		
		public Shop(int v, int n) {
			this.v = v;
			this.n = n;
		}		
	}

	//Switch input source (stdin/file)
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		String debugDataPath = System.getenv("DD_PATH");        
		if(debugDataPath != null){
			try{
				scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File(debugDataPath)))));
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
				tokenizer = new StringTokenizer(scanner.nextLine());
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