import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		String in = next();

		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(0L);//Must set milliseconds before set YMD
		cal1.set(2019,4,30);//This doesn't update hour or smaller digits
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(0L);
		String[] inymd = in.split("/");
		cal2.set(Integer.parseInt(inymd[0]),Integer.parseInt(inymd[1]),Integer.parseInt(inymd[2]));
		
		System.out.println(cal1.compareTo(cal2) >= 0 ? "Heisei" : "TBD");
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