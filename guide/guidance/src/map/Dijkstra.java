/*
 * 2019.12.10*/
package map;

/** 迪杰斯特拉算法类，包含寻找图中两顶点单元最短路径的迪杰斯特拉算法 */
public class Dijkstra {
	/** 无连接的两个顶点间的距离 */
	private static int INFINITE = 10000;
	/** 存储传入节点的单源最短路径 */
	public int[] result;

	/**
	 * @param start
	 *            起始顶点
	 * @param end
	 *            终止顶点
	 * @param n
	 *            总顶点个数
	 * @param adj
	 *            图的邻接表
	 * */
	public void dijkstra(int start, int end, int n, int[][] adj) {
		int begin = start;
		int terminal = end;
		if (adj[start][end] != -1) {
			result = new int[2];
			result[0] = start;
			result[1] = end;
			return;
		}
		result = new int[n];
		boolean[] chosen = new boolean[n];
		for (int i = 0; i < n; i++) {
			chosen[i] = false;
		}
		chosen[start] = true;
		int path = 0;
		int min = INFINITE;
		int location = 0;
		while (start != end) {// 主循环，遍历从start到end，每次start改变，min恢复原值

			if (path + 1 > n) {
				dijkstra(terminal, begin, n, adj);
				int[] res = new int[result.length];
				for (int i = 0; i < result.length; i++) {
					res[i] = result[i];
				}
				for (int i = res.length - 1; i >= 0; i--) {
					result[res.length - 1 - i] = res[i];
				}
				return;
			}
			min = INFINITE;
			for (int i = 0; i < n; i++) {
				// 内循环， 如果当前位置不连接，跳出当前循环做下一次循环，
				// 否则找整个循环里最小的一个值,位置用location标记
				if (!chosen[i]) {
					if (adj[start][i] < 0) {
						continue;
					} else {
						if (adj[start][i] < min) {
							min = adj[start][i];
							location = i;
						}
					}
				}
			}
			result[path++] = start;
			start = location;
			chosen[start] = true;
		}
		int[] res = new int[path];
		for (int i = 0; i < path; i++) {
			res[i] = result[i];
		}
		result = res;
	}
}
