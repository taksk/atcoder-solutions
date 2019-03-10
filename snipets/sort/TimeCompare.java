import java.util.*;
import java.io.*;

public class TimeCompare {
	public static void main(String[]args){
	//Implement solution here.
		String in = "2019/04/30";

		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(0L);//Must set milliseconds before set YMD
		cal1.set(2019,4,30);//This doesn't update hour or smaller digits
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(0L);
		String[] inymd = in.split("/");
		cal2.set(Integer.parseInt(inymd[0]),Integer.parseInt(inymd[1]),Integer.parseInt(inymd[2]));
		
		System.out.println(cal1.compareTo(cal2) >= 0 ? "Heisei" : "TBD");
	}
}