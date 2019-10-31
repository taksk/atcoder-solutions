import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();
		List<Sp> spl = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			spl.add(new Sp(i+1, next(), ni()));
		}
		Comparator<Sp> comparator = Comparator.comparing(Sp::getS).reversed().thenComparing(Sp::getP).reversed();
		spl.sort(comparator);
		spl.stream().forEach(sp -> System.out.println(sp.getIdx()));
	}
	
	static class Sp {
		private int idx;
		private String s;
		private int p;
		public Sp(int idx, String s, int p) {
			this.idx = idx;
			this.s = s;
			this.p = p;
		}
		public int getIdx() {
			return this.idx;
		}
		public String getS() {
			return this.s;
		}
		public int getP() {
			return this.p;
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