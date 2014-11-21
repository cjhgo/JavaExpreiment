package five;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAdvancedWindowClose implements WindowListener {
	//定义控件
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
		//设置frame属性
		f.setTitle("This is an Swing example");		
		f.setSize(350, 300);
		f.setLocation(400, 200);
		f.getContentPane().setBackground(new Color(20, 120, 110));
		f.setIconImage(Toolkit.getDefaultToolkit().
				getImage("./icon/ok.png"));
		//设置button,textfield,jradiobutton属性
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
		//把按钮加入buttongroup
		bg.add(cb_1);
		bg.add(cb_2);
		bg.add(cb_3);
		//设置状态
		cb_1.setSelected(true);
		//添加条目
		jcb.addItem("male");
		jcb.addItem("female");
		//默认不选中
		jcb.setSelectedIndex(0);
		//使用流式布局
		jp.setLayout(new FlowLayout());
		//把部件添加到frame之上
		jp.add(tf);		
		jp.add(btn_1);		
		jp.add(btn_2);	
		jp.add(cb_1);
		jp.add(cb_2);
		jp.add(cb_3);
		jp.add(jcb);
		jp.add(cb_4);
		f.add(jp);
		//点击窗口右上角不关闭
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//为窗口注册监听器
		f.addWindowListener(this);
		//可见
		f.setVisible(true);
	}
	public static void main(String[] args) {
		//新建实例
		new SwingAdvancedWindowClose().run();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	//重写监听器的关闭方法
	public void windowClosing(WindowEvent e) {		
		if (e.getSource().equals(f)) {
			//使用模式对话框的静态工厂方法创建对话框
			int x = JOptionPane.showOptionDialog(f, "是否关闭程序", 
					"这是一个选项对话框",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			//关闭程序
			if (x == JOptionPane.YES_OPTION) 				
				System.exit(0);
			//弹出输入对话框
			else if (x == JOptionPane.NO_OPTION) {
				String s[] = new String[3];
				s[0] = "First";
				s[1] = "Second";
				s[2] = "Third";
				Object obj = JOptionPane.showInputDialog(null, "请选择",
						"这是一个选择框",
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
