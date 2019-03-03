
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int a;
	static int b;
	static int c;
	static int[] l;
	private static void solve(){
	//Implement solution here.
		n = ni();
		a = ni();
		b = ni();
		c = ni();
		l = new int[n];
		for(int i = 0; i<n; i++)l[i] = ni();		
		System.out.println(dfs(0,0,0,0));
	}

	private static int dfs(int cur, int ta, int tb, int tc) {
		if(cur == n) {
			if(ta <= 0 || tb <= 0 || tc <= 0) {
				return Integer.MAX_VALUE - 10;
			}else {
				return Math.abs(ta -a) + Math.abs(tb -b) + Math.abs(tc - c) - 30;
			}			
		}else {
			int ret0 = dfs(cur + 1, ta, tb, tc);//Don't use l[n]
			int ret1 = dfs(cur + 1, ta + l[cur], tb, tc) + 10;//Use l[n] to A
			int ret2 = dfs(cur + 1, ta, tb + l[cur], tc) + 10;//Use l[n] to B
			int ret3 = dfs(cur + 1, ta, tb, tc + l[cur]) + 10;//Use l[n] to C
			return Math.min(Math.min(ret0, ret1),Math.min(ret2, ret3));
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