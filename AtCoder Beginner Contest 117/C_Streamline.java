//https://atcoder.jp/contests/abc117/tasks/abc117_c

import java.util.Scanner;
import java.util.Arrays;
// public class Main {
public class C_Streamline {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            
            String[] xlist = sc.nextLine().split(" ");
            int[] xary = new int[m];
            for(int i=0;i<m;i++){
                xary[i] = Integer.parseInt(xlist[i]);
            }
            Arrays.sort(xary);
            
            int[] lenary = new int[m-1];
            for(int i=0; i<m - 1; i++){
                lenary[i] = xary[i+1] - xary[i];
            }
            Arrays.sort(lenary);

            int result = 0;
            for(int i = 0; i < m-n; i++){
                result += lenary[i];
            }
            System.out.println(result);

		}
    }
}
