public class BinaryAndPadding {
	public static void main(String[] args){
		int n = 5;
		for(int i = 0; i < n; i++) {
			int b = (int)Math.pow(2, i);
			String s = String.format("%0" + n + "d",Integer.parseInt(Integer.toBinaryString(i)));
			System.out.println(s);
		}
	}
}