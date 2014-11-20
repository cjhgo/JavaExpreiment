package one;
import java.awt.*;
import java.awt.event.*;
public class Fiveone implements ActionListener{

	private Frame mf = new Frame();
	private Button btn0 = new Button();
	private Button btn1 = new Button();
	private Button btn2 = new Button();
	private TextField tf = new TextField();
	Fiveone()
	{
		mf.setSize(400, 400);
		mf.setLocation(0, 0);
		mf.setBackground(new Color(20,20,20));
		mf.setLayout(new FlowLayout());
		tf.setPreferredSize(new Dimension(350,20));
		btn0.setLabel("button 0");
		btn1.setLabel("button 1");
		btn2.setLabel("button 2");
		mf.add(tf);
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
		new Fiveone();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource().equals(btn0))
			tf.setText("button 0 is clicked");
		else if(e.getSource().equals(btn1))
			tf.setText("button 1 is clicked");
		else if(e.getSource().equals(btn2))
			tf.setText("button 2 is clicked");

		
	}

}
