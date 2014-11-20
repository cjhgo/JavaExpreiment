package four;
import java.awt.*;
import java.awt.event.*;

public class Fivefour implements ActionListener{

	private Frame mf = new Frame();
	private TextField tf0 = new TextField();
	private TextField tf1 = new TextField();
	private TextField tf2 = new TextField();
	private TextField tf3 = new TextField();
	private TextField tf4 = new TextField();
	private TextField tf5 = new TextField();
	private TextField tf6 = new TextField();
	private TextField tf7 = new TextField();
	private TextField tf8 = new TextField();
	private TextField tf9 = new TextField();
	private TextField tf10 = new TextField();
	private Button btn0 = new Button();
	private Button btn1 = new Button();
	private Button btn2 = new Button();
	private double[] myv = new double[10];
	Fivefour()
	{
		mf.setSize(400, 400);
		mf.setLocation(0, 0);
		mf.setBackground(new Color(20,20,20));
		mf.setLayout(new FlowLayout());
		tf0.setPreferredSize(new Dimension(40,20));
		tf1.setPreferredSize(new Dimension(40,20));
		tf2.setPreferredSize(new Dimension(40,20));
		tf3.setPreferredSize(new Dimension(40,20));
		tf4.setPreferredSize(new Dimension(40,20));
		tf5.setPreferredSize(new Dimension(40,20));
		tf6.setPreferredSize(new Dimension(40,20));
		tf7.setPreferredSize(new Dimension(40,20));
		tf8.setPreferredSize(new Dimension(40,20));
		tf9.setPreferredSize(new Dimension(40,20));
		tf10.setPreferredSize(new Dimension(350,20));
		btn0.setLabel("Max value");
		btn1.setLabel("Average value");
		btn2.setLabel("Min value");
		mf.add(tf0);
		mf.add(tf1);
		mf.add(tf2);
		mf.add(tf3);
		mf.add(tf4);
		mf.add(tf5);
		mf.add(tf6);
		mf.add(tf7);
		mf.add(tf8);
		mf.add(tf9);
		mf.add(btn0);
		mf.add(btn1);
		mf.add(btn2);
		mf.add(tf10);
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
	void Getvalue()
	{
		this.myv[0] = Integer.parseInt(tf0.getText());
		this.myv[1] = Integer.parseInt(tf1.getText());
		this.myv[2] = Integer.parseInt(tf2.getText());
		this.myv[3] = Integer.parseInt(tf3.getText());
		this.myv[4] = Integer.parseInt(tf4.getText());
		this.myv[5] = Integer.parseInt(tf5.getText());
		this.myv[6] = Integer.parseInt(tf6.getText());
		this.myv[7] = Integer.parseInt(tf7.getText());
		this.myv[8] = Integer.parseInt(tf8.getText());
		this.myv[9] = Integer.parseInt(tf9.getText());
	}
	double GetMax()
	{	
		Getvalue();
		double tmp = Double.MIN_VALUE;
		for(double i : this.myv)
			if(i > tmp )
				tmp = i;
		return tmp;
	}
	double GetMin()
	{
		Getvalue();
		double tmp = Double.MAX_VALUE;
		for(double i : this.myv)
			if(i < tmp )
				tmp = i;
		return tmp;
	}
	double GetAve()
	{
		Getvalue();
		double tmp = 0;
		for(double i : this.myv)
			tmp += i;
		return tmp / 10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fivefour();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn0))
		{			
			
			tf10.setText(String.valueOf(this.GetMax()));
		}		
		else if(e.getSource().equals(btn1))
		{
			
			tf10.setText(String.valueOf(this.GetAve()));
		}
		else if(e.getSource().equals(btn2))
		{
			
			tf10.setText(String.valueOf(this.GetMin()));
			
		}
	}

}
