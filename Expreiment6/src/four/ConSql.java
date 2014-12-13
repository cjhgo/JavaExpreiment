package four;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
public class ConSql {

	static final String dburl = "jdbc:mysql://localhost:3306/comunication";
	static Connection con;
	static PreparedStatement  stmt = null;
	public static void ConDb()
	{
		try
		{
			String Driver="com.mysql.jdbc.Driver";
			Class.forName(Driver).newInstance();
			con = DriverManager.getConnection(dburl,"root","");
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println("没找到数据库加载驱动....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Mtable GetTable(String s)
	{
		ConDb();
		String gts = "select * from "+s;
		Mtable mtable = null;
		try {
			stmt = con.prepareStatement(gts,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(gts);
			ResultSetMetaData rsmd = rs.getMetaData();			
			rs.last();
			int row = rs.getRow();
			int column = rsmd.getColumnCount();
			Object[] columnset = new Object[column];
			for(int i = 0;i < column;i++)
			{
				columnset[i] = rsmd.getColumnName(i+1);
			}
			Object[][] rsset = new Object[row][column];
			rs.first();
			for(int i = 0;i < row;i++)
			{
				int r = 1;
				for(Object cur : rsset[i])
				{					
					cur = rs.getObject(r);
					rsset[i][r-1] = cur;
					r++;
				}
				rs.next();
			}
			mtable = new Mtable(rsset,columnset,row,column,s);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{			
		}
		return mtable;
	}
	public static void DelRecord(Object[] data,String tname)
	{
		ConDb();
		int count = data.length;
		String[] col_name = new String[count];
		String[] row_data = new String[count];
		int[] type_data = new int[count];
		for(int i = 0;i < count;i++)
		{
			row_data[i] = data[i].toString();
		}
		
		try 
		{
			String gts = "select * from "+tname;
			stmt = con.prepareStatement(gts,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(gts);
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
			{
				int type = rsmd.getColumnType(i);
	            if (type == Types.VARCHAR || type == Types.CHAR || type == Types.TIMESTAMP || type == Types.DATE)
	            	type_data[i-1] = 0;
	            else
	            	type_data[i-1] = 1;
			}

			for(int i = 0;i < count;i++)
			{
				col_name[i] = rsmd.getColumnName(i+1);
			}
			String s = "delete from "+tname+" where ";
			for(int i = 0;i < count;i++)
			{
				if(type_data[i] == 0)
				s +=( col_name[i]+" = "+"'"+row_data[i]+"'"+" and ");
				else if(type_data[i] == 1)
				s += ( col_name[i]+" = "+row_data[i]+" and ");
			}
			s+= "true";
			
			stmt.executeUpdate(s);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void UpdRecord(Object[] odata,Object[] ndata,String tname)
	{
		ConDb();
		int count = odata.length;
//		data[1] = Integer.parseInt("1234");
		String[] col_name = new String[count];
		String[] row_data = new String[count];
		int[] type_data = new int[count];
//		for(int i = 0;i < count;i++)
//		{
//			row_data[i] = odata[i].toString();
//		}
//		
		try 
		{
			String gts = "select * from "+tname;
			stmt = con.prepareStatement(gts,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(gts);
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
			{
				int type = rsmd.getColumnType(i);
	            if (type == Types.VARCHAR || type == Types.CHAR || type == Types.TIMESTAMP || type == Types.DATE)
	            	type_data[i-1] = 0;
	            else
	            	type_data[i-1] = 1;
			}

			for(int i = 0;i < count;i++)
			{
				col_name[i] = rsmd.getColumnName(i+1);
			}
			String s = "update "+tname+" set ";
			for(int i = 0;i < count;i++)
			{
				if(type_data[i] == 0)
				{
					String temp;					
					temp = ndata[i].equals(null) ?"":ndata[i].toString();
					s +=( col_name[i]+" = "+"'"+temp+"'"+" ,");
				}					
				else if(type_data[i] == 1)
				{
					float temp;
					temp = Float.parseFloat(ndata[i].toString());
					s += ( col_name[i]+" = "+temp+" ,");
				}
				
			}
			s = s.substring(0,s.length()-1);
			s += " where ";
			for(int i = 0;i < count;i++)
			{
				if(type_data[i] == 0)
				{
					String temp;					
					temp = odata[i].equals(null) ?"":ndata[i].toString();
					s +=( col_name[i]+" = "+"'"+temp+"'"+" and ");
				}					
				else if(type_data[i] == 1)
				{
					float temp;
					temp = Float.parseFloat(odata[i].toString());
					s += ( col_name[i]+" = "+temp+" and ");
				}
				
			}
			s += "true";
			stmt.executeUpdate(s);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void AddRecord(Object[] data,String tname)
	{
		ConDb();
		int count = data.length;
		String[] col_name = new String[count];
//		String[] row_data = new String[count];
		int[] type_data = new int[count];
		try 
		{
			String gts = "select * from "+tname;
			stmt = con.prepareStatement(gts,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(gts);
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
			{
				int type = rsmd.getColumnType(i);
	            if (type == Types.VARCHAR || type == Types.CHAR || type == Types.TIMESTAMP || type == Types.DATE)
	            	type_data[i-1] = 0;
	            else
	            	type_data[i-1] = 1;
			}

			for(int i = 0;i < count;i++)
			{
				col_name[i] = rsmd.getColumnName(i+1);
			}
			String s = "insert into "+tname+" values( ";
			for(int i = 0;i < count;i++)
			{
				if(type_data[i] == 0)
				{
					String temp;					
					temp = data[i].equals(null) ?"":data[i].toString();
					s +=( "'"+temp+"'"+" ,");
				}					
				else if(type_data[i] == 1)
				{
					float temp;
					temp = Float.parseFloat(data[i].toString());
					s += ( "  "+temp+" ,");
				}
				
			}
			s = s.substring(0,s.length()-1);
			s += ")";
			stmt.executeUpdate(s);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ConDb();
//			Mtable temp = GetTable("sales");
//
//			JFrame jt = new JFrame();
//			
//			jt.setSize(800, 800);
//			jt.setLayout(new FlowLayout());
//			jt.add(new JLabel("hhjkk"));
//			jt.add(new JScrollPane(temp));
//			jt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			jt.setVisible(true);
	}

}

