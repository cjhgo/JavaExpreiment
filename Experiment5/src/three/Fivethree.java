package three;
import java.awt.*;
import java.awt.event.*;

public class Fivethree implements ActionListener {

	private Frame mf = new Frame();
	private Button btn0 = new Button();
	private Button btn1 = new Button();
	private Button btn2 = new Button();

	private TextField tf0 = new TextField();
	private TextField tf1 = new TextField();
	private TextField tf2 = new TextField();
	private int Num0;
	private int Num1;
	private int Num2;
	Fivethree()
	{
		mf.setSize(400, 400);
		mf.setLocation(0, 0);
		mf.setBackground(new Color(20,20,20));
		mf.setLayout(new FlowLayout());
		tf0.setPreferredSize(new Dimension(350,20));
		tf1.setPreferredSize(new Dimension(350,20));
		tf2.setPreferredSize(new Dimension(350,20));
		btn0.setLabel("button 0");
		btn1.setLabel("button 1");
		btn2.setLabel("button 2");
		mf.add(tf0);
		mf.add(tf1);
		mf.add(tf2);
		mf.add(btn0);
		mf.add(btn1);
		mf.add(btn2);
		mf.setVisible(true);
		mf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			} 
		});
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fivethree();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource().equals(btn0))
		{			
			this.Num0++;
			tf0.setText(String.valueOf(Num0));
		}		
		else if(e.getSource().equals(btn1))
		{
			this.Num1++;
			tf1.setText(String.valueOf(Num1));
		}
		else if(e.getSource().equals(btn2))
		{
			this.Num2++;
			tf2.setText(String.valueOf(Num2));
			
		}
		
	}

}
