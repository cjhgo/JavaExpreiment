package temp;
import java.awt.*;
import javax.swing.*;
//public class MyFrame extends JFrame
//{
//	JFrame frame;
//	
//	public void go()
//	{
//		frame = new MyFrame();
//		frame.setBounds(200,200,500,500);
//		frame.setTitle("绘图板");
//		frame.setLayout(new FlowLayout());
//		frame.add(new JButton("Click Me"));
//		frame.add(new JButton("Don.t Click Me"));
//		frame.setVisible(true);
//	}
//	
//	public void paint(Graphics g)                      //重写print函数，
//	{
//		g.drawRect(100, 100,300, 300);                 //绘制矩形
//		g.drawString("这样输出文字", 200, 200);         //输出文字
//		g.drawArc(100, 100, 200, 200, 0, 360);
//	}
//	
//	public static void main(String[] args) 
//	{
//		new MyFrame().go();
//	}
//
//}
public class  MyFrame
{
	private Button btn = new Button();
	MyFrame()
	{
		JFrame frame = new JFrame(){
			@Override
			public void paint(Graphics g)
			{
				g.drawLine(100, 100, 200, 200);
			}
		};
		frame.setSize(500, 500);
		frame.setBackground(new Color(100,100,100));
	
		btn.setSize(20, 20);
		btn.setBackground(new Color(100,100,100));
		frame.add(btn);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MyFrame();
	}
 
}

