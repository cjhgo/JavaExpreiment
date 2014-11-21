package eight;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
public class JCalculator implements MouseListener,MouseMotionListener,
KeyListener{
	private JFrame f;
	private JTextField txf;
	private JButton btn_0;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_dot;
	private JButton btn_equ;
	private JButton btn_add;
	private JButton btn_ce;
	private double op_1,op_2,result;
	private StringBuffer txf_text;
	private int op_time;	
	public static void main(String [] args){
		JCalculator tt=new JCalculator();
		tt.go();
	}	
	void go(){
		f=new JFrame("this is a calculator");
		btn_0=new JButton("0");
		btn_1=new JButton("1");
		btn_2=new JButton("2");
		btn_3=new JButton("3");
		btn_4=new JButton("4");
		btn_5=new JButton("5");
		btn_6=new JButton("6");
		btn_7=new JButton("7");
		btn_8=new JButton("8");
		btn_9=new JButton("9");
		btn_add=new JButton("+");
		btn_dot=new JButton(".");
		btn_equ=new JButton("=");
		btn_ce=new JButton("CE");
		txf=new JTextField("0");
		txf_text=new StringBuffer("");
		f.setLayout(null);
		f.setSize(350, 300);
		f.setLocation(300, 300);
		//关闭功能
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//注册监听器
		btn_0.addMouseListener(this);
		btn_1.addMouseListener(this);
		btn_2.addMouseListener(this);
		btn_3.addMouseListener(this);
		btn_4.addMouseListener(this);
		btn_5.addMouseListener(this);
		btn_6.addMouseListener(this);
		btn_7.addMouseListener(this);
		btn_8.addMouseListener(this);
		btn_9.addMouseListener(this);
		btn_add.addMouseListener(this);
		btn_dot.addMouseListener(this);
		btn_equ.addMouseListener(this);
		btn_ce.addMouseListener(this);
		btn_0.addKeyListener(this);
		btn_1.addKeyListener(this);
		btn_2.addKeyListener(this);
		btn_3.addKeyListener(this);
		btn_4.addKeyListener(this);
		btn_5.addKeyListener(this);
		btn_6.addKeyListener(this);
		btn_7.addKeyListener(this);
		btn_8.addKeyListener(this);
		btn_9.addKeyListener(this);
		btn_add.addKeyListener(this);
		btn_dot.addKeyListener(this);
		btn_equ.addKeyListener(this);
		btn_ce.addKeyListener(this);
		txf.addKeyListener(this);
		txf.setBounds(10, 40, 280, 20);
		f.add(txf);
		btn_7.setBounds(30, 70, 30, 30);
		f.add(btn_7);
		btn_8.setBounds(80, 70, 30, 30);
		f.add(btn_8);
		btn_9.setBounds(130, 70, 30, 30);
		f.add(btn_9);
		btn_4.setBounds(30, 120, 30, 30);
		f.add(btn_4);
		btn_1.setBounds(30, 170, 30, 30);
		f.add(btn_1);
		btn_5.setBounds(80, 120, 30, 30);
		f.add(btn_5);
		btn_2.setBounds(80, 170, 30, 30);
		f.add(btn_2);
		btn_6.setBounds(130, 120, 30, 30);
		f.add(btn_6);
		btn_3.setBounds(130, 170, 30, 30);
		f.add(btn_3);
		btn_0.setBounds(30, 220, 30, 30);
		f.add(btn_0);
		btn_dot.setBounds(80, 220, 30, 30);
		f.add(btn_dot);
		btn_add.setBounds(200, 70, 30, 30);
		f.add(btn_add);
		btn_ce.setBounds(250, 70, 30, 30);
		f.add(btn_ce);
		btn_equ.setBounds(130, 220, 30, 30);
		f.add(btn_equ);
		f.setVisible(true);
		btn_0.setMargin(new Insets(0,0,0,0));
		btn_1.setMargin(new Insets(0,0,0,0));
		btn_2.setMargin(new Insets(0,0,0,0));
		btn_3.setMargin(new Insets(0,0,0,0));
		btn_4.setMargin(new Insets(0,0,0,0));
		btn_5.setMargin(new Insets(0,0,0,0));
		btn_6.setMargin(new Insets(0,0,0,0));
		btn_7.setMargin(new Insets(0,0,0,0));
		btn_8.setMargin(new Insets(0,0,0,0));
		btn_9.setMargin(new Insets(0,0,0,0));
		btn_add.setMargin(new Insets(0,0,0,0));
		btn_dot.setMargin(new Insets(0,0,0,0));
		btn_equ.setMargin(new Insets(0,0,0,0));
		btn_ce.setMargin(new Insets(0,0,0,0));
		txf.setHorizontalAlignment(JTextField.RIGHT);
		op_1=op_2=result=0;op_time=0;
		txf.setEditable(false);
		txf.setBackground(Color.white);
	}
	@Override
	//处理鼠标点击
	public void mouseClicked(MouseEvent e) {		
		if(e.getSource().equals(btn_0))
			txf_text=txf_text.append("0");
		else if(e.getSource().equals(btn_1))
			txf_text=txf_text.append("1");
		else if(e.getSource().equals(btn_2))
			txf_text=txf_text.append("2");
		else if(e.getSource().equals(btn_3))
			txf_text=txf_text.append("3");
		else if(e.getSource().equals(btn_4))
			txf_text=txf_text.append("4");
		else if(e.getSource().equals(btn_5))
			txf_text=txf_text.append("5");
		else if(e.getSource().equals(btn_6))
			txf_text=txf_text.append("6");
		else if(e.getSource().equals(btn_7))
			txf_text=txf_text.append("7");
		else if(e.getSource().equals(btn_8))
			txf_text=txf_text.append("8");
		else if(e.getSource().equals(btn_9))
			txf_text=txf_text.append("9");
		else if(e.getSource().equals(btn_dot))
			txf_text=txf_text.append(".");
		txf.setText(txf_text.toString());
		//opt_time 等于0 时按下加法按钮op_1等于输入框数字
		if(e.getSource().equals(btn_add)&&op_time==0){
			op_1=Double.parseDouble(txf.getText());
			txf.setText("0");
			txf_text=new StringBuffer("");
		}		
		//opt_time 等于1 时按下加法按钮op_1等于结果,即上次运算结果
		else if(e.getSource().equals(btn_add)&&op_time==1){
			op_1=result;
			txf.setText("0");
			txf_text=new StringBuffer("");
		}		
		else if(e.getSource().equals(btn_equ)){
			op_2=Double.parseDouble(txf.getText());
			result=op_1+op_2;
			op_time=1;
			DecimalFormat ft = new DecimalFormat("#0.000");
			txf.setText(ft.format(result));			
	    }		
		//清零,使opt_time为0
		else if(e.getSource().equals(btn_ce)){
			op_1=0;op_2=0;
			txf.setText("0");
			txf_text=new StringBuffer("");
			op_time=0;
		}		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	//处理键盘输入
	public void keyPressed(KeyEvent e) {		
		if(e.getKeyChar()=='0')
			txf_text=txf_text.append("0");		
		else if(e.getKeyChar()=='1')
			txf_text=txf_text.append("1");
		else if(e.getKeyChar()=='2')
			txf_text=txf_text.append("2");
		else if(e.getKeyChar()=='3')
			txf_text=txf_text.append("3");
		else if(e.getKeyChar()=='4')
			txf_text=txf_text.append("4");
		else if(e.getKeyChar()=='5')
			txf_text=txf_text.append("5");
		else if(e.getKeyChar()=='6')
			txf_text=txf_text.append("6");
		else if(e.getKeyChar()=='7')
			txf_text=txf_text.append("7");
		else if(e.getKeyChar()=='8')
			txf_text=txf_text.append("8");
		else if(e.getKeyChar()=='9')
			txf_text=txf_text.append("9");
		else if(e.getKeyChar()=='.')
			txf_text=txf_text.append(".");		
		txf.setText(txf_text.toString());		
		if(e.getKeyChar()=='='){
			op_2=Double.parseDouble(txf.getText());
			result=op_1+op_2;
			op_time=1;
			DecimalFormat ft = new DecimalFormat("#0.000");
			txf.setText(ft.format(result));			
	    }		
		if(e.getKeyChar()=='+'&&op_time==0){
			op_1=Double.parseDouble(txf.getText());
			txf.setText("0");
			txf_text=new StringBuffer("");
		}		
		else if(e.getKeyChar()=='+'&&op_time==1){
			op_1=result;
			txf.setText("0");
			txf_text=new StringBuffer("");
		}		
		else if(e.getKeyChar()=='C' || e.getKeyChar()=='c'){
			op_1=0;op_2=0;
			txf.setText("0");
			txf_text=new StringBuffer("");
			op_time=0;
		}		
		else if(e.getKeyChar()==27){
			f.setVisible(false);
			f.dispose();
			System.exit(0);
		}		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}	
}