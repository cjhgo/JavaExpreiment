package four;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Maction extends AbstractAction{

	private String tname;
	private Object[][] cur_data;
	private Object[] t_title;
	private int row_n;
	private int col_n;
	private int choice;
	Maction(int row,int col,int flag,String s)
	{
		this.tname = s;
		this.row_n = row;
		this.col_n = col;
		this.choice = flag;
		cur_data = new Object[1][this.col_n];
		t_title = new Object[this.col_n];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTable table = (JTable)e.getSource();		
        int modelRow = Integer.valueOf( e.getActionCommand() );
        for(int i = 0;i < this.col_n;i++)
        {
        	cur_data[0][i] = table.getValueAt(modelRow, i);
        	t_title[i] = table.getColumnName(i);
        	
        }        

        new Mdialog(cur_data,t_title,row_n,col_n,this.choice,tname,table,modelRow);
	}

	
}
