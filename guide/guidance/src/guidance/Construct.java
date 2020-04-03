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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Construct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel tips;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Construct frame = new Construct();
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
	public Construct() {
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
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
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

		JLabel lblNewLabel = new JLabel("请输入景点总数");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		layeredPane.add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 5;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		textField = new JTextField();
		textField.setColumns(8);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		layeredPane.add(textField, gbc_textField);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					confirm();
				}

			}
		});
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 7;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);

		tips = new JLabel("请输入正确数字！");
		tips.setVisible(false);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 8;
		layeredPane.add(tips, gbc_lblNewLabel_1);
		JButton confirm = new JButton("确认");
		confirm.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.insets = new Insets(0, 0, 5, 0);
		gbc_confirm.gridx = 0;
		gbc_confirm.gridy = 9;
		layeredPane.add(confirm, gbc_confirm);
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm();
			}

		});
	}

	private void confirm() {
		if (textField.getText().length() < 1)
			return;
		String data = textField.getText();
		if (isNumeric(data)) {
			this.setVisible(false);
			new ConstructScene(Integer.parseInt(data));
			this.dispose();
		} else {
			tips.setVisible(true);
		}
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
