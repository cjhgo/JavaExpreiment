package noname;
import java.sql.*;
public class Act_Acc {

	private String dburl;
	private Connection con;
	private PreparedStatement  stmt;
	public Act_Acc(String s) {
		// TODO Auto-generated constructor stub
		Con_sql(s);
	}
	void Con_sql(String s)
	{
//		dburl = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=E:/student.mdb";
		dburl = "jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=E:\\student.accdb;PWD=12341234;";
//		dburl = "jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=E:\\student.mdb;PWD=123;";
		try
		{
//			String Driver="sun.jdbc.odbc.JdbcOdbcDriver";
//			Class.forName(Driver).newInstance();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con = DriverManager.getConnection("jdbc:odbc:dbODBC","admin","12341234");
			con = DriverManager.getConnection(dburl, "","");
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println("没找到数据库加载驱动....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	void Select(String s)
	{
		String sel_tab = s;
		try {
			stmt = con.prepareStatement(sel_tab,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
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
		Act_Acc temp = new Act_Acc("");
		temp.Show_table("stuinfo");
		temp.Act_sel();
		temp.Act_del();
		temp.Act_upd();
		temp.Act_add();
	}

}
