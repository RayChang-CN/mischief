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

@SuppressWarnings("serial")
public class Admin extends JFrame {

	private JPanel contentPane;

	public Admin() {
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
				0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);

		JLabel lblNewLabel = new JLabel("您好，管理员，请选择您要使用的功能");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		layeredPane.add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 1;
		layeredPane.add(verticalStrut_5, gbc_verticalStrut_5);

		JButton construct = new JButton("创建新图");

		construct.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_construct = new GridBagConstraints();
		gbc_construct.insets = new Insets(0, 0, 5, 0);
		gbc_construct.gridx = 0;
		gbc_construct.gridy = 2;
		layeredPane.add(construct, gbc_construct);
		construct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				construct();
			}
		});
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 3;
		layeredPane.add(verticalStrut, gbc_verticalStrut);

		JButton addScene = new JButton("增加景点");
		addScene.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_addScene = new GridBagConstraints();
		gbc_addScene.insets = new Insets(0, 0, 5, 0);
		gbc_addScene.gridx = 0;
		gbc_addScene.gridy = 4;
		layeredPane.add(addScene, gbc_addScene);
		addScene.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				constructNew();
			}
		});

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 5;
		layeredPane.add(verticalStrut_4, gbc_verticalStrut_4);

		JButton deleteS = new JButton("删除景点");
		deleteS.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_deleteS = new GridBagConstraints();
		gbc_deleteS.insets = new Insets(0, 0, 5, 0);
		gbc_deleteS.gridx = 0;
		gbc_deleteS.gridy = 6;
		layeredPane.add(deleteS, gbc_deleteS);
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 7;
		layeredPane.add(verticalStrut_2, gbc_verticalStrut_2);
		deleteS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteScene();
			}
		});

		JButton viewScene = new JButton("修改道路");
		viewScene.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_viewScene = new GridBagConstraints();
		gbc_viewScene.insets = new Insets(0, 0, 5, 0);
		gbc_viewScene.gridx = 0;
		gbc_viewScene.gridy = 8;
		layeredPane.add(viewScene, gbc_viewScene);
		viewScene.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manageRoad();
			}
		});
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 9;
		layeredPane.add(verticalStrut_3, gbc_verticalStrut_3);

		JButton manageR = new JButton("查看全图");
		manageR.setHorizontalAlignment(SwingConstants.RIGHT);
		manageR.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_manageR = new GridBagConstraints();
		gbc_manageR.insets = new Insets(0, 0, 5, 0);
		gbc_manageR.gridx = 0;
		gbc_manageR.gridy = 10;
		layeredPane.add(manageR, gbc_manageR);
		manageR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				confirm();
			}
		});

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 11;
		layeredPane.add(verticalStrut_1, gbc_verticalStrut_1);

		JButton exit = new JButton("退出");
		exit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_exit = new GridBagConstraints();
		gbc_exit.gridx = 0;
		gbc_exit.gridy = 12;
		layeredPane.add(exit, gbc_exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
	}

	protected void deleteScene() {
		this.setVisible(false);
		new DeleteScene();
		this.dispose();
	}

	protected void confirm() {
		this.setVisible(false);
		new Confirm();
		this.dispose();
	}

	protected void constructNew() {
		this.setVisible(false);
		new ConstructScene(5);
		this.dispose();
	}

	protected void construct() {
		this.setVisible(false);
		new Construct();
		this.dispose();
	}

	protected void manageScene() {
		this.setVisible(false);
		new DeleteScene();
		this.dispose();
	}

	private void manageRoad() {
		this.setVisible(false);
		new ManageRoad();
		this.dispose();

	}

	private void quit() {
		this.setVisible(false);
		new First();
		this.dispose();
	}
}
