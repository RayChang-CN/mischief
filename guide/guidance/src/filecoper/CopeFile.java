/**
 * 2019.12.10*/
package filecoper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 张峰瑞 1706020228 2019/4/30
 *         查找单词表中的重复字母对，并输出重复字母最多的单词，如果有多个重复次数相同的单词，输出第一个单词
 * */
public class CopeFile {
	/**
	 * 标记重复单词的个数
	 * */
	public String[] result;
	public int count;

	public CopeFile() {
		result = new String[100];
		count = 0;
	}

	/**
	 * @param fileName
	 *            String类，要读取字符串的文件名 输入一个当前目录下的文件名，对其中的字符串进行读取
	 * */

	public void getWords(String fileName) {
		File file = new File(fileName);
		try {

			FileReader reader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(reader);
			String word = new String();
			int i = 0;
			while ((word = buffer.readLine()) != null) {
				result[i++] = word;
				count = i;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * @param word
	 *            读取要写入的字符串 将一个单词写入指定文件
	 * */
	public void writeWords(String word, String fileName) {
		try {
			File file = new File(fileName);
			FileWriter newFile = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(newFile);
			writer.write(word);
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}