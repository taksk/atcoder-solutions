import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static int[][] result;
	static int num = 1;
	static int h;
	static int w;
	private static void solve(){
		//Implement solution here.
		h = ni();
		w = ni();
		int k = ni();
		map = new char[h][w];
		result = new int[h][w];
		for(int i = 0; i < h; i++) {
			map[i] = next().toCharArray();
		}
		cut(0, w - 1, 0, h - 1);
		result();
	}

	static void cut(int xs, int xe, int ys, int ye) {
		int s1 = 0;
		int s2 = 0;
		int xs1 = xs;
		int xe1 = xe;
		int ys1 = ys;
		int ye1 = ye;
		int xs2 = xs;
		int xe2 = xe;
		int ys2 = ys;
		int ye2 = ye;
		
		if(countStrawberry(xs, xe, ys, ye) == 1){
			putNum(xs, xe, ys, ye);
			num++;
			return;
		}
		
		int vfirst = -1;
		int vmid = -1;
		if(ye - ys >= 1) {
			for(int i = ys; i <= ye; i++) {
				for(int j = xs; j <= xe; j++) {
					if(map[i][j] == '#') {
						if(vfirst < 0) {
							vfirst = i;
							break;
						} else {
							if(vfirst != i) {
								vmid = vfirst;
								break;
							}
						}
					}
				}
				if(vmid > 0)break;
			}
		}
		

		if(vmid >= 0) {
			ye1 = vmid;
			ys2 = vmid + 1;
			s1 = countStrawberry(xs1, xe1, ys1, ye1);
			s2 = countStrawberry(xs2, xe2, ys2, ye2);
		} else {
			int hfirst = -1;
			int hmid = -1;
			for(int i = xs; i <= xe; i++) {
				for(int j = ys; j <= ye; j++) {
					if(map[j][i] == '#') {
						if(hfirst < 0) {
							hfirst = i;
							break;
						} else {							
							if(hfirst != i) {
								hmid = hfirst;
								break;
							}
						}
					}
				}
				if(hmid > 0)break;
			}
						
			xe1 = hmid;
			xs2 = hmid + 1;
			s1 = countStrawberry(xs1, xe1, ys1, ye1);
			s2 = countStrawberry(xs2, xe2, ys2, ye2);   
		}
		
		
		if(s1 <= 1) {
			putNum(xs1, xe1, ys1, ye1);
			num++;
		} else {
			cut(xs1, xe1, ys1, ye1);
		}
		if(s2 <= 1) {
			putNum(xs2, xe2, ys2, ye2); 
			num++;
		} else {			
			cut(xs2, xe2, ys2, ye2);
		}

	}

	static int countStrawberry(int xs, int xe, int ys, int ye) {
		int strawberry = 0;
		for(int i = ys; i <= ye; i++) {
			for(int j = xs; j <= xe; j++) {
				strawberry += map[i][j] == '#' ? 1 : 0;
			}
		}
		return strawberry;    	
	}

	static void putNum(int xs, int xe, int ys, int ye) {
		for(int i = ys; i <= ye; i++) {
			for(int j = xs; j <= xe; j++) {
				result[i][j] = num;
			}
		}
	}


	static void result() {
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
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