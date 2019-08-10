import java.util.*;


import java.io.*;
 
public class Main {
	private static void solve(){
		//Implement solution here.
		int n = ni();		
		int m = ni();
		long result = 0L;
		List<Job> j = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			j.add(new Job(nl(),nl()));
		}
		Comparator<Job> dayComparator = Comparator.comparing(Job::getDay);
		Comparator<Job> salaryComparator = Comparator.comparing(Job::getSalary).reversed();
		j.sort(dayComparator);
		Queue<Job> jq = new PriorityQueue<>(salaryComparator);
		int jidx = 0;
		for(int i = m - 1; i >= 0; i--) {
			while(true) {
				if(jidx < n && j.get(jidx).day <= m - i) {
					jq.add(j.get(jidx));
					jidx++;
				} else {
					break;
				}
			}
			if(jq.size() > 0) {
				result += jq.poll().salary;
			}
		}
		System.out.println(result);
	}
	
	static class Job{
		private long day;
		private long salary;
		public Job(long day, long salary) {
			this.day = day;
			this.salary = salary;
		}
		public long getDay() {
			return day;
		}		
		public long getSalary() {
			return salary;
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