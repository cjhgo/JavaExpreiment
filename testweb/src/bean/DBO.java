package bean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBO {
	// 定义数据库驱动
	private String dbDriver = "com.mysql.jdbc.Driver";
	// 定义数据库路径
	private String dbUrl = "jdbc:mysql://localhost:3306/student";
	// 定义数据库用户名和密码
	private String dbUser = "root";
	private String dbPassword = "";
	// 定义连接、状态和结果集
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// 返回结果集的方法
	public ResultSet getRs() {
		return rs;
	}

	// 设置结果集的方法
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	// 关闭结果集的方法
	public void CloseRS() {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("关闭结果集时发生错误！");
		}
	}

	// 关闭状态的方法
	public void CloseStmt() {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("关闭状态时发生错误！");
		}
	}

	// 关闭连接的方法
	public void CloseConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("关闭连接时发生错误！");
		}
	}

	// 构造方法，用于加载数据库驱动
	public DBO() {
		try {
			Class.forName(dbDriver);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	// 执行添加记录的方法
	public void executeInsert(student stu) {
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn
					.prepareStatement("insert into stuinfo values(?,?,?,?,?)");
			stmt.setString(1, stu.getStuid());
			stmt.setString(2, stu.getStuname());
			stmt.setDouble(3, stu.getMath());
			stmt.setDouble(4, stu.getEnglish());
			stmt.setDouble(5, stu.getHistory());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Insert error " + ex.getMessage());
		} finally {
			CloseStmt();
			CloseConnection();
		}
	}

	// 执行学号查询，用于插入记录时检测
	public List<student> executeQueryByStuid(String stuid) throws SQLException{
		try {
			String sql = "select * from stuinfo where stuid = ?";
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement(sql);			
			stmt.setString(1, stuid);			
			rs = stmt.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		List <student>list = new ArrayList<student>();	
		while(rs.next()) {
			student s = new student();
			s.setStuid(rs.getString(1));
			s.setStuname(rs.getString(2));
			s.setMath(rs.getDouble(3));
			s.setEnglish(rs.getDouble(4));
			s.setHistory(rs.getDouble(5));
			list.add(s);
		}			
		return list;
	}
	
	// 执行多条件查询的方法
	public List<student> executeQueryByCondition(student stu) throws SQLException{
		try {
			String sql = "select * from stuinfo where stuid like ? and stuname like ? "
					+ "and math like ? and english like ? and history like ?";
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement(sql);
			
			if (stu.getStuid() == null)
				stmt.setString(1, "%");
			else
				stmt.setString(1, "%" + stu.getStuid() + "%");
			
			if (stu.getStuname() == null)
				stmt.setString(2, "%");
			else
				stmt.setString(2, "%" + stu.getStuname() + "%");
			
			if (stu.getMath() == -1)
				stmt.setString(3, "%");
			else {
				if ((int)stu.getMath() - stu.getMath() != 0)
					stmt.setString(3, String.valueOf(stu.getMath()));
				else
					stmt.setString(3, "" + (int)stu.getMath());
			}			
			if (stu.getEnglish() == -1)
				stmt.setString(4, "%");
			else {
				if ((int)stu.getEnglish() - stu.getEnglish() != 0)
					stmt.setString(4, String.valueOf(stu.getEnglish()));
				else
					stmt.setString(4, "" + (int)stu.getEnglish());
			}
			if (stu.getHistory() == -1)
				stmt.setString(5, "%");
			else {
				if ((int)stu.getHistory() - stu.getHistory() != 0)
					stmt.setString(5, String.valueOf(stu.getHistory()));
				else
					stmt.setString(5, "" + (int)stu.getHistory());
			}			
			rs = stmt.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		List <student>list = new ArrayList<student>();	
		while(rs.next()) {
			student s = new student();
			s.setStuid(rs.getString(1));
			s.setStuname(rs.getString(2));
			s.setMath(rs.getDouble(3));
			s.setEnglish(rs.getDouble(4));
			s.setHistory(rs.getDouble(5));
			list.add(s);
		}			
		return list;
	}

	// 执行删除记录的方法
	public int executeDelete(String DeleteID) {
		int count = 0;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement("delete from stuinfo where stuid = ?");
			stmt.setString(1, DeleteID);
			count = stmt.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			CloseStmt();
			CloseConnection();
		}
		return count;
	}

	// 执行更新记录的方法
	public void executeUpdate(String UpdateID, String UpdateItem,
			String UpdateContent) {
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql;
			sql = "update stuinfo set " + UpdateItem + " = ? where stuid = ?";
			stmt = conn.prepareStatement(sql);
			if (UpdateItem.equals("stuname"))
				stmt.setString(1, UpdateContent);
			else
				stmt.setDouble(1, Double.parseDouble(UpdateContent));
			stmt.setString(2, UpdateID);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			CloseStmt();
			CloseConnection();
		}
	}
}