/*
 * 2019.12.10*/
package guidance;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import map.GuidanceMap;
import filecoper.CopeFile;

@SuppressWarnings("serial")
public class Confirm extends JFrame {

	private JPanel contentPane;
	public GuidanceMap temp;

	public Confirm() {
		setTitle("公园导游图");
		CopeFile coper = new CopeFile();
		coper.getWords("names.txt");
		String names[] = new String[coper.count];
		int m = 0;
		for (;m < coper.count; m++) {
			names[m] = coper.result[m];
		}
		this.temp=new GuidanceMap(m);
		coper.getWords("degrees.txt");
		int[] degrees = new int[m];
		for (int i = 0; i < coper.count; i++) {
			degrees[i] = Integer.parseInt(coper.result[i]);
		}
		for (int i = 0; i < m; i++) {
			temp.setScene(names[i], degrees[i]);
		}
		coper.getWords("adjacencies.txt");
		int t =coper.count;
		if(t!=0){
		int c = 0;
		for (int i = 0; i < temp.getCurrent(); i++) {
			for (int j = 0; j < temp.getCurrent(); j++) {
				temp.setAdjacency(i, j, Integer.parseInt(coper.result[c++]));
			}
		}}
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_4691653727383");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[] { 329, 0 };
		gbl_layeredPane.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_layeredPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_layeredPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		layeredPane.setLayout(gbl_layeredPane);

		JLabel lblNewLabel = new JLabel("当前导游图信息：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		layeredPane.add(lblNewLabel, gbc_lblNewLabel);

		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 9;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 1;
		layeredPane.add(textPane, gbc_textPane);
		textPane.setText(temp.toString());
		textPane.setEditable(false);
		JButton manageRoad = new JButton("修改道路");
		manageRoad.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_manageRoad = new GridBagConstraints();
		gbc_manageRoad.insets = new Insets(0, 0, 5, 0);
		gbc_manageRoad.gridx = 0;
		gbc_manageRoad.gridy = 10;
		layeredPane.add(manageRoad, gbc_manageRoad);
		manageRoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manage();
			}
		});

		JButton constructScene = new JButton("修改景点");
		constructScene.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_constructScene = new GridBagConstraints();
		gbc_constructScene.insets = new Insets(0, 0, 5, 0);
		gbc_constructScene.gridx = 0;
		gbc_constructScene.gridy = 11;
		layeredPane.add(constructScene, gbc_constructScene);
		constructScene.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				construct();
			}
		});
		JButton quit = new JButton("返回管理界面");
		quit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GridBagConstraints gbc_quit = new GridBagConstraints();
		gbc_quit.insets = new Insets(0, 0, 5, 0);
		gbc_quit.gridx = 0;
		gbc_quit.gridy = 12;
		layeredPane.add(quit, gbc_quit);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}

	protected void exit() {
		this.setVisible(false);
		new Admin();
		this.dispose();
	}

	protected void construct() {
		this.setVisible(false);
		new ConstructScene(temp.getN());
		this.dispose();
	}

	protected void manage() {
		this.setVisible(false);
		new ManageRoad();
		this.dispose();
	}

}
