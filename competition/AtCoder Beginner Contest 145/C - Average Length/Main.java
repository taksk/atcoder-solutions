import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int n = ni();
		double[][] xy = new double[n][2];
		for(int i = 0; i < n; i++) {
			xy[i][0] = nd();
			xy[i][1] = nd();
		}
		double lengsum = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				double ax = xy[i][0];
				double ay = xy[i][1];
				double bx = xy[j][0];
				double by = xy[j][1];
 				lengsum += Math.pow(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2), 0.5);
 				//System.out.println(lengsum);
			}
		}
		
		int all = 1;
		int section = n - 1;
		int choice = n * (n - 1) / 2;
		int tmp = n;
		while(tmp > 1) {
			all = all * tmp;
			tmp--;
		}
		int b = all * section / choice;
		System.out.println(lengsum * b / all);

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
