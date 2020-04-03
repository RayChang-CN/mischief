/*
 * 2019.12.10*/
package guidance;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import map.GuidanceMap;
import map.SalesMan;
import filecoper.CopeFile;

@SuppressWarnings("serial")
public class ManageRoad extends JFrame {
	private String lastS;
	private String lastE;
	private JPanel contentPane;
	private JLabel tips;
	// private int count ;
	private JLayeredPane layeredPane;
	private JTextField weight;
	@SuppressWarnings("rawtypes")
	private JComboBox terminal;
	@SuppressWarnings("rawtypes")
	private JComboBox begin;
	public GuidanceMap temp;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ManageRoad() {
		this.setVisible(true);
		CopeFile coper = new CopeFile();
		coper.getWords("names.txt");
		System.out.println(coper.count);
		String names[] = new String[coper.count];
		for (int i = 0; i < coper.count; i++) {
			names[i] = coper.result[i];
		}

		coper.getWords("degrees.txt");
		int[] degrees = new int[coper.count];
		for (int i = 0; i < coper.count; i++) {
			degrees[i] = Integer.parseInt(coper.result[i]);
		}
		temp = new GuidanceMap(coper.count);
		for (int i = 0; i < coper.count; i++) {
			temp.setScene(names[i], degrees[i]);
		}
		int n = coper.count;
		coper.getWords("adjacencies.txt");
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp.setAdjacency(i, j, Integer.parseInt(coper.result[c++]));
			}
		}
		this.setVisible(true);
		setTitle("公园导游图");
		this.lastS = null;
		this.lastE = null;
		this.begin = new JComboBox(temp.getNames());
		this.terminal = new JComboBox(temp.getNames());
		// System.out.println(temp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_4691653727383");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[] { 150, 0 };
		gbl_layeredPane.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel label_1 = new JLabel("请选择起始景点");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		layeredPane.add(label_1, gbc_label_1);

		GridBagConstraints gbc_begin = new GridBagConstraints();
		gbc_begin.fill = GridBagConstraints.HORIZONTAL;
		gbc_begin.insets = new Insets(0, 0, 5, 0);
		gbc_begin.gridx = 0;
		gbc_begin.gridy = 3;
		layeredPane.add(begin, gbc_begin);
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 4;
		layeredPane.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lable = new JLabel("请选择终止景点");
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		lable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lable = new GridBagConstraints();
		gbc_lable.insets = new Insets(0, 0, 5, 0);
		gbc_lable.gridx = 0;
		gbc_lable.gridy = 5;
		layeredPane.add(lable, gbc_lable);

		GridBagConstraints gbc_terminal = new GridBagConstraints();
		gbc_terminal.fill = GridBagConstraints.BOTH;
		gbc_terminal.insets = new Insets(0, 0, 5, 0);
		gbc_terminal.gridx = 0;
		gbc_terminal.gridy = 6;
		layeredPane.add(terminal, gbc_terminal);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 7;
		layeredPane.add(verticalStrut, gbc_verticalStrut);

		JLabel lable2 = new JLabel("请输入道路长度");
		lable2.setHorizontalAlignment(SwingConstants.CENTER);
		lable2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lable2 = new GridBagConstraints();
		gbc_lable2.insets = new Insets(0, 0, 5, 0);
		gbc_lable2.gridx = 0;
		gbc_lable2.gridy = 8;
		layeredPane.add(lable2, gbc_lable2);

		this.weight = new JTextField();
		weight.setColumns(10);
		GridBagConstraints gbc_weight = new GridBagConstraints();
		gbc_weight.fill = GridBagConstraints.HORIZONTAL;
		gbc_weight.insets = new Insets(0, 0, 5, 0);
		gbc_weight.gridx = 0;
		gbc_weight.gridy = 9;
		layeredPane.add(weight, gbc_weight);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 10;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);

		this.tips = new JLabel(" ");
		GridBagConstraints gbc_tips = new GridBagConstraints();
		gbc_tips.insets = new Insets(0, 0, 5, 0);
		gbc_tips.gridx = 0;
		gbc_tips.gridy = 11;
		layeredPane.add(tips, gbc_tips);

		JButton continueToDo = new JButton("继续输入");
		continueToDo.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_continueToDo = new GridBagConstraints();
		gbc_continueToDo.insets = new Insets(0, 0, 5, 0);
		gbc_continueToDo.gridx = 0;
		gbc_continueToDo.gridy = 12;
		layeredPane.add(continueToDo, gbc_continueToDo);
		continueToDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goOn();
			}

		});

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 13;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);

		JButton finish = new JButton("完成输入");
		finish.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_finish = new GridBagConstraints();
		gbc_finish.anchor = GridBagConstraints.NORTH;
		gbc_finish.gridx = 0;
		gbc_finish.gridy = 14;
		layeredPane.add(finish, gbc_finish);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}

		});
	}

	private void goOn() {
		String start = (String) begin.getSelectedItem();
		String end = (String) terminal.getSelectedItem();
		if (lastS != null && lastE != null && lastS.compareTo(start) == 0
				&& lastE.compareTo(end) == 0) {
			tips.setText("与上次输入相同选择！无操作。");
			tips.setVisible(true);
			return;
		}
		lastS = new String(start);
		lastE = new String(end);
		String d = weight.getText();
		if (start.compareTo(end) == 0) {
			tips.setText("请选择不同景点！");
			tips.setVisible(true);
			return;
		}
		if (isNumeric(d)) {
			int distance = Integer.parseInt(d);
			if (distance <= 0) {
				tips.setText("请输入正数！");
				tips.setVisible(true);
				return;
			}
			int left = temp.setAdjacency(start, end, distance);
			if (left == -1) {
				tips.setText("超过" + start + "道路数上限，请重新输入!");
				tips.setVisible(true);
			} else {
				tips.setText("输入成功！景点" + start + "还可输入条" + left + "道路");
				tips.setVisible(true);
			}

		} else {
			tips.setText("请输入正确道路长度！");
			tips.setVisible(true);
			return;
		}
	}

	protected void finish() {
		this.setVisible(false);
		tips.setText("处理中，请稍候。");
		CopeFile coper = new CopeFile();
		File file = new File("names.txt");
		file.delete();
		for (int i = 0; i < temp.getN(); i++) {
			coper.writeWords(temp.getNames()[i], "names.txt");
		}
		file = new File("degrees.txt");
		file.delete();
		for (int i = 0; i < temp.getN(); i++) {
			coper.writeWords("" + temp.getScenes()[i].getDegree(),
					"degrees.txt");
		}
		file = new File("adjacencies.txt");
		file.delete();
		for (int i = 0; i < temp.getN(); i++) {
			for (int j = 0; j < temp.getN(); j++) {
				coper.writeWords("" + temp.getAdjacency()[i][j],
						"adjacencies.txt");
			}
		}
		SalesMan man = new SalesMan(6, temp.getAdjacency());
		int[] finalRes = new int[7];
		int[] temp = man.salesMan();
		for (int i = 0; i < 6; i++)
			finalRes[i] = temp[i];
		finalRes[6] = finalRes[0];
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < 6; i++)
			b.append(finalRes[i] + "->");
		b.append(finalRes[6]);
		file = new File("salesman.txt");
		file.delete();
		coper.writeWords(b.toString(), "salesman.txt");
		this.setVisible(false);
		new Confirm();
		this.dispose();
	}

	public boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}