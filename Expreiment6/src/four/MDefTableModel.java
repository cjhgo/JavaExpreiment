package four;

import javax.swing.table.DefaultTableModel;

public class MDefTableModel extends DefaultTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//行列数,从1开始,查询记录的返回值
//	private int rown;
	public int rown;
	private int coln;
	boolean [][] editable_cells;
	MDefTableModel(Object[][] tdata,Object[] tname,int rown,int coln)
	{
		super(tdata,tname);
		this.rown = rown;
		this.coln = coln;
		//避免增加行列数组索引溢出错误
		this.editable_cells = new boolean[rown+10][coln+10];
	}
	@Override
	public boolean isCellEditable(int row,int column)
	{
		return this.editable_cells[row][column];
	}
	public void setCellEditable(int row,int col,boolean value)
	//row,col行列索引,从0开始计算
	{
		this.editable_cells[row][col] = value;
		this.fireTableCellUpdated(row, col);
	}
	
}