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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class First extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
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
	public First() {
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
				0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		JLabel lblNewLabel = new JLabel("欢迎使用导游图系统，请选择您要使用的功能");
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

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 6;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		JButton admin = new JButton("管理系统");
		admin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_admin = new GridBagConstraints();
		gbc_admin.insets = new Insets(0, 0, 5, 0);
		gbc_admin.gridx = 0;
		gbc_admin.gridy = 7;
		layeredPane.add(admin, gbc_admin);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 8;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);
		JButton tour = new JButton("查找路线");
		tour.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_tour = new GridBagConstraints();
		gbc_tour.insets = new Insets(0, 0, 5, 0);
		gbc_tour.gridx = 0;
		gbc_tour.gridy = 9;
		layeredPane.add(tour, gbc_tour);
		tour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				travel();
			}

		});
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control();
			}
		});
	}

	private void travel() {
		System.out.println("游客");
		this.setVisible(false);
		new Search();
		this.dispose();
	}

	private void control() {
		System.out.println("管理员");
		this.setVisible(false);
		new Log();
		this.dispose();

	}
}
