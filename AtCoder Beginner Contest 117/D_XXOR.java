//https://atcoder.jp/contests/abc117/tasks/abc117_d

import java.util.Scanner;
import java.util.Arrays;
// public class Main {
public class D_XXOR {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long k = Long.parseLong(nm[1]);
            
            String[] alist = sc.nextLine().split(" ");            
            long[] aary = new long[n];
            for(int i=0;i<n;i++){
                aary[i] = Long.parseLong(alist[i]);
            }
            
            String[] bsary = new String[n];
            int maxbslen = 0;
            for(int i=0;i<n;i++){
                bsary[i] = Long.toBinaryString(aary[i]);
                maxbslen = Math.max(maxbslen,bsary[i].length());
            }
            
            //Count each bit in A binary string
            long bitcount [] = new long[maxbslen];
            for(String bs:bsary){
                for(int j=bs.length() - 1; j >= 0;j--){
                    if(bs.charAt(j)=='1'){
                        bitcount[bs.length() - 1 - j]++;
                    }
                }
            }
            
            int kdigit = Long.toBinaryString(k).length();
            long x = 0;
            for(int i=kdigit - 1; i > 0; i--){
                long next = x + (long)Math.pow(2,i);
                if(next <= k){
                    if(i >= bitcount.length){
                        x = next;                 
                    }else{
                        if(bitcount[i] <= n/2){
                            x = next;
                        }
                    }
                }
            }
            
            long f = 0;
            for(long a:aary){
                f += x^a;
            }
            
            System.out.println(f);
		}
    }
}