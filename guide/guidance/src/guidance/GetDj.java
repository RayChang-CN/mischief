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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import map.Dijkstra;
import filecoper.CopeFile;

@SuppressWarnings("serial")
public class GetDj extends JFrame {
	int[][] adj;
	String[] names;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	@SuppressWarnings("rawtypes")
	private JComboBox terminal;
	@SuppressWarnings("rawtypes")
	private JComboBox begin;
	int n;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		new GetDj();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GetDj() {
		setTitle("公园导游图");
		this.setVisible(true);
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

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);
		CopeFile coper = new CopeFile();
		coper.getWords("names.txt");
		names = new String[coper.count];
		for (int i = 0; i < coper.count; i++) {
			names[i] = coper.result[i];
		}
		n = coper.count;
		JLabel label_1 = new JLabel("请选择起始景点");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		layeredPane.add(label_1, gbc_label_1);
		label_1.setVisible(true);
		this.begin = new JComboBox(names);
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
		lable.setVisible(true);
		this.terminal = new JComboBox(names);
		terminal.setVisible(true);
		GridBagConstraints gbc_terminal = new GridBagConstraints();
		gbc_terminal.fill = GridBagConstraints.BOTH;
		gbc_terminal.insets = new Insets(0, 0, 5, 0);
		gbc_terminal.gridx = 0;
		gbc_terminal.gridy = 6;
		layeredPane.add(terminal, gbc_terminal);
		terminal.setVisible(true);
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 8;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);
		JButton confirm = new JButton("确认");
		confirm.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.insets = new Insets(0, 0, 5, 0);
		gbc_confirm.gridx = 0;
		gbc_confirm.gridy = 9;
		layeredPane.add(confirm, gbc_confirm);
		int count = 0;
		adj = new int[n][n];
		coper.getWords("adjacencies.txt");
		;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = Integer.parseInt(coper.result[count++]);
			}
		}
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goOn();
			}

		});

	}

	private void goOn() {
		String start = (String) begin.getSelectedItem();
		String end = (String) terminal.getSelectedItem();
		int begin = 0;
		int tend = 0;
		for (int i = 0; i < n; i++) {
			if (names[i].equals(start)) {
				begin = i;
			}
			if (names[i].equals(end)) {
				tend = i;
			}
		}
		Dijkstra dj = new Dijkstra();
		dj.dijkstra(begin, tend, n, adj);
		new ShowDj(dj.result);
		this.dispose();
	}
}