package noname;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Act_Sql {

	private String dburl;
	private Connection con;
	private PreparedStatement  stmt;
	Act_Sql(String s)
	{
		Con_sql(s);
	}
	void Con_sql(String s)
	{
		dburl = "jdbc:mysql://localhost:3306/"+s;
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
	void Select(String s)
	{
		String sel_tab = s;
		try {
			stmt = con.prepareStatement(sel_tab,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sel_tab);
			ResultSetMetaData rsmd = rs.getMetaData();
			int col,row;
			rs.last();
			row = rs.getRow();
			col = rsmd.getColumnCount();
			String [] title = new String[col];
			String [][] data = new String[row][col];
			for(int i = 0;i < col;i++)
			{
				title[i] = rsmd.getColumnName(i+1);
			}
			rs.first();
			for(int i = 0;i < row;i++)
			{
				for(int j = 0;j < col;j++)
				{
					data[i][j] = rs.getObject(j+1).toString();
				}
				rs.next();
			}
			for(String col_name:title)
			{
				System.out.print(col_name+'\t');
			}
			System.out.print("\n");
			for(String[] row_data :data)
			{
				for(String row_col_data:row_data)
				{
					System.out.print(row_col_data+'\t');
				}
				System.out.print("\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void Show_table(String s)
	{
		String sel_tab = "select * from "+s;
		Select(sel_tab);
	}
	
	void Act_sel()
	{
		System.out.println("查询学生1901205的记录,查询结果如下");		
		String s = "select * from stuinfo where stuid = '1901205'";
		Select(s);
	}
	void Act_del()
	{
		System.out.println("删除学生1901205的记录,删除后表内容如下");	
		try{
			String del_tab = "delete from stuinfo where stuid = ?";
			stmt = con.prepareStatement(del_tab,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, "1901205");
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Show_table("stuinfo");
	}
	void Act_upd()
	{
		System.out.println("更新学生1901210的math字段,更新后表内容如下");	
		try{
			String upd_tab = "update stuinfo set math = ? where stuid = ?";
			stmt = con.prepareStatement(upd_tab,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setDouble(1, 150);
			stmt.setString(2, "1901210");
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Show_table("stuinfo");
	}
	void Act_add()
	{
		System.out.println("插入学生1901299的记录,插入后表内容如下");	
		try{
			String add_tab = "insert into stuinfo values (?,?,?,?,?)";
			stmt = con.prepareStatement(add_tab,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
			
			stmt.setString(1, "1901299");
			stmt.setString(2, "姓名");
			stmt.setDouble(3, 140);
			stmt.setDouble(4, 140);
			stmt.setDouble(5, 100);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Show_table("stuinfo");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Act_Sql maq = new Act_Sql("student");
		System.out.println("学生信息表内容如下");
		maq.Show_table("stuinfo");
		maq.Act_sel();
		maq.Act_del();
		maq.Act_upd();
		maq.Act_add();
	}

}
