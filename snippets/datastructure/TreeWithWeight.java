import java.util.*;

public class TreeWithWeight {

	public static void main(String[] args) {
		int size = 5;
		TreeWithWeight tw = new TreeWithWeight(size);//Initialize
		tw.addPath(2, 5, 2);
		tw.addPath(2, 3, 10);
		tw.addPath(1, 3, 8);
		tw.addPath(3, 4, 2);
		
		tw.dfs(0, 2, 0);//Select 1 node as a top of the tree.
		Arrays.stream(tw.weight).forEach(v -> System.out.println(v));//You can get weight of each node

	}

	static class TreeWithWeight{
		private Map<Integer,Long>[] ma;
		public long[] weight;

		public TreeWithWeight(int size) {
			this.ma = new HashMap[size + 1];
			this.weight = new long[size + 1];
			for(int i = 1; i < size + 1; i++) {
				ma[i] = new HashMap<Integer,Long>();
			}
		}
		
		/**
		 * Add path and weight information
		 * @param from
		 * @param to
		 * @param weight Weight value between "from" and "to" node
		 */
		public void addPath(int from, int to, long weight) {
			ma[from].put(to, weight);
			ma[to].put(from, weight);
		}

		/**
		 * Calculate weight sum(from top) of each node from top.
		 * @param wsum
		 * @param target
		 * @param before
		 */
		public void dfs(long wsum, int target, int before) {
			weight[target] = wsum;
			for(int next:ma[target].keySet()) {
				if(next != before) {
					dfs(wsum + ma[target].get(next), next, target);
				}
			}
		}
	}
}