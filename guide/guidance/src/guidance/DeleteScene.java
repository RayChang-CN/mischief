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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import map.GuidanceMap;
import map.SalesMan;
import filecoper.CopeFile;

@SuppressWarnings("serial")
public class DeleteScene extends JFrame {
	@SuppressWarnings("unused")
	private String lastS;
	@SuppressWarnings("unused")
	private String lastE;
	private JPanel contentPane;
	private JLabel tips;
	private GuidanceMap temp;
	// private int count ;
	private JLayeredPane layeredPane;
	@SuppressWarnings("rawtypes")
	private JComboBox terminal;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DeleteScene() {
		setTitle("公园导游图");
		this.setVisible(true);
		this.lastS = null;
		this.lastE = null;
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

		// System.out.println(temp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_4691653727383");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[] { 239, 0 };
		gbl_layeredPane.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 4;
		layeredPane.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lable = new JLabel("请选择要删除的景点");
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		lable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lable = new GridBagConstraints();
		gbc_lable.insets = new Insets(0, 0, 5, 0);
		gbc_lable.gridx = 0;
		gbc_lable.gridy = 5;
		layeredPane.add(lable, gbc_lable);

		this.terminal = new JComboBox(temp.getNames());
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

		this.tips = new JLabel("“”“”");
		GridBagConstraints gbc_tips = new GridBagConstraints();
		gbc_tips.insets = new Insets(0, 0, 5, 0);
		gbc_tips.gridx = 0;
		gbc_tips.gridy = 8;
		layeredPane.add(tips, gbc_tips);
		tips.setVisible(false);
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 9;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);

		JButton deleteScene = new JButton("确认删除");
		deleteScene.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_deleteScene = new GridBagConstraints();
		gbc_deleteScene.insets = new Insets(0, 0, 5, 0);
		gbc_deleteScene.anchor = GridBagConstraints.NORTH;
		gbc_deleteScene.gridx = 0;
		gbc_deleteScene.gridy = 10;
		layeredPane.add(deleteScene, gbc_deleteScene);
		deleteScene.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 12;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);

		JButton goBack = new JButton("返回");
		goBack.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_goBack = new GridBagConstraints();
		gbc_goBack.insets = new Insets(0, 0, 5, 0);
		gbc_goBack.gridx = 0;
		gbc_goBack.gridy = 13;
		layeredPane.add(goBack, gbc_goBack);
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBackAdmin();
			}

		});

	}

	protected void goBackAdmin() {
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
		this.setVisible(false);
		new Admin();
		this.dispose();
	}

	protected void finish() {
		System.out.println(temp);
		String name = (String) terminal.getSelectedItem();
		System.out.println(temp.deleteScene(name));
		if (temp.deleteScene(name)) {
			tips.setText("删除成功！");
			tips.setVisible(true);
		} else {
			tips.setText("破坏环游路线！删除失败！");
			tips.setVisible(true);
		}
	}

}