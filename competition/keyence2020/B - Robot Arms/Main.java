import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int n = ni();
		List<Robot> rl = new ArrayList<Main.Robot>();
		for(int i = 0; i < n; i++) {
			long x = nl();
			long l = nl();
			rl.add(new Robot(x - l, x + l));
		}
		Comparator<Robot> comparator = Comparator.comparing(Robot::getRight);
		rl.sort(comparator);
		long maxRight = Long.MIN_VALUE;
		int result = 0;
		for(int i = 0; i < n; i++) {
			Robot a = rl.get(i);
			if(a.getLeft() >= maxRight) {
				result++;
				maxRight = a.getRight();
			}
		}
		System.out.println(result);
	}

	static class Robot{
		private long left;
		private long right;
		public Robot(long left, long right) {
			this.left = left;
			this.right = right;
		}
		public long getLeft() {
			return this.left;
		}
		public long getRight() {
			return this.right;
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
