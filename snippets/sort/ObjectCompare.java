import java.util.*;
import java.io.*;

public class ObjsctCompare {
	public static void main(String[] args){
		//Implement solution here.

		List<Shop> s = new ArrayList<>();

		s.add(new Shop(100,100));
		s.add(new Shop(200,20));
		s.add(new Shop(150,10));
		s.add(new Shop(50,50));
		s.add(new Shop(100,50));

		System.out.println("Initial list.");
		s.stream().forEach(v->System.out.println("value:" + v.value + " stock:" + v.stock));
		Comparator<Shop> comparator = Comparator.comparing(Shop::getValue).thenComparing(Shop::getStock).reversed();
		s.sort(comparator);
		//s.sort((a, b) -> Integer.compare(a.value, b.value));

		System.out.println("Sorted list.");
		s.stream().forEach(v->System.out.println("value:" + v.value + " stock:" + v.stock));
	}

	static class Shop {
		private int value;
		private int stock;		
		public Shop(int v, int s) {
			this.value = v;
			this.stock = s;
		}
		public int getValue() {
			return this.value;
		}
		public int getStock() {
			return this.stock;
		}
	}

}