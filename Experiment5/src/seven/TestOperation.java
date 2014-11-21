package seven;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestOperation implements WindowListener, MouseListener,
		ItemListener, KeyListener, ActionListener {
	//����ؼ�
	private JFrame f = new JFrame();
	private JPanel jp = new JPanel();
	private JButton btn_1 = new JButton();
	private JButton btn_2 = new JButton();
	private JTextField tf = new JTextField();
	private JRadioButton cb_1 = new JRadioButton();
	private JRadioButton cb_2 = new JRadioButton();
	private JRadioButton cb_3 = new JRadioButton();
	private JRadioButton small = new JRadioButton();
	private JRadioButton middle = new JRadioButton();
	private JRadioButton big = new JRadioButton();
	private JRadioButton cb_4 = new JRadioButton();
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private JCheckBox c_1 = new JCheckBox();
	private JCheckBox c_2 = new JCheckBox();
	private JComboBox<String> jcb = new JComboBox<String>();
	private int fontsize;
	private int mode = Font.PLAIN;
	TestOperation() {
		//ʵ������������
		fontsize = 18;
		mode = Font.PLAIN;
		f.setTitle("This is an Swing example");
		f.setSize(400, 400);
		f.setLocation(400, 200);
		f.getContentPane().setBackground(new Color(20, 120, 110));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setLayout(new FlowLayout());
		btn_1.setText("Button one");
		btn_1.setForeground(Color.blue);
		btn_1.addMouseListener(this);
		btn_2.setText("Button two");
		btn_2.setForeground(Color.red);
		btn_2.addMouseListener(this);
		tf.setText("Please input your text here");
		tf.setForeground(Color.red);
		tf.setPreferredSize(new Dimension(350, 50));
		tf.addKeyListener(this);
		tf.setFont(new Font("����_GB2312", mode, fontsize));
		c_1.setText("�Ӵ�");
		c_2.setText("б��");
		c_1.addActionListener(this);
		c_2.addActionListener(this);
		small.setText("С");
		middle.setText("��");
		big.setText("��");
		bg2.add(small);
		bg2.add(middle);
		bg2.add(big);
		middle.setSelected(true);
		small.addItemListener(this);
		big.addItemListener(this);
		middle.addItemListener(this);
		cb_1.setText("red");
		cb_1.setForeground(Color.red);
		cb_1.addItemListener(this);
		cb_2.setText("green");
		cb_2.setForeground(Color.green);
		cb_2.addItemListener(this);
		cb_3.setText("blue");
		cb_3.setForeground(Color.blue);
		cb_3.addItemListener(this);
		cb_4.setText("���أ�");
		cb_4.addItemListener(this);
		cb_4.setSelected(false);
		bg.add(cb_1);
		bg.add(cb_2);
		bg.add(cb_3);
		cb_1.setSelected(true);
		jcb.addItem("male");
		jcb.addItem("female");
		jcb.setSelectedIndex(0);
		jcb.addItemListener(this);
		jp.add(tf);
		jp.add(btn_1);
		jp.add(btn_2);
		jp.add(cb_1);
		jp.add(cb_2);
		jp.add(cb_3);
		jp.add(cb_4);
		jp.add(c_1);
		jp.add(c_2);
		jp.add(jcb);
		jp.add(small);
		jp.add(middle);
		jp.add(big);
		f.add(jp);
		f.addWindowListener(this);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TestOperation();
	}
	@Override
	//��ť��Ӧ�¼�
	public void mouseClicked(MouseEvent e) {		
		if (e.getSource().equals(btn_1))
			tf.setText("button one clicked");
		else if (e.getSource().equals(btn_2))
			tf.setText("button two clicked");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	//���ڴ���С���ָ�֮���ı�������Ϊ...����
	public void windowDeiconified(WindowEvent e) {		
		if (e.getSource().equals(f))
			tf.setText("��������״̬");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {		
		
	}
	@Override
	//�����ı������������'p'ʱ,����ı���
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(tf)) {
			if (e.getKeyChar() == 'P' || e.getKeyChar() == 'p')
				tf.setText("");
		}
	}
	@Override
	//��ť��Ӧ�¼�
	public void itemStateChanged(ItemEvent e) {		
		if (e.getSource().equals(cb_1))
			tf.setForeground(Color.red);
		if (e.getSource().equals(cb_2))
			tf.setForeground(Color.green);
		if (e.getSource().equals(cb_3))
			tf.setForeground(Color.blue);
		if (e.getSource().equals(jcb))
			tf.setText(jcb.getSelectedItem().toString());
		if (e.getSource().equals(cb_4))
			if (cb_4.isSelected())
				tf.setForeground(tf.getBackground());
			else
				tf.setForeground(Color.RED);
		if (e.getSource().equals(small)) {
			fontsize = 12;
			tf.setFont(new Font("����_GB2312", mode, fontsize));
		}

		if (e.getSource().equals(middle)) {
			fontsize = 18;
			tf.setFont(new Font("����_GB2312", mode, fontsize));
		}

		if (e.getSource().equals(big)) {
			fontsize = 24;
			tf.setFont(new Font("����_GB2312", mode, fontsize));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ע�Ͳ��ֺͷ�ע�Ͳ��ֵĹ�����һ���ģ���Ϊ����б������
		/*
		 * int mode = Font.PLAIN; if (c_2.isSelected()) mode = mode +
		 * Font.ITALIC; if (c_1.isSelected()) mode = mode + Font.BOLD;
		 * tf.setFont(new Font("����_GB2312", mode, fontsize)); this.mode = mode;
		 */
		//�ڼӴֲ��Ӵ�֮���л�
		if (e.getSource().equals(c_1) && c_1.isSelected())
			mode = mode + Font.BOLD;
		if (e.getSource().equals(c_1) && !c_1.isSelected())
			mode = mode - Font.BOLD;
		///��б�岻��б��֮���л�
		if (e.getSource().equals(c_2) && c_2.isSelected())
			mode = mode + Font.ITALIC;
		if (e.getSource().equals(c_2) && !c_2.isSelected())
			mode = mode - Font.ITALIC;
		tf.setFont(new Font("����_GB2312", mode, fontsize));
	}
}