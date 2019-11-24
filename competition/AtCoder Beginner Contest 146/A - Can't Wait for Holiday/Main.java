import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
		//Implement solution here.
		String s = next();
		int result = 0;
		if(("SUN").equals(s)) {
			result = 7;
		} else if(("MON").equals(s)) {
			result = 6;
		} else if(("TUE").equals(s)) {
			result = 5;
		} else if(("WED").equals(s)) {
			result = 4;
		} else if(("THU").equals(s)) {
			result = 3;
		} else if(("FRI").equals(s)) {
			result = 2;
		} else if(("SAT").equals(s)) {
			result = 1;
		} 
				
		System.out.println(result);
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