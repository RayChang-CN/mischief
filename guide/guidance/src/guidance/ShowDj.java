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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import map.GuidanceMap;

@SuppressWarnings("serial")
public class ShowDj extends JFrame {
	private JPanel contentPane;
	public GuidanceMap map;
	/**
	 * Create the frame.
	 */
	public ShowDj(int[] res) {
		setTitle("公园导游图");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_4691653727383");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[] { 424, 0 };
		gbl_layeredPane.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 2;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 3;
		layeredPane.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel = new JLabel("这两个景点间的最短路径是：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		layeredPane.add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 5;
		layeredPane.add(verticalStrut, gbc_verticalStrut);

		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		layeredPane.add(label_1, gbc_label_1);
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < res.length; i++) {
			buffer.append(res[i]);
			if(i!=res.length-1){
				buffer.append("->");
			}
		}
		label_1.setText(buffer.toString());
		label_1.setVisible(true);
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 8;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		JButton backFirst = new JButton("回主程序");
		backFirst.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_backFirst = new GridBagConstraints();
		gbc_backFirst.insets = new Insets(0, 0, 5, 0);
		gbc_backFirst.gridx = 0;
		gbc_backFirst.gridy = 9;
		layeredPane.add(backFirst, gbc_backFirst);
		backFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 10;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);
		JButton exit = new JButton("退出");
		exit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_exit = new GridBagConstraints();
		gbc_exit.insets = new Insets(0, 0, 5, 0);
		gbc_exit.gridx = 0;
		gbc_exit.gridy = 11;
		layeredPane.add(exit, gbc_exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quit();
			}

		});
	}

	protected void back() {
		this.setVisible(false);
		new First();
		this.dispose();
	}

	private void quit() {

		this.dispose();

	}
}
