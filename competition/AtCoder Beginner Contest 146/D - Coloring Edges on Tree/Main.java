import java.util.*;

import java.io.*;

public class Main {
	static HashMap<Integer,Integer>[] map;
	private static void solve(){
		//Implement solution here.
		int n = ni();
		int[][] ia = new int[n-1][2];
		map = new HashMap[n + 1];
		for(int i = 1; i <= n; i++) {
			map[i] = new HashMap<Integer,Integer>();
		}
		for(int i = 0; i < n - 1; i++) {			
			int a = ni();
			int b = ni();
			ia[i][0] = a;
			ia[i][1] = b;
			map[a].put(b, 0);
			map[b].put(a, 0);			
		}
		
		int max = 0;
		List<Node> nl = new ArrayList<Main.Node>();
		for(int i = 1; i <= n; i++) {
			nl.add(new Node(i,map[i].keySet().size()));
			max = Math.max(max, map[i].keySet().size());
		}
		Comparator<Node> comparator = Comparator.comparing(Node::getCnt).reversed();
		nl.sort(comparator);
		Node head = nl.get(0);
		color(head.id,0);
		
		System.out.println(max);
		for(int i = 0; i < n - 1; i++) {
			System.out.println(map[ia[i][0]].get(ia[i][1]));
		}
	}
	
	static void color(int node,int pcolor) {
		int color = 1;
		HashMap<Integer,Integer> nmap = map[node];
		for(Integer next:nmap.keySet()) {
			if(nmap.get(next) == 0) {			
				if(color == pcolor)color++;
				nmap.put(next, color);
				map[next].put(node, color);				
				color(next,color);
				color++;
			} else {
				continue;
			}			
		}	
		
	}
	
	static class Node{
		public int id;
		public int cnt;
		public Node(int id, int cnt) {
			this.id = id;
			this.cnt = cnt;
		}
		public int getId() {
			return this.id;
		}
		public int getCnt() {
			return this.cnt;
		}
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