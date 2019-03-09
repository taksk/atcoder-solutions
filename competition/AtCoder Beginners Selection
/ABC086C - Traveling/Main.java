import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int n = ni();
		int[] t = new int[n + 1];
		int[] x = new int[n + 1];
		int[] y = new int[n + 1];
		t[0] = 0;
		x[0] = 0;
		y[0] = 0;
		for(int i = 1; i <= n; i++) {
			t[i] = ni();
			x[i] = ni();
			y[i] = ni();
		}
		
		for(int i = 0; i < n; i++) {
			int td = Math.abs(t[i + 1] - t[i]);
			int xd = Math.abs(x[i + 1] - x[i]);
			int yd = Math.abs(y[i + 1] - y[i]);
			int ev = td - xd - yd;
			if(ev < 0 || ev % 2 != 0) {
				System.out.println("No");
				return;
			} 
		}
		System.out.println("Yes");
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