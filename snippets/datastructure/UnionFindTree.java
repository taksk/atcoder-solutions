import java.util.*;
import java.io.*;

public class UnionFindTree{
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(5);
		uf.unite(0, 1);
		uf.unite(1, 2);
		uf.unite(3, 1);
		System.out.println("Parent of node in united group(0 belongs to):" + uf.find(0));
		System.out.println("Parent of single node(4):" + uf.find(4));
		
		System.out.println("Node count of group 0 belongs to:" + uf.size[uf.find(0)]);
		System.out.println("Node count of group 4 belongs to:" + uf.size[uf.find(4)]);
		
	}
	static class UnionFind{
		//Union find tree.
		private int[] par;
		private int[] rank;
		public int[] size; //Parent node has count of nodes belong to the group 

		public UnionFind(int size) {
			this.par = new int[size];
			this.rank = new int[size];
			this.size = new int[size];
			for(int i = 0; i < size; i++) {
				par[i] = i;
				rank[i] = 0;
				this.size[i] = 1;
			}
			Arrays.fill(this.size, 1);
		}
		/**
		 * Get parent node number of x 
		 * @param x 
		 * @return
		 */
		public int find(int x) {
			if(par[x] == x) {
				return x;
			} else {
				return find(par[x]);
			}
		}

		/**
		 * Unite groups x and y belongs
		 * @param x
		 * @param y
		 */
		public void unite(int x, int y) {
			int xpar = find(x);
			int ypar = find(y);
			if(xpar == ypar) {
				return;
			}else {
				int sum = size[xpar] + size[ypar];
				size[xpar] = sum;
				size[ypar] = sum;

				if(rank[xpar] < rank[ypar]) {
					par[xpar] = ypar;
				} else {
					par[ypar] = xpar;
					if(rank[xpar] == rank[ypar]) rank[xpar] ++;
				}
			}
		}

		public boolean sameGroup(int x, int y) {
			return find(x) == find(y);
		}		
	}
}