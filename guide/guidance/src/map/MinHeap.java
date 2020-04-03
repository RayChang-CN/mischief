/*
 * 2019.12.10*/
package map;

/** 最小堆类，生成一个最小堆，并实现其增删改查 */
public class MinHeap {
	/**
	 * 存放最小堆中元素的数组
	 * */
	private Node entry[];
	/** 当前堆中元素的个数 */
	private int count;
	/**
	 * 最小堆的尾指针
	 * */
	private int rear;

	/**
	 * 构造函数，生成一个指定大小的最小堆
	 * 
	 * @param number
	 *            最小堆的大小
	 * */
	public MinHeap(int number) {
		rear = -1;
		this.count = number;
		entry = new Node[number];
	}

	/**
	 * 将顶点元素添加在队列中，并根据优先级排列
	 * 
	 * @param node
	 *            要插入的顶点
	 **/
	public void insert(Node node) {
		{
			if (empty())
			// 如果队列为空，直接在其中添加元素，返回
			{
				entry[++rear] = new Node(node);
				return;
			}
			if (rear >= count - 1)
			// 如果队列已满，标记上溢，返回
			{
				return;
			}
			// 队列不空不满，rear向后移动一个位置，标记队列中最后一个元素的位置
			entry[++rear] = new Node(node);
			for (int i = rear; i > 0; i = (i - 1) / 2)
			// 从队尾向队首进行比较，每次比较当前元素和其父节点元素的优先级
			{
				if (entry[(i - 1) / 2].lowestCost < node.lowestCost)
				// 如果当前元素的优先级比其父节点元素的优先级大，交换其位置
				{
					Node temp = new Node(entry[i]);
					entry[i] = new Node(entry[(i - 1) / 2]);
					entry[(i - 1) / 2] = new Node(temp);
				}
			}
		}

	}

	/**
	 * 判断最小堆是否为空
	 * 
	 * @return 返回真当前堆为空，为假不空
	 * */
	public boolean empty() {
		return rear == -1;
	}

	/**
	 * 作用：取队首元素，不改变原队列中的元素
	 * 
	 * @return 队首顶点
	 **/
	public Node retrieve() {
		if (empty()) {
			return null;// 队列为空，下溢
		}
		return new Node(entry[0]);
	}

	/**
	 * 作用：删除队首元素
	 * 
	 * @return 是否删除成功，返回1删除成功，返回-1删除不成功
	 **/
	public int deleteMin() {
		{
			if (empty())
			// 队列为空，下溢，返回
			{
				return -1;
			}
			if (rear == 0)
			// 只有一个元素时，置空，返回
			{
				rear = -1;
				return 1;
			}
			entry[0] = new Node(entry[rear--]);
			// 将队尾元素赋给队首，随后在不越界的条件下对其位置进行调整
			if (rear == 0)
				return 1;// 删除后只有一个元素，返回
			if (rear == 1)
			// 删除后只有两个元素，调整其位置后返回
			{
				if (entry[0].lowestCost < entry[1].lowestCost)
				// 如果根为较小的一个，交换其位置
				{
					Node temp = new Node(entry[0]);
					entry[0] = new Node(entry[1]);
					entry[1] = new Node(temp);
				}
				return 1;
			}
			for (int i = 0; i <= ((rear - 1) / 2);)
			// 队列中有三个以上元素时，自顶向下进行比较，每次比较当前元素和其左右子节点元素的优先级
			{
				if ((i * 2 + 2) > rear)
					return 1;
				// 如果i位置元素的右子节点越界，返回
				int bigger = entry[i * 2 + 1].lowestCost > entry[i * 2 + 2].lowestCost ? (i * 2 + 1)
						: (i * 2 + 2);
				// 标记当前元素子节点中优先级较大的元素位置
				boolean flag = false;
				// 标记是否发生交换，为真表示发生交换
				if (entry[i].lowestCost < entry[bigger].lowestCost)
				// 如果当前元素的优先级比bigger位置元素的优先级小，交换其位置
				{
					Node temp = new Node(entry[i]);
					entry[i] = new Node(entry[bigger]);
					entry[bigger] = temp;
					flag = true;
				}
				if (!flag)
					return 1;
				// 如果没发生交换，则当前元素比左右节点中优先级较大的元素优先级还高，不需继续
				i = bigger;// i移动到当前元素被重新放置的位置，或左右子节点中
			}
			return 1;
		}
	}
}
