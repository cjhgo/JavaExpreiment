package six;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JMenuTest implements ActionListener, MouseListener {
	//����˵���,�˵�,�˵���,���,����
	private JMenuBar jmb;
	private JMenu SelectOperation, SelectColor_1,SelectColor_2;	
	private JPopupMenu jpm;
	private JMenuItem red_1,red_2,green_1,green_2,blue_1,blue_2,
	exit_1,exit_2;
	private JPanel jp;
	private JFrame jf;	
	void run() {
		//����ʵ��,��������
		jf = new JFrame();
		jp = new JPanel();
		jpm = new JPopupMenu();		
		jmb = new JMenuBar();		
		SelectColor_1 = new JMenu();
		SelectOperation = new JMenu();
		SelectColor_2 = new JMenu();		
		red_1 = new JMenuItem();		
		red_2= new JMenuItem();
		green_1= new JMenuItem();
		green_2= new JMenuItem();
		blue_1= new JMenuItem();
		blue_2= new JMenuItem();
		exit_1= new JMenuItem();
		exit_2= new JMenuItem();		
		jf.setTitle("�˵������");
		red_1.setText("��ɫ");
		red_2.setText("��ɫ");
		green_1.setText("��ɫ");
		green_2.setText("��ɫ");
		blue_1.setText("��ɫ");
		blue_2.setText("��ɫ");
		exit_1.setText("�˳�");
		exit_2.setText("�˳�");		
		SelectColor_1.setText("ѡ����ɫ");
		SelectOperation.setText("ѡ�����");
		SelectColor_2.setText("ѡ����ɫ");		
		SelectColor_1.add(red_1);		
		SelectColor_1.add(green_1);		
		SelectColor_1.add(blue_1);	
		SelectOperation.add(exit_1);
		SelectOperation.addSeparator();		
		SelectOperation.add(SelectColor_1);
		SelectColor_2.add(red_2);
		SelectColor_2.add(green_2);
		SelectColor_2.add(blue_2);			
		jmb.add(SelectOperation);		
		jpm.add(SelectColor_2);	
		jpm.addSeparator();
		jpm.add(exit_2);		
		jf.add(jp);
		jf.setJMenuBar(jmb);		
		jf.setVisible(true);
		jf.setSize(500, 400);
		jf.setLocation(400,200);		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		//ע�������
		jp.addMouseListener(this);		
		red_1.addActionListener(this);	
		red_2.addActionListener(this);	
		green_1.addActionListener(this);	
		green_2.addActionListener(this);	
		blue_1.addActionListener(this);
		blue_2.addActionListener(this);	
		exit_1.addActionListener(this);	
		exit_2.addActionListener(this);
	}	
	public static void main(String[] args) {
		//����ʵ������
		new JMenuTest().run();
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		//ѡ�в˵��͵���ʽ�˵��е��˳���ť������˳�,
		if(e.getSource().equals(exit_1)||e.getSource().equals(exit_2)) 
			System.exit(0);	
		//ͨ����ť������屳��ɫ
		else if(e.getSource().equals(red_1) || e.getSource().equals(red_2))
			jp.setBackground(Color.red);
		else if(e.getSource().equals(green_1) || e.getSource().equals(green_2))
			jp.setBackground(Color.green);
		else if(e.getSource().equals(blue_1) || e.getSource().equals(blue_2))
			jp.setBackground(Color.blue);					
	}
	@Override
	//������ϵ������Ҽ��ǵ����˵�
	public void mouseClicked(MouseEvent e) {		
		if(e.getSource().equals(jp)) {
			if(e.getButton()==MouseEvent.BUTTON3) {				
				jpm.show(jp, e.getX(), e.getY());
			}			
		}		
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
}