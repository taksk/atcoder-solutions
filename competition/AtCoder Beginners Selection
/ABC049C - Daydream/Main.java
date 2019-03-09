import java.util.*;
import java.io.*;

public class Main {
	static int idx;
	private static void solve(){
		//Implement solution here.
		char[] argca = next().toCharArray();
		char[][] caa = new char[][] {
			"dream".toCharArray(),
			"dreamer".toCharArray(),
			"erase".toCharArray(),
			"eraser".toCharArray()
		};

		idx = argca.length;
		boolean cnt = true;
		while(cnt) {
			cnt = false;
			for(char[] ca : caa) {
				//System.out.println(s + " " + str);
				if(tailMatch(argca, ca)) {
					idx -= ca.length;
					cnt = idx > 0 ? true : false;
					break;
				}
			}			
		}		
		System.out.println(idx == 0 ? "YES":"NO");
	}
	
	private static boolean tailMatch(char[] a, char[] b) {
		if(idx < b.length)return false;
		for(int i = 0; i < b.length; i++) {
			if(a[idx - b.length + i] != b[i]) {
				return false;
			}
		}		
		return true;
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