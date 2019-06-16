public class MathTool{
	//Find greatest common divisor
	static int gcd (int a, int b) {
		return b > 0 ? gcd(b, a%b) : a;
	}
	//Find least common multiple
	static int lcm (int a, int b) {
		return a * b / gcd(a, b);
	}    
}