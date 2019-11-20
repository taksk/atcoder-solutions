import java.util.*;

public class StringOutput {
	public static void main(String[] args){
		int num = 100000;
		boolean sbflg = false;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) list.add(i);
		
		if(sbflg) {
			//Use StringBuilder and call System.out.println only once
			StringBuilder sb = new StringBuilder();
			long start = Calendar.getInstance().getTimeInMillis();			
			for(int i:list)sb.append(i + System.getProperty("line.separator"));
			System.out.println(sb);			
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("elapsed time:" + (end - start) + "ms");
		}else {
			//Don't call System.out.println many times.
			long start = Calendar.getInstance().getTimeInMillis();
			for(int i:list)System.out.println(i);
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("elapsed time:" + (end - start) + "ms");
		}
	}
}