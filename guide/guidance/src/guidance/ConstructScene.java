/*
 * 2019.12.10*/
package guidance;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import map.GuidanceMap;
import filecoper.CopeFile;

@SuppressWarnings("serial")
public class ConstructScene extends JFrame {
	private JButton continueToDo;
	private JPanel contentPane;
	private JTextField degreeNumbers;
	private JTextField sceneNames;
	private JLabel tips;
	private int n;
	private String[] names;
	private int[] degrees;
	private GuidanceMap temp;
	private int count;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConstructScene frame = new ConstructScene(3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConstructScene(int n) {
		setTitle("公园导游图");
		this.setVisible(true);
		this.temp = new GuidanceMap(n);
		count = 0;
		names = new String[n];
		degrees = new int[n];
		this.n = n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_4691653727383");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[] { 307, 0 };
		gbl_layeredPane.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 2;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel label_1 = new JLabel("请输入景点名称");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		layeredPane.add(label_1, gbc_label_1);

		sceneNames = new JTextField();
		sceneNames.setColumns(10);
		GridBagConstraints gbc_sceneNames = new GridBagConstraints();
		gbc_sceneNames.insets = new Insets(0, 0, 5, 0);
		gbc_sceneNames.gridx = 0;
		gbc_sceneNames.gridy = 4;
		layeredPane.add(sceneNames, gbc_sceneNames);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 5;
		layeredPane.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel label = new JLabel("请输入和该景点相连的景点数");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		layeredPane.add(label, gbc_label);

		degreeNumbers = new JTextField();
		degreeNumbers.setColumns(10);
		GridBagConstraints gbc_degreeNumbers = new GridBagConstraints();
		gbc_degreeNumbers.insets = new Insets(0, 0, 5, 0);
		gbc_degreeNumbers.gridx = 0;
		gbc_degreeNumbers.gridy = 7;
		layeredPane.add(degreeNumbers, gbc_degreeNumbers);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 8;
		layeredPane.add(verticalStrut, gbc_verticalStrut);

		this.tips = new JLabel(" ");
		GridBagConstraints gbc_tips = new GridBagConstraints();
		gbc_tips.insets = new Insets(0, 0, 5, 0);
		gbc_tips.gridx = 0;
		gbc_tips.gridy = 9;
		layeredPane.add(tips, gbc_tips);

		this.continueToDo = new JButton("继续输入");
		continueToDo.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_continueToDo = new GridBagConstraints();
		gbc_continueToDo.insets = new Insets(0, 0, 5, 0);
		gbc_continueToDo.gridx = 0;
		gbc_continueToDo.gridy = 10;
		layeredPane.add(continueToDo, gbc_continueToDo);
		continueToDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goOn();
			}

		});
		continueToDo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					goOn();
				}

			}
		});
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 11;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);

		JButton finish = new JButton("完成输入");
		finish.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_finish = new GridBagConstraints();
		gbc_finish.anchor = GridBagConstraints.NORTH;
		gbc_finish.gridx = 0;
		gbc_finish.gridy = 12;
		layeredPane.add(finish, gbc_finish);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}

		});
	}

	private void goOn() {
		System.out.println(temp);
		if (sceneNames.getText().length() < 1)
			return;
		if (degreeNumbers.getText().length() < 1)
			return;
		String name = sceneNames.getText();
		String degree = degreeNumbers.getText();
		if (!isNumeric(degree)) {
			tips.setText("请在下方文本框中输入数字！");
			tips.setVisible(true);
			sceneNames.setText("");
			degreeNumbers.setText("");
			return;
		}
		if (!temp.setScene(name, (Integer.parseInt(degree)))) {
			tips.setText("不满足环游条件，请重新输入相连数目！");
			tips.setVisible(true);
			return;
		}
		for (int i = 0; i < count; i++) {
			if (names[i].equals(name)) {
				tips.setText("重复景点！已更新信息，现有景点数目：" + (count) + "还可输入"
						+ (n - count) + "个景点");
				tips.setVisible(true);
				return;
			}
		}
		count++;
		names[count - 1] = name;
		degrees[count - 1] = Integer.parseInt(degree);
		sceneNames.setText("");
		degreeNumbers.setText("");
		tips.setText("插入成功，现有景点数目：" + count + "还可输入" + (n - count) + "个景点");
		tips.setVisible(true);
		if (count >= n) {

			tips.setText("导游图已满！请单击按钮以确认输入。");
			tips.setVisible(true);
			continueToDo.setVisible(false);
			return;
		}

	}

	protected void finish() {
		tips.setText("处理中，请稍候。");
		CopeFile coper = new CopeFile();
		File file = new File("names.txt");
		file.delete();
		 file = new File("names.txt");
		for (int i = 0; i < temp.getN(); i++) {
			coper.writeWords(temp.getNames()[i], "names.txt");
		}
		file = new File("degrees.txt");
		file.delete();
		file = new File("degrees.txt");
		for (int i = 0; i < temp.getN(); i++) {
			coper.writeWords("" + temp.getScenes()[i].getDegree(),
					"degrees.txt");
		}
		file = new File("adjacencies.txt");
		file.delete();
		file = new File("adjacencies.txt");
		for (int i = 0; i < temp.getN(); i++) {
			for (int j = 0; j < temp.getN(); j++) {
				coper.writeWords("" + temp.getAdjacency()[i][j],
						"adjacencies.txt");
			}
		}
		this.setVisible(false);
		new Confirm();
		this.dispose();
	}

	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}