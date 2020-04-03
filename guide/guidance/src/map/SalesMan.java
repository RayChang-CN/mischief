/*
 * 2019.12.10*/
package map;

/** 旅行商问题利用最小堆的分支限界算法类 */
public class SalesMan {
	/** 当前图中所有顶点个数 */
	private int n;
	/** 当前图的邻接表 */
	private int[][] adjacencies;
	/** 当前耗费 */
	@SuppressWarnings("unused")
	private int currentCost;
	/** 最小耗费 */
	@SuppressWarnings("unused")
	private int bestCost;
	/** 定义两顶点无边相连 */
	private static final int NOEDGE = -1;

	/**
	 * 构造函数
	 * 
	 * @param n
	 *            图中所有顶点个数
	 * @param adjacencies
	 *            图的邻接表
	 * */
	public SalesMan(int n, int[][] adjacencies) {
		this.n = n;
		this.adjacencies = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.adjacencies[i][j] = adjacencies[i][j];
			}
		}
		this.currentCost = 0;
		this.bestCost = 0;
	}

	/**
	 * 执行旅行商算法，返回结果的构造函数（不包含最后一个顶点到第一个顶点的路径）
	 * 
	 * @return 整个图的最短环游路线
	 * */
	public int[] salesMan() {
		MinHeap heap = new MinHeap(1000);
		// 计算最小费出边
		int[] minOut = new int[n];
		int minSum = 0;
		for (int i = 0; i < n; i++) {
			int min = NOEDGE;
			for (int j = 0; j < n; j++) {
				if (adjacencies[i][j] != NOEDGE
						&& (adjacencies[i][j] < min || min == NOEDGE)) {
					min = adjacencies[i][j];
				}
			}
			minOut[i] = min;
			minSum += min;
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		Node node = new Node(n, 0, minSum, 0, result);
		int bestCost = NOEDGE;
		while (node.middle < n - 1) {
			if (node.middle == (n - 2)) {
				if (adjacencies[node.result[n - 2]][node.result[n - 1]] != NOEDGE
						&& adjacencies[node.result[n - 1]][node.result[1]] != NOEDGE
						&& (node.currentCost
								+ adjacencies[node.result[n - 2]][node.result[n - 1]] + adjacencies[node.result[n - 1]][1]) < bestCost
						|| bestCost == NOEDGE) {
					bestCost = node.currentCost
							+ adjacencies[node.result[n - 2]][node.result[n - 1]]
							+ adjacencies[node.result[n - 1]][1];
					node.currentCost = bestCost;
					node.lowestCost = bestCost;
					node.middle++;
					heap.insert(node);
				} else {
					node.result = null;
				}
			} else {
				for (int i = node.middle; i < n; i++) {
					if (node.middle > n)
						break;
					if (adjacencies[node.result[node.middle]][node.result[i]] != NOEDGE) {
						int current = node.currentCost
								+ adjacencies[node.result[node.middle]][node.result[i]];
						int rest = node.restCost
								- minOut[node.result[node.middle]];
						int b = current + rest;
						if (n < bestCost || bestCost == NOEDGE) {
							int[] temp = new int[n];
							for (int j = 0; j < n; j++) {
								temp[j] = node.result[j];
							}
							temp[node.middle + 1] = node.result[i];
							temp[i] = node.result[node.middle + 1];
							Node posible = new Node(n, current, rest,
									node.middle + 1, temp);
							posible.lowestCost = b;
							heap.insert(posible);
						}
					}
				}
				// node.result=null;
			}
			node = heap.retrieve();
			if (heap.deleteMin() == -1) {
				break;
			}
		}
		if (bestCost == NOEDGE)
			return null;
		while (true) {
			if (heap.deleteMin() == -1) {
				break;
			}

		}
		return node.result;
	}
}
