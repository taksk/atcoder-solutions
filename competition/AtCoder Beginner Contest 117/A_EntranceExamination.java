//https://atcoder.jp/contests/abc117/tasks/abc117_a
//Capture stdin(not argument)

import java.util.Scanner;

// public class Main {
public class A_EntranceExamination {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
			double t = sc.nextDouble();
			double x = sc.nextDouble();
			System.out.println(t / x);
		}
    }
}
