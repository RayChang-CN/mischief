package map;

/**
 * 导游图模型类，用于存储和管理导游图中的景点和各个景点间的连接关系； 存有当前导游图中的最大景点数、当前已有的景点数、各景点信息的数组、各景点名称和邻接表
 * */
public class GuidanceMap {
	/** 当前导游图中的最大景点数 */
	private int n;// 最大景点数
	/** 当前导游图中已有的景点数 */
	private int current;// 当前景点数
	/** 当前导游图中包含的各个景点信息 */
	private Scene[] scenes;
	/** 当前导游图中所哟景点的姓名数组 */
	String[] names;
	/** 当前导游图的邻接表，存有该导游图的邻接矩阵 */
	int[][] adjacency;

	/**
	 * 返回包含所有景点的数组
	 * 
	 * @return scenes 所有景点的数组
	 */
	public Scene[] getScenes() {
		return scenes;
	}

	/**
	 * 普通构造函数，生成一个空的导游图
	 */
	public GuidanceMap() {
		this.n = 0;
		this.current = 0;
		this.scenes = null;
		this.names = null;
		this.adjacency = null;
	}

	/**
	 * 带参数的构造函数，生成含有n个节点的空图
	 * 
	 * @param n
	 *            将要生成空图中的最大景点数
	 */
	public GuidanceMap(int n) {
		this.n = n;
		this.current = 0;
		this.scenes = new Scene[n];
		this.names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = null;
		}
		this.adjacency = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adjacency[i][j] = -1;
			}
		}
	}

	public GuidanceMap(GuidanceMap copy) {
		this.n = copy.n;
		this.current = copy.current;
		this.scenes = new Scene[n];
		this.names = new String[n];
		for (int i = 0; i < n; i++) {
			scenes[i] = copy.scenes[i];
			names[i] = copy.names[i];
		}
		this.adjacency = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adjacency[i][j] = copy.adjacency[i][j];
			}
		}
	}

	public String[] getNames() {
		return names;
	}

	/**
	 * 返回当前导游图中可含有的最大景点数
	 * 
	 * @return 最大景点数
	 */
	public int getN() {
		return n;
	}

	/**
	 * 设置当前导游图中可含有的最大景点数
	 * 
	 * @param n
	 *            将要设置的最大景点数
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * 返回导游图的邻接矩阵
	 * 
	 * @return 二维数组，其中存放着导游图的邻接矩阵，非负值代表该出节点的路径长度，-1表示该处两景点不相连
	 * */
	public int[][] getAdjacency() {
		return adjacency;
	}

	/**
	 * 返回当前导游图中含有的景点数
	 * 
	 * @return 导游图中当前的景点数
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * 返回某两个景点间的路径长度
	 * 
	 * @param start
	 *            开始景点的编号
	 * @param end
	 *            结束景点的编号
	 * @return 传入的两个景点间的路径长度
	 */
	public int getWeight(int start, int end) {
		return adjacency[start][end];
	}

	/**
	 * 返回某两个景点间的路径长度
	 * 
	 * @param start
	 *            开始景点的编号
	 * @param end
	 *            结束景点的编号
	 * @return 传入的两个景点间的路径长度
	 */
	public int getWeight(String start, String end) {
		int s_start = findScene(start);
		int s_end = findScene(end);
		if (s_start != -1 && s_end != -1) {
			return adjacency[s_start][s_end];
		}
		return 0;
	}

	/**
	 * 设置邻接表，当将要设置邻接关系的两个景点都还能继续连接其他景点的时候，函数正常工作，否则不能正常运行
	 * 
	 * @param start
	 *            开始景点的编号
	 * @param end
	 *            结束景点的编号
	 * @param distance
	 *            两景点间的距离
	 * @return 返回值为-1表示函数没能正常工作，需要进一步的处理，返回值如果是其他值，表示函数正常工作，其实景点还能在连接此数目额其他景点
	 * */
	public int setAdjacency(int start, int end, int distance) {
		if (scenes[start].canBeAdjacent() > 0
				&& scenes[end].canBeAdjacent() > 0 && distance > 0) {
			adjacency[start][end] = distance;
			adjacency[end][start] = distance;
			scenes[start].setAdjacencies(scenes[start].getAdjacencies() + 1);
			scenes[end].setAdjacencies(scenes[end].getAdjacencies() + 1);
			return scenes[start].getDegree() - 1;
		}
		return -1;
	}

	/**
	 * 设置某个名称下的两个景点间的连接关系
	 * 
	 * @param start
	 *            开始景点的名称
	 * @param end
	 *            结束景点的名称
	 * @param distance
	 *            两景点间的距离
	 * @return 返回值为-1表示函数没能正常工作，需要进一步的处理，返回值如果是其他值，表示函数正常工作，其实景点还能在连接此数目额其他景点
	 * */
	public int setAdjacency(String start, String end, int distance) {
		int s_start = findScene(start);
		int s_end = findScene(end);
		if (s_start != -1 && s_end != -1) {
			return setAdjacency(s_start, s_end, distance);
		}
		return -1;
	}

	/**
	 * * *向导游图中插入景点，成功返回真， 不成功返回假
	 * 
	 * @param name
	 *            要插入的景点名称
	 * @param degree
	 *            要插入的景点出度
	 * @return 如果成功插入，返回真，如果插入破话哈密顿环，返回假
	 */
	public boolean setScene(String name, int degree) {
		// 如果要已经存在这个景点，修改出度,但要保证存在哈密顿环
		int code = findScene(name);
		if (findScene(name) >= 0) {
			if (degree > scenes[code].getDegree()) {
				scenes[code].setDegree(degree);
				return true;
			} else {
				int old = scenes[code].getDegree();
				scenes[code].setDegree(0);
				if (makeHamiltonNum(degree)) {
					scenes[code].setDegree(degree);
					return true;
				} else {
					scenes[code].setDegree(old);
					return false;
				}
			}
		} else {
			// 不存在这个景点
			if (makeHamiltonNum(degree) || current <= 2) {
				// 如果满足哈密顿环
				// 如果图已经满了，扩容
				if (current == n) {
					resize(n * 2);
					return setScene(name, degree);
				}
				// 正常情况下，不重复不满可以插入
				code = makeCode();
				names[code] = name;
				scenes[code] = new Scene(degree, name, code);
				current++;
				return true;
			} else {
				// 如果不满足哈密顿环
				return false;
			}
		}
	}

	/**
	 * 根据哈密顿环定理，判断更新了该出度之后是否至少有一对景点的出度大于当前所有节点数-1，即判断当前的图是否具有哈密顿环
	 * 
	 * @param newDegree
	 *            将要更新的出度
	 * @return 如果不破话哈密顿环，返回真，如果破坏哈密顿环，返回假
	 * */
	private boolean makeHamiltonNum(int newDegree) {
		for (int i = 0; i < current; i++) {
			if (scenes[i].getDegree() + newDegree >= (current - 1)) {
				return true;
			}
		}
		return false;
	}

	/***
	 * 如果当前的导游图容量过大或过小，需要改变容量，调用此函数生成一张新的导游图，并将原图的所有信息赋在其中
	 * 
	 * @param i
	 *            将要改变额新图容量
	 * */
	private void resize(int i) {
		Scene[] stemp = new Scene[i];
		String[] ntemp = new String[i];
		int[][] atemp = new int[i][i];
		for (int u = 0; u < i; u++) {
			for (int v = 0; v < i; v++) {
				atemp[u][v] = -1;
			}
		}
		for (int j = 0; j < n; j++) {
			stemp[j] = this.scenes[j];
			ntemp[j] = this.names[j];
		}
		for (int u = 0; u < n; u++) {
			for (int v = 0; v < n; v++) {
				atemp[u][v] = this.adjacency[u][v];
			}
		}
		this.scenes = stemp;
		this.n = i;
		this.names = ntemp;
		this.adjacency = atemp;
		stemp = null;
		ntemp = null;
		atemp = null;
	}

	/**
	 * 
	 * 生成某个景点的编码，其编码值和该景点的名称在名称数组中的下标一致，名称数组实际上是所有景点在该图中的索引
	 * 
	 * @return 可用于当前景点的编码值
	 * */
	private int makeCode() {
		int code = 0;
		for (; code < n; code++) {
			if (names[code] == null) {
				break;
			}
		}
		return code;
	}

	/**
	 * 查找景点是否存在在当前的导游图中
	 * 
	 * @param name
	 *            要查找的景点名称
	 * @return 找到了返回编号（非负数），找不到返回-1
	 */
	public int findScene(String name) {
		for (int i = 0; i < n; i++) {
			if (names[i] != null && names[i].compareTo(name) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 删除景点 需注意删除时仍然保证整个图符合哈密顿环定理
	 * 
	 * @return 景点存在返回真，景点不存在返回假/
	 * @param name
	 *            将要删除的景点名称
	 */
	public boolean deleteScene(String name) {
		int code = findScene(name);
		// 不存在和景点，直接删除
		if (code < 0) {
			return false;
		}
		// 现场保护
		int old = scenes[code].getDegree();
		scenes[code].setDegree(0);
		if (!makeHamiltonNum(0)) {
			// 如果删除之后不满足哈密顿环，则恢复原值
			scenes[code].setDegree(old);
			return false;
		} else {
			// 删除之后仍满足哈密顿环
			scenes[code] = new Scene();
			names[code] = null;
			for (int i = 0; i < n; i++) {
				adjacency[code][i] = -1;
				adjacency[i][code] = -1;
			}
			current--;
			if (current < n / 2) {
				deleteNull();
			}
			return true;
		}
	}

	/**
	 * 节省空间， 如果在当前导游图中删除了太多的景点，使得存放信息的各个数组都存在了一些冗余，调整数组大小，将原有的所有信息存放在新的图中
	 * */
	private void deleteNull() {
		int[] fullUnit = new int[current];
		int fu = 0;
		for (int u = 0; u < n; u++) {
			if (names[u] == null) {
				continue;
			} else {
				fullUnit[fu++] = u;
			}
		}
		n = current;
		Scene[] stemp = new Scene[n];
		String[] ntemp = new String[n];
		int[][] atemp = new int[n][n];
		for (int i = 0; i < n; i++) {
			stemp[i] = scenes[fullUnit[i]];
			ntemp[i] = names[fullUnit[i]];
			for (int j = 0; j < n; j++) {
				atemp[i][j] = adjacency[fullUnit[i]][fullUnit[j]];
			}
		}
		this.scenes = stemp;
		this.names = ntemp;
		this.adjacency = atemp;
		stemp = null;
		ntemp = null;
		atemp = null;
	}

	/**
	 * 返回图中各个值的信息
	 * 
	 * @return 包含各个值信息的字符串
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Guidance map : n = " + n + "\ncurrent scenes : "
				+ current + "\n");
		for (int i = 0; i < n; i++) {
			buffer.append(scenes[i] + "\n");
		}
		buffer.append("names:[");
		for (int i = 0; i < n; i++) {
			buffer.append(names[i] + "  ");
		}
		buffer.append("]\nadjacency: \n");
		for (int i = 0; i < n; i++) {
			buffer.append("[  ");
			for (int j = 0; j < n; j++) {
				if (adjacency[i][j] > 0 && adjacency[i][j] < 10) {
					buffer.append(" " + adjacency[i][j] + "   ");
				} else {
					buffer.append(+adjacency[i][j] + "   ");
				}
			}
			buffer.append("]\n");
		}
		return buffer.toString();
	}

}
