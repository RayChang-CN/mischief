import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 2019/5/14 窗口类设计，包含两个文本框和两个按钮，可以在左边的文本框输入单词，
 *         点击左边的按钮后会将左边的单词，按字典序排序后在右边的文本框输出， 点击右边的按钮会将两个文本框清空。
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame 
{
	/**
	 * 左边的按钮
	 */
	JButton buttonRight;
	/**
	 * 右边的按钮
	 */
	JButton buttonLeft;
	/**
	 * 左边的文本框
	 */
	JTextArea textLeft;
	/**
	 * 左边的文本框
	 */
	JTextArea textRight;

	/**
	 * 右边的文本框
	 */
	/**
	 * 构造函数，对每个组建赋初值，设定其所在位置
	 */
	MyFrame() 
	{
		buttonLeft = new JButton("字典排序");
		buttonRight = new JButton("清空");
		textLeft = new JTextArea();
		textRight = new JTextArea();
		this.setLayout(null);
		this.add(textLeft);
		this.setBounds(200, 200, 800, 400);
		textLeft.setBounds(200, 20, 100, 200);
		textLeft.setVisible(true);
		this.add(textRight);
		textRight.setBounds(500, 20, 100, 200);
		textRight.setVisible(true);
		textRight.setEditable(false);
		this.add(buttonLeft);
		buttonLeft.setBounds(200, 300, 100, 20);
		buttonLeft.setVisible(true);
		buttonLeft.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				sort();
			}
		});
		this.add(buttonRight);
		buttonRight.setBounds(500, 300, 100, 20);
		buttonRight.setVisible(true);
		buttonRight.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				clear();
			}
		});
		setVisible(true);
		validate();
	}

	/**
	 * 将两个文本框的内容清空
	 */
	private void clear() 
	{
		textLeft.setText("");
		textRight.setText("");
	}

	/**
	 * 调用getWords函数获取左边文本框中的单词， 调用dictionary函数将其排序，判空后在右边文本框输出，每个单词一行
	 */
	private void sort() 
	{
		String[] words = getWords();
		dictionary(words);
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].equals(null)) 
			{
				return;
			}
			System.out.println(words[i]);
			textRight.append(words[i] + "\n");
		}
	}

	/**
	 * @param words
	 *            左边文本框中获取的单词数组，String类型 在原数组中用冒泡法将数组中的字符串按字典序排序
	 **/
	private void dictionary(String[] words) 
	{
		for (int i = 0; i < words.length; i++) 
		{
			if (words[i].equals(null)) 
			{
				return;
			}
			for (int j = i + 1; j < words.length; j++)
			{
				if (words[i].compareTo(words[j]) > 0)
				{
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
	}

	/**
	 * @return String数组，包含左边文本框中纯字母的字符串 获取左边文本框中的字母后，用\n作为换行符进行分割，并过滤其中纯字母的字符串，
	 *         将最后得到的字符串数组返回
	 */
	private String[] getWords()
	{
		String left = textLeft.getText();
		StringTokenizer token = new StringTokenizer(left, "\n");
		int count = token.countTokens();
		String[] words = new String[count];
		int i = 0;
		while (token.hasMoreTokens()) 
		{
			String current = token.nextToken();
			if (current.matches("\\p{Alpha}+"))
			{
				words[i] = current;
				i++;
			}
		}
		String[] result = new String[i];
		for (int j = 0; j < i; j++) 
		{
			result[j] = words[j];
		}
		return result;
	}
}
