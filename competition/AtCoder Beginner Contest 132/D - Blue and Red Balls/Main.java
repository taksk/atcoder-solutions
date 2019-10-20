import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int n = ni();
		int k = ni();
		ptr = new long[n + 1][n + 1];
		
		for(int i = 1; i <= k; i++) {
			if (n - k + 1 < i) {
                System.out.println(0);
            } else {
            	System.out.println(ptrVal(n - k + 1, i) * ptrVal(k - 1, i - 1) % mod);
            }			
		}		
	}
	private static int mod = 1000000007;
	private static long[][] ptr;
	private static long ptrVal(int a, int b){
		if(ptr[a][b] > 0) {
			return ptr[a][b];
		} else {
			if(a == 0 && b == 0) {
				ptr[a][b] = 1;
			} else {
				if (a == b) {
					ptr[a][b] = ptrVal(a - 1, b - 1);				
				} else if(b == 0) {
					ptr[a][b] = ptrVal(a - 1, b);
				} else {
					ptr[a][b] = (ptrVal(a - 1, b - 1) + ptrVal(a - 1, b)) % mod;
				}
			}
			return ptr[a][b];
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