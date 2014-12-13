package four;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mtable extends JTable
{
	String tname;
	Object[][] tdata;
	Object[] colname;
	MDefTableModel dtm;
	public int row;
	public int column;
	Mtable(Object[][] row,Object[] columnname,int rownum,int column_num,String s)
	{	
		this.tname = s;
		this.tdata = row;
		this.colname = columnname;
		//行列数,从1开始,查询记录的返回值
		this.row = rownum;
		this.column = column_num;
		
		Object[] del = new Object[this.row];
		Object[] upd = new Object[this.row];
		
		for(int i = 0;i < this.row;i++)
		{
			del[i] = "删除";
			upd[i] = "修改";
		}
		initDtm(row,columnname,rownum,column_num);
		super.setModel(dtm);
		dtm.addColumn("删除",del);
		dtm.addColumn("修改",upd);
		this.getColumnModel().getColumn(column).setPreferredWidth(200);
		this.getColumnModel().getColumn(column+1).setPreferredWidth(200);

		for(int i = 0;i < this.row;i++)
		{
			dtm.setCellEditable(i, this.column, true);
			dtm.setCellEditable(i, this.column+1, true);
		}
		@SuppressWarnings("serial")
//		Action delete = new AbstractAction()
//		{
//		    public void actionPerformed(ActionEvent e)
//		    {
//		        JTable table = (JTable)e.getSource();
//		        int modelRow = Integer.valueOf( e.getActionCommand() );
//		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
//		    }
//		};
//		Action update = new AbstractAction()
//		{
//		    public void actionPerformed(ActionEvent e)
//		    {
//		        JTable table = (JTable)e.getSource();
//		        int modelRow = Integer.valueOf( e.getActionCommand() );
//		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
//		    }
//		};
		Maction delete = new Maction(this.row,this.column,0,this.tname);
		new ButtonColumn(this,delete,this.column);
		Maction update = new Maction(this.row,this.column,1,this.tname);
		new ButtonColumn(this,update,this.column+1);
		
		this.setRowSelectionAllowed(false);
	}
	public void initDtm(Object[][] row,Object[] columnname,int rownum,int column_num)
	{
		dtm = new MDefTableModel(row,columnname,rownum,column_num);
	}
}
