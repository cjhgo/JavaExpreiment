package four;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import four.ConSql;
public class MFrame extends JFrame implements ActionListener{
	JPanel jptop = new JPanel();
	JButton contact = new JButton("我的联系人");
	JLabel jtf = new JLabel("联系簿管理系统");
	MFrame()
	{
		this.setTitle("联系簿管理系统");
		this.setSize(600,600);
		this.setLocation(300, 50);
		run();
	}
	public void run()
	{
			
//			this.setLayout(null);
			
			jptop.setLayout(new CardLayout());
			
			contact.setBounds(50,50,500,500);
			
			jtf.setBounds(250, 0, 120, 40);
			
			
			contact.addActionListener(this);
			
			
			JPanel jp = new JPanel();
			jp.setLayout(null);
			jp.add(contact);
			
			jp.add(jtf);
			
			
			jptop.add(jp);
			jptop.add(new Tpanel("contact",jptop),"contact");
			


			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(jptop);
			this.setVisible(true);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
			JOptionPane.showMessageDialog(new MFrame(), "欢迎使用联系簿管理系统");
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		CardLayout cl = (CardLayout)jptop.getLayout();
		if(e.getSource().equals(contact))
		{
			
			cl.show(jptop, "contact");
		}
		
	}
}
class Tpanel extends JPanel 
{
	String tname;
	JPanel sjp;
	Mtable mtab;
	JButton back = new JButton("返回主界面");
	JButton addrecord = new JButton("增加一条数据");
	Tpanel(String s,JPanel jp)
	{
		this.tname = s;
		this.sjp = jp;
		this.setLayout(new FlowLayout());
		this.add(new JButton(s));
		this.add(back);
		mtab = ConSql.GetTable(s);
		JScrollPane temp = new JScrollPane(mtab);
		temp.setPreferredSize(new Dimension(700,400));
		this.add(temp);
		this.add(addrecord);
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				CardLayout cl = (CardLayout)sjp.getLayout();
//				mtab = ConSql.GetTable(s);
				cl.first(sjp);
			}
		});
		addrecord.addActionListener(new Mdialog(mtab,tname,addrecord));
	}
}
