package four;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mdialog implements ActionListener{

	private String tname;
	private Object[][] cur_data;
	private Object[] t_title;
	private int row_n;
	private int col_n;
	private int choice = 2;
	private JDialog mdial;
	private JPanel mjp;
	private JTable mtab;
	private JTable stab;
	private int cur_row;
	private JButton buyes;
	private JButton buno;
	private JButton buact;
	private JButton bucancel;
	private JButton buadd;
	private JButton add_act;
	private JButton add_cancel;
	public Mdialog(Object[][] cur_data,Object[] t_title,int row,int col,int flag,String s,JTable table,int cur_row) 
	{
		this.cur_data = cur_data;
		this.t_title = t_title;
		row_n = row;
		col_n = col;
		choice = flag;
		tname = s;
		this.stab = table;
		this.cur_row = cur_row;
		initJDialog();
	}
	public Mdialog(Mtable table,String s,JButton jbut)
	{
		this.tname = s;
		this.stab = table;
		this.buadd = jbut;
		this.col_n = table.getColumnCount()-2;
		
	}
	private void initJDialog()
	{
		mdial = new JDialog();
		
		if(this.choice == 0)
		{
			initJPanel_del();
		}
		else if(this.choice == 1)
		{
			initJPanel_upd();
		}
		else if(this.choice == 2)
		{
			initJPanel_add();
		}
		if(this.choice == 1 || this.choice == 2)
			mdial.setSize(420, 500);
		else		
			mdial.setSize(420, 200);
		
		mdial.add(mjp);
		mdial.setLocation(400, 90);
		mdial.setVisible(true);
		
	}
	private void initJPanel_del()
	{
		mjp = new JPanel();
		JLabel jlb = new JLabel("确定删除此列吗?");
		mtab = new JTable(this.cur_data,this.t_title);
		JScrollPane jsp = new JScrollPane(mtab);
		jsp.setPreferredSize(new Dimension(400,80));
		buyes = new JButton("Yes");
		buno = new JButton("No");
		buyes.addActionListener(this);
		buno.addActionListener(this);
		mjp.add(jlb);

		mjp.add(jsp);
		mjp.add(buyes);
		mjp.add(buno);
	}
	private void initJPanel_upd()
	{
		mjp = new JPanel();		
		mtab = new JTable();		
		DefaultTableModel dtm = new DefaultTableModel();
		mtab.setModel(dtm);
		dtm.addColumn("属性", t_title);
		dtm.addColumn("旧值", cur_data[0]);
		dtm.addColumn("新值",cur_data[0]);
		JScrollPane jsp = new JScrollPane(mtab);
		jsp.setPreferredSize(new Dimension(400,350));
		buact = new JButton("执行!");
		bucancel = new JButton("取消");
		buact.addActionListener(this);
		bucancel.addActionListener(this);
		mjp.add(jsp);
		mjp.add(buact);
		mjp.add(bucancel);
	}
	public void initJPanel_add()
	{
		mjp = new JPanel();
		mtab = new JTable();
		DefaultTableModel dtm = new DefaultTableModel();
		mtab.setModel(dtm);
		Object[] title = new Object[this.col_n];
		for(int i = 0;i < this.col_n;i++)
		{
			title[i] = stab.getColumnName(i);
		}
		dtm.addColumn("属性", title);
		dtm.addColumn("增加值");
		add_act = new JButton("执行!");
		add_cancel = new JButton("取消");
		add_act.addActionListener(this);
		add_cancel.addActionListener(this);
		JScrollPane jsp = new JScrollPane(mtab);
		jsp.setPreferredSize(new Dimension(400,300));
		mjp.add(jsp);
		mjp.add(add_act);
		mjp.add(add_cancel);
	}
	public void run()
	{
		
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(buyes))
		{


			ConSql.DelRecord(cur_data[0], tname);
	        ((DefaultTableModel)stab.getModel()).removeRow(this.cur_row);
			this.mdial.dispose();
			
		}
		else if(e.getSource().equals(buno))
		{
			this.mdial.dispose();
		}
		else if(e.getSource().equals(buact))
		{
			Object[] newvalue = new Object[col_n];
			for(int i = 0;i < newvalue.length;i++)
			{
				newvalue[i] = mtab.getValueAt(i, 2);
			}
			ConSql.UpdRecord(this.cur_data[0],newvalue, tname);
//			ConSql.UpdRecord(this.cur_data[0],this.cur_data[0], tname);
			for(int i = 0;i < newvalue.length;i++)
			{
//				((DefaultTableModel)stab.setc
				stab.setValueAt(newvalue[i], cur_row, i);
			}
			this.mdial.dispose();
		}
		else if(e.getSource().equals(bucancel))
		{
			this.mdial.dispose();
		}
		else if(e.getSource().equals(buadd))
		{
			initJDialog();
//			JOptionPane.showMessageDialog(null, "欢迎使用简易销售管理系统");
		}
		else if(e.getSource().equals(add_act))
		{
			Object[] data = new Object[this.col_n];
			for(int i = 0;i < this.col_n;i++)
			{
				data[i] = mtab.getValueAt(i, 1);
			}
			DefaultTableModel dtm = (DefaultTableModel) stab.getModel();
			int row_n = stab.getRowCount();
			dtm.addRow(data);
			dtm.setValueAt("删除", row_n, this.col_n);
			dtm.setValueAt("修改", row_n, this.col_n+1);
//			Maction delete = new Maction(row_n,this.col_n,0,this.tname);
//			new ButtonColumn(stab,delete,this.col_n);
//			Maction update = new Maction(row_n,this.col_n+1,1,this.tname);
//			new ButtonColumn(stab,update,this.col_n+1);
			ConSql.AddRecord(data, tname);
			this.mdial.dispose();
		}
		else if(e.getSource().equals(add_cancel))
		{
			this.mdial.dispose();
		}
		
	}

}
