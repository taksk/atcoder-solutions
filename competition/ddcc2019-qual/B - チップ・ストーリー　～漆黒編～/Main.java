import java.util.*;
import java.io.*;

public class Main {
	static double n;
	private static void solve(){
		//Implement solution here.
		n = (double)ni();
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				boolean inArea = pointInArea(i, j) 
						&& pointInArea(i + 1, j)
						&& pointInArea(i, j + 1)
						&& pointInArea(i + 1, j + 1);
				if(inArea)result++;
			}
		}
		System.out.println(result);
	}
	
	static boolean pointInArea(int x, int y) {
		boolean result = true;
		double dx = (double)x;
		double dy = (double)y; 
		if(dy > dx + n / 2)result = false;
		if(dy > -dx + n * 3 / 2)result = false;
		if(dy < -dx + n / 2)result = false;
		if(dy < dx - n / 2)result = false;	
		return result;		
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