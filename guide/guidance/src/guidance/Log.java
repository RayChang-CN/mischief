/*
 * 2019.12.10*/
package guidance;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Log extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel tips;
	private String password;
	private static final String key = "123456";

	public Log() {
		this.setVisible(true);
		setTitle("公园导游图");
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
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
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

		JLabel lblNewLabel = new JLabel("请在下方输入您的密码，单击按钮确认");
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

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBackground(Color.WHITE);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 7;
		layeredPane.add(passwordField, gbc_passwordField);
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					log();
				}

			}
		});

		this.tips = new JLabel("密码错误，请输入正确密码！");
		tips.setVisible(false);
		GridBagConstraints gbc_tips = new GridBagConstraints();
		gbc_tips.insets = new Insets(0, 0, 5, 0);
		gbc_tips.gridx = 0;
		gbc_tips.gridy = 8;
		layeredPane.add(tips, gbc_tips);
		JButton login = new JButton("登录");
		login.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_login = new GridBagConstraints();
		gbc_login.insets = new Insets(0, 0, 5, 0);
		gbc_login.gridx = 0;
		gbc_login.gridy = 11;
		layeredPane.add(login, gbc_login);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log();
			}

		});
	}

	private void log() {
		password = new String(passwordField.getPassword());
		System.out.println(password);
		if (password.compareTo(key) == 0) {
			this.setVisible(false);
			new Admin();
			this.dispose();
		} else
			tips.setVisible(true);
	}
}
