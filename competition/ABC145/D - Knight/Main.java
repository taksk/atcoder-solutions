import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int x = ni();
		int y = ni();
		mod = 1000000007;		      
		int a = 2 * y - x;
		int b = 2 * x - y;
		if(a % 3 != 0 || a < 0 || b % 3 != 0 || b < 0) {
			System.out.println(0);
			return;
		}		
		a /= 3;
		b /= 3;
		System.out.println(combinationMod(a+b, a));
	}
	
	static long combination(int n, int k) {
		double out = 1;
		for(int i = 0; i < k; i++) {
			out = (out * (double)(n - i) / (k - i));
		}
		return (long)out;
	}
	
	static long combinationMod(int n, int k) {
        if (k == 0)return 1; 
        long[] fac = new long[n + 1];
        fac[0] = 1; 
        for (int i = 1 ;i <= n; i++) {
        	fac[i] = modMul(fac[i - 1], (long)i); 
        }            
        return modMul(modMul(fac[n],modInverse(fac[k])),modInverse(fac[n - k]));
    }
	
	static int mod;
	static long modSum(long a, long b) {
		return (a % mod + b % mod) % mod;
	}
	static long modMul(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
	}
	
	static long modInverse(long n) {
        return power(n, mod-2);
    }
	
	static long power(long a, long b) {
        long result = 1;
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1)
            	result = (result * a) % mod;
            b = b >> 1;
            a = (a * a) % mod;
        }
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
