/*
 * 2019.12.10*/
package map;

/**
 * 最小堆的顶点类，应用于旅行商算法
 * */
public class Node {
	/** 图中所有顶点的个数 */
	int n;
	/** 最小耗费 */
	public int lowestCost;
	/** 当前耗费 */
	public int currentCost;
	/** 剩余可用耗费 */
	public int restCost;
	/** 当前路径的最后一个元素下标 */
	public int middle;
	/** 当前最短路径数组 */
	public int[] result;

	/**
	 * 构造函数，生成一个包含指定内容的顶点类
	 * 
	 * @param n
	 *            当前图中顶点总数
	 * @param currentCost
	 *            要更新的最小耗费
	 * @param restCost
	 * 
	 *            要更新的剩余耗费
	 * @param middle
	 *            要更新的下一个顶点
	 * @param result
	 *            要更新的路径
	 * 
	 * */
	public Node(int n, int currentCost, int restCost, int middle, int[] result) {
		this.n = n;
		this.lowestCost = 0;
		this.currentCost = currentCost;
		this.restCost = restCost;
		this.middle = middle;
		this.result = new int[n];
		for (int i = 0; i < n; i++) {
			this.result[i] = result[i];
		}
	}

	/** 空构造函数，生成一个默认大小的顶点 */
	public Node() {
		n = 100;
		lowestCost = 0;
		currentCost = 0;
		restCost = 0;
		middle = 0;
		result = new int[100];
	}

	/**
	 * 拷贝构造函数，生成指定顶点的父本，并将其中所有元素的值赋值进去
	 * */
	public Node(Node node) {
		this.n = node.n;
		this.result = new int[n];
		this.lowestCost = node.lowestCost;
		this.currentCost = node.currentCost;
		this.restCost = node.restCost;
		this.middle = node.middle;
		for (int i = 0; i < n; i++) {
			this.result[i] = node.result[i];
		}
	}
}
