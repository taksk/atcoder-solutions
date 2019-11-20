import java.util.*;
import java.io.*;

public class Main {
	static int[] f = new int[101];
	static int n;
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int m = ni();
		List<City> cl = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			cl.add(new City(i, ni(), ni()));
		}
		Comparator<City> cmp1 = Comparator.comparing(City::getP).thenComparing(City::getY);
		Comparator<City> cmp2 = Comparator.comparing(City::getIdx);
		
		cl.sort(cmp1);
		
		int tmpp = -1;
		int tmpcnt = 1;
		for(int i = 0; i < m; i++) {
			City c = cl.get(i);
			if(c.p != tmpp) {
				tmpp = c.p;
				tmpcnt = 1;
			} else {
				tmpcnt++;
			}
			c.id = String.format("%06d", tmpp) + String.format("%06d", tmpcnt);
		}
		
		cl.sort(cmp2);
		StringBuilder sb = new StringBuilder();
		cl.forEach(v -> sb.append(v.id + System.getProperty("line.separator")));
		System.out.println(sb);
	}
	
	static class City {
		private int idx;
		private int p;
		private int y;
		public String id;
		public City(int idx, int p, int y) {
			this.idx = idx;
			this.p = p;
			this.y = y;
		}
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public int getP() {
			return p;
		}
		public void setP(int p) {
			this.p = p;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
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