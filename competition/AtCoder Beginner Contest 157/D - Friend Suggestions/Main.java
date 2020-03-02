import java.util.*;
import java.io.*;

public class Main {	
	private static void solve(){
		//Implement solution here.
		int N = ni();
		int M = ni();
		int K = ni();
		UnionFind uf = new UnionFind(N);
		int[] df = new int[N];
		//Friend group
		for(int i = 0; i < M; i++) {
			int a = ni();
			int b = ni();
			df[a - 1]++;
			df[b - 1]++;
			uf.unite(a - 1, b - 1);
		}
		
		//Block group
		@SuppressWarnings("unchecked")
		Set<Integer>[] bs = new HashSet[N];
		for(int i = 0; i < K; i++) {
			int a = ni();
			int b = ni();
			if(bs[a - 1] == null)bs[a - 1] = new HashSet<Integer>();
			if(bs[b - 1] == null)bs[b - 1] = new HashSet<Integer>();
			bs[a -1].add(b - 1);
			bs[b -1].add(a - 1);
		}
		
		for(int i = 0; i < N; i++) {
			int result = uf.size[uf.find(i)] - df[i] - 1;
			if(bs[i] != null) {
				for(int j:bs[i]) {
					if(uf.sameGroup(i, j))result--;
				}
			}			
			System.out.print(result + " ");
		}

	}
	static class UnionFind{
		//Union find tree.
		private int[] par;
		private int[] rank;
		public int[] size; //Parent node has count of nodes belong to the group 

		public UnionFind(int size) {
			this.par = new int[size];
			this.rank = new int[size];
			this.size = new int[size];
			for(int i = 0; i < size; i++) {
				par[i] = i;
				rank[i] = 0;
				this.size[i] = 1;
			}
			Arrays.fill(this.size, 1);
		}
		/**
		 * Get parent node number of x 
		 * @param x 
		 * @return
		 */
		public int find(int x) {
			if(par[x] == x) {
				return x;
			} else {
				return find(par[x]);
			}
		}

		/**
		 * Unite groups x and y belongs
		 * @param x
		 * @param y
		 */
		public void unite(int x, int y) {
			int xpar = find(x);
			int ypar = find(y);
			if(xpar == ypar) {
				return;
			}else {
				int sum = size[xpar] + size[ypar];
				size[xpar] = sum;
				size[ypar] = sum;

				if(rank[xpar] < rank[ypar]) {
					par[xpar] = ypar;
				} else {
					par[ypar] = xpar;
					if(rank[xpar] == rank[ypar]) rank[xpar] ++;
				}
			}
		}

		public boolean sameGroup(int x, int y) {
			return find(x) == find(y);
		}		
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
