import java.util.*;
import java.io.*;

public class Main {
	static int[] abc;
	static int[] val = {500,100,50};
	
	private static void solve(){
	//Implement solution here.
		abc = new int[] {ni(),ni(),ni()};
		int x = ni();
		System.out.println(rec(x,0));
	}
	
	private static int rec(int rest, int idx) {
		int result = 0;		
		for(int i = 0; i <= abc[idx]; i++) {
			if(idx < 2) {
				int nrest = rest - val[idx] * i;
				if(nrest >=0) {
					result += rec(nrest,idx+1);
				}
			}else {
				if(rest - val[idx] * i == 0) {
					return 1;
				}
			}
			
		}
		return result;
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