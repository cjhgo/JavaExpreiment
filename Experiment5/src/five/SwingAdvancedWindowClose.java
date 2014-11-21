package five;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAdvancedWindowClose implements WindowListener {
	//����ؼ�
	private JFrame f = new JFrame();
	private JPanel jp = new JPanel();
	private JButton btn_1 = new JButton();
	private JButton btn_2 = new JButton();
	private JTextField tf = new JTextField();
	private JRadioButton cb_1 = new JRadioButton();
	private JRadioButton cb_2 = new JRadioButton();
	private JRadioButton cb_3 = new JRadioButton();
	private JRadioButton cb_4 = new JRadioButton();
	private ButtonGroup bg = new ButtonGroup();
	private JComboBox<String> jcb = new JComboBox<String>();
	void run() {
		//����frame����
		f.setTitle("This is an Swing example");		
		f.setSize(350, 300);
		f.setLocation(400, 200);
		f.getContentPane().setBackground(new Color(20, 120, 110));
		f.setIconImage(Toolkit.getDefaultToolkit().
				getImage("./icon/ok.png"));
		//����button,textfield,jradiobutton����
		btn_1.setText("Button one");	
		btn_1.setIcon(new ImageIcon("./icon/1.gif")); 
		btn_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_1.setForeground(Color.blue);
		btn_2.setText("Button two");	
		btn_2.setIcon(new ImageIcon("./icon/2.gif")); 
		btn_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_2.setForeground(Color.red);
		tf.setText("Please input your text here");
		tf.setForeground(Color.red);
		tf.setPreferredSize(new Dimension(320, 30));
		cb_1.setText("red");
		cb_1.setForeground(Color.red);
		cb_2.setText("green");
		cb_2.setForeground(Color.green);
		cb_3.setText("blue");
		cb_3.setForeground(Color.blue);
		cb_4.setText("married?");
		cb_4.setSelected(false);
		//�Ѱ�ť����buttongroup
		bg.add(cb_1);
		bg.add(cb_2);
		bg.add(cb_3);
		//����״̬
		cb_1.setSelected(true);
		//�����Ŀ
		jcb.addItem("male");
		jcb.addItem("female");
		//Ĭ�ϲ�ѡ��
		jcb.setSelectedIndex(0);
		//ʹ����ʽ����
		jp.setLayout(new FlowLayout());
		//�Ѳ�����ӵ�frame֮��
		jp.add(tf);		
		jp.add(btn_1);		
		jp.add(btn_2);	
		jp.add(cb_1);
		jp.add(cb_2);
		jp.add(cb_3);
		jp.add(jcb);
		jp.add(cb_4);
		f.add(jp);
		//����������Ͻǲ��ر�
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Ϊ����ע�������
		f.addWindowListener(this);
		//�ɼ�
		f.setVisible(true);
	}
	public static void main(String[] args) {
		//�½�ʵ��
		new SwingAdvancedWindowClose().run();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	//��д�������Ĺرշ���
	public void windowClosing(WindowEvent e) {		
		if (e.getSource().equals(f)) {
			//ʹ��ģʽ�Ի���ľ�̬�������������Ի���
			int x = JOptionPane.showOptionDialog(f, "�Ƿ�رճ���", 
					"����һ��ѡ��Ի���",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			//�رճ���
			if (x == JOptionPane.YES_OPTION) 				
				System.exit(0);
			//��������Ի���
			else if (x == JOptionPane.NO_OPTION) {
				String s[] = new String[3];
				s[0] = "First";
				s[1] = "Second";
				s[2] = "Third";
				Object obj = JOptionPane.showInputDialog(null, "��ѡ��",
						"����һ��ѡ���",
						JOptionPane.INFORMATION_MESSAGE, null, s, s[2]);				
				if(obj!=null) {
					if(!obj.toString().isEmpty() )
						System.out.println(obj.toString());
					else if(obj.toString().isEmpty() )
						System.out.println("nothing inputed");
				}				
				else 
					System.out.println("InputDialog cancelled");				
				}
			else 
				System.out.println("OptionDialog cancelled");
			}
	}	
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
}
