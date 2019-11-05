import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		String s = next();
		int n = s.length() + 1;
		char[] c = s.toCharArray();
		long result = 0;
		int cnt = 0;
		int[] l = new int[n];
		int[] r = new int[n];
		for(int i = 0; i < n - 1; i++) {
			if(c[i] == '<') {
				cnt++;
				l[i + 1] = cnt;
			} else {
				cnt = 0;
			}
		}
		
		cnt = 0;
		for(int i = n - 2; i >= 0; i--) {
			if(c[i] == '>') {
				cnt++;
				r[i] = cnt;
			} else {
				cnt = 0;
			}
		}
		
		for(int i = 0; i < n; i++) {
			result += Math.max(l[i], r[i]);
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