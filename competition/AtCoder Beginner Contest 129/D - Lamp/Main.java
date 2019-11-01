import java.util.*;
import java.io.*;

public class Main {
	private static void solve(){
	//Implement solution here.
		int h = ni();
		int w = ni();
		char[][] map = new char[h][w];
		int[][] vmap = new int[h][w + 1];
		int[][] hmap = new int[h][w];
		for(int i = 0; i < h; i++) {
			map[i] = next().toCharArray();
		}
		
		int st = -1;
		int dotcnt = 0;
		boolean indot = false;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(!indot) {
					if(map[i][j] == '.') {
						indot = true;
						st = j;
						dotcnt = 1;						
					}
				} else {
					if(map[i][j] == '.') {
						dotcnt++;
					} else {
						Arrays.fill(vmap[i],st,j,dotcnt);
						st = -1;
						dotcnt = 0;
						indot = false;
					}
				}
				if(j == w - 1 && indot) {
					Arrays.fill(vmap[i],st,j + 1,dotcnt);
					st = -1;
					dotcnt = 0;
					indot = false;
				}
			}
		}
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(!indot) {
					if(map[j][i] == '.') {
						indot = true;
						st = j;
						dotcnt = 1;						
					}
				} else {
					if(map[j][i] == '.') {
						dotcnt++;
					} else {
						for(int k = st; k < j; k++) {
							hmap[k][i] = dotcnt;
						}
						st = -1;
						dotcnt = 0;
						indot = false;
					}
				}
				if(j == h - 1 && indot) {
					for(int k = st; k <= j; k++) {
						hmap[k][i] = dotcnt;
					}
					st = -1;
					dotcnt = 0;
					indot = false;
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				result = Math.max(result, vmap[i][j] + hmap[i][j] - 1);
			}
		}
		System.out.println(result);
		
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