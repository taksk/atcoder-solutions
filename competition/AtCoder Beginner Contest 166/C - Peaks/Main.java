import java.util.*;
import java.io.*;

public class Main {	
	static Map<Integer,List<Integer>> map;
	static int[] H;
	static int max = -1;
	private static void solve(){
		//Implement solution here.
		int N = ni();
		int M = ni();
		H = na(N);
		map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < M; i++) addPath(ni(),ni());
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(!map.containsKey(i)) {
				result++;
			} else {
				boolean ok = true;
				for(int j = 0; j < map.get(i).size(); j++) {
					if(H[i - 1] <= H[map.get(i).get(j) - 1]) {
						ok = false;
						break;
					}
				}
				//if(ok)System.out.println(i + " " + H[i - 1] + " " + map.get(i));
				if(ok)result++;
			}			
		}
		System.out.println(result);
	}
	
	private static void addPath(int A, int B){
		if(!map.containsKey(A)) map.put(A, new ArrayList<Integer>());
		map.get(A).add(B);
		if(!map.containsKey(B)) map.put(B, new ArrayList<Integer>());
		map.get(B).add(A);
	}
	
	private static void rec() {
		
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
		boolean hasNext = true;
		while(hasNext){
			solve();	
			try{
				br.mark(1);
				if(br.read() > 0){
					br.reset();			
					System.out.println("---");
				} else {
					hasNext = false;
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			} 
		}
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