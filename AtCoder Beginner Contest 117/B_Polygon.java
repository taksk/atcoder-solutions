//https://atcoder.jp/contests/abc117/tasks/abc117_b

import java.util.Scanner;
// public class Main {
public class B_Polygon {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int n = Integer.parseInt(sc.nextLine());
            String[] lslist = sc.nextLine().split(" ");
            int[] lary = new int[lslist.length];
            
            for(int i = 0; i < lslist.length; i++){
                lary[i] = Integer.parseInt(lslist[i]);
            }

            int max = lary[0];
            int lsum = lary[0];
            for(int i = 1; i < lary.length; i++){
                max = Math.max(lary[i], max);
                lsum += lary[i];
            }
            lsum -= max;
            
            if(lsum > max){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

		}
    }
}
