import java.util.ArrayList;
import java.util.List;

public class MathTool{
	//Find greatest common divisor
	static int gcd (int a, int b) {
		return b > 0 ? gcd(b, a%b) : a;
	}
	//Find least common multiple
	static int lcm (int a, int b) {
		return a * b / gcd(a, b);
	}

	/**
	 * Get prime factors list
	 * @param a: Target number to find prime factors
	 * @return List of prime factors
	 */
	static List<Integer> primeFactorization(int a){
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for(int i = 2; i <= Math.sqrt(a) + 1; i++) {
			if(a % i == 0) {
				result.add(i);
				while(a % i == 0) {
					a /= i;
				}		
			}				
		}
		if(a > 1) {
			result.add(a);
		}
		return result;
	}
}