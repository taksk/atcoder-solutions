import java.util.*;
import java.io.*;

public class CombinationAndModular {
	public static void main(String[] args){
	//Implement solution here.
		mod = 1000000007;
		int a = 306868;
		int b = 132419;			      
		System.out.println(combiWithMod(a+b, a));				
	}
	
	/**
	 * Simple nCk without mod calculation.
	 * @param n
	 * @param k
	 * @return nCk
	 */
	static long combi(int n, int k) {
		double out = 1;
		for(int i = 0; i < k; i++) {
			out = (out * (double)(n - i) / (k - i));
		}
		return (long)out;
	}
	
	/**
	 * nCk with mod calculation. "mod" is instance variable.
	 * @param n
	 * @param k
	 * @return nCk with mod calculation.
	 */
	static long combiWithMod(int n, int k) {
        if (k == 0)return 1; 
        long[] fac = new long[n + 1];
        fac[0] = 1; 
        for (int i = 1 ;i <= n; i++) {
        	fac[i] = modMul(fac[i - 1], (long)i); 
        }            
        return modMul(modMul(fac[n],modInverse(fac[k])),modInverse(fac[n - k]));
    }
	
	
	static int mod;
	/**
	 * Mod Sum calculation
	 * @param a
	 * @param b
	 * @return
	 */
	static long modSum(long a, long b) {
		return (a % mod + b % mod) % mod;
	}
	
	/**
	 * Mod multiply calculation
	 * @param a
	 * @param b
	 * @return
	 */
	static long modMul(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
	}
	
	static long modInverse(long n) {
        return power(n, mod-2);
    }
	
	static long power(long a, long b) {
        long result = 1;
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1)
            	result = (result * a) % mod;
            b = b >> 1;
            a = (a * a) % mod;
        }
        return result;
    }
}
