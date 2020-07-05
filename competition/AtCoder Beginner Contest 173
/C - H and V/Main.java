import java.util.*;
import java.io.*;

public class Main {	

	private static void solve(){
		//Implement solution here.
		int H = ni();
		int W = ni();
		int K = ni();
		long result = 0;
		char[][] c = new char[H][W];
		for(int i = 0; i < H; i++) c[i] = next().toCharArray();

		for(int i = 0; i < Math.pow(2, H); i++) {
			String Hfilter = String.format("%0" + H + "d",Integer.parseInt(Integer.toBinaryString(i)));
			for(int j = 0; j < Math.pow(2,W); j++) {
				String Vfilter = String.format("%0" + W + "d",Integer.parseInt(Integer.toBinaryString(j)));
				int cnt = 0;
				for(int k = 0; k < H; k++) {
					if(Hfilter.charAt(k) == '0') continue;
					for(int l = 0; l < W; l++) {
						if(Vfilter.charAt(l) == '0')continue;
						if(c[k][l] == '#') cnt++;
						if(cnt > K)break;
					}
					if(cnt > K)break;
				}
				if(cnt == K)result++;
			}

		}
		System.out.println(result);
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
