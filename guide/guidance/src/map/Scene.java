/*
 * 2019.12.10*/
package map;

/**
 * 景点类，用于处理导游图中的景点信息，包括该景点的名称、编号、出度、已连接景点数和这些信息的设置、返回函数
 * */
public class Scene {
	/**
	 * 景点名称
	 * */
	private String name;// 名字
	/**
	 * 已经和此景点相连的景点数
	 */
	private int adjacencies;
	/**
	 * 景点的最大出度
	 */
	private int degree;// 出度
	/**
	 * 景点的编号
	 * */
	private int code;// 编号

	/**
	 * 景点的普通构造函数，生成一个新的空景点
	 */
	public Scene() {
		degree = 0;
		name = new String();
		code = -1;
		adjacencies = 0;
	}

	/**
	 * 景点的拷贝构造函数，当用已有的景点构造新景点时使用
	 * 
	 * @param copy
	 *            用作拷贝的父本
	 */
	public Scene(Scene copy) {
		degree = copy.degree;
		name = copy.name;
		code = copy.code;
		adjacencies = copy.adjacencies;
	}

	/**
	 * 景点的含参构造函数，传入经典的三个信息值，构造新景点
	 * 
	 * @param degree
	 *            出度
	 * @param name
	 *            名称
	 * @param number
	 *            编号
	 */
	public Scene(int degree, String name, int number) {
		this.degree = degree;
		this.name = name;
		this.code = number;
		this.adjacencies = 0;
	}

	/**
	 * 得到景点的出度
	 * 
	 * @return 整型，景点的出度
	 * */
	public int getDegree() {
		return degree;
	}

	/**
	 * 设置景点的出度
	 * 
	 * @param degree
	 *            景点出度
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * 得到景点名称
	 * 
	 * @return 景点名称
	 * */
	public String getName() {
		return name;
	}

	/**
	 * 设置景点名称
	 * 
	 * @param name
	 *            景点名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 得到景点编号
	 * 
	 * @return 景点编号
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置景点编号
	 * 
	 * @param code
	 *            景点编号
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 返回某个景点的特定信息
	 * 
	 * @return 字符串类型，景点的所有信息
	 * */
	@Override
	public String toString() {
		return "Scene " + code + "[name=" + name + ", the adjacencies now="
				+ adjacencies + ", degree=" + degree + ", code=" + code + "]";
	}

	/**
	 * 返回当前和该景点连接的景点数
	 * 
	 * @return 和此景点已连接的景点数
	 * */
	public int getAdjacencies() {
		return adjacencies;
	}

	/**
	 * 设置当前景点的连接数
	 * 
	 * @param adjacencies
	 *            将要和当前景点连接的景点数
	 * */
	public void setAdjacencies(int adjacencies) {
		this.adjacencies = adjacencies;
	}

	/**
	 * 返回此景点还能连接的景点数
	 * 
	 * @return 此景点还能连接的景点数
	 * */
	public int canBeAdjacent() {
		return degree - adjacencies;
	}

}
