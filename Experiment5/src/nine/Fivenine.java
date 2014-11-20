package nine;
import java.awt.*;
import javax.swing.*;

public class Fivenine {

	private JFrame myf = new JFrame("my notepad");
	private JTextArea myt = new JTextArea();
	private TextField tf = new TextField();
	Fivenine()
	{
		myf.setSize(400,600);
		myf.setLocation(50, 50);
		myf.setBackground(new Color(0,50,50));
		
		myt.setColumns(40);
		myt.setRows(10);
		
		tf.setPreferredSize(new Dimension(380,600));
		myf.add(myt);
		
//		myf.add(tf);
		
		myf.setLayout(new FlowLayout());
		myf.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fivenine();
	}

}
