import java.util.*;
import java.io.*;

public class Main {	

	private static void solve(){
		//Implement solution here.
		int X = ni();
		int N = ni();
		List<Integer> p = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)p.add(ni());
		Map<Integer,Boolean> map = new HashMap<>();
		for(int i:p)map.put(i,true);
		int result = -1;
		for(int dist = 0; dist <= 100; dist++) {
			int bpos = X - dist;
			int fpos = X + dist;

			if(!map.containsKey(bpos)) {
				result = bpos;
				break;
			}
			if(!map.containsKey(fpos)) {
				result = fpos;
				break;
			}
		}
		System.out.println(result);
//		for(int i = 1 ; i < 101; i++) {
//			System.out.print(i + " ");
//		}
	}

	//Switch input source (stdin/file)
	private static BufferedReader br;
	public static void main(String[] args){
		br = new BufferedReader(new InputStreamReader(System.in));
		String debugDataPath = System.getenv("DD_PATH");        
		if(debugDataPath != null){
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(debugDataPath))));
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		solve();
		boolean hasNext = true;
//		while(hasNext){
//			solve();	
//			try{
//				br.mark(1);
//				if(br.read() > 0){
//					br.reset();			
//					System.out.println("---");
//				} else {
//					hasNext = false;
//				}
//			}catch(Exception e){
//				throw new RuntimeException(e);
//			} 
//		}
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
