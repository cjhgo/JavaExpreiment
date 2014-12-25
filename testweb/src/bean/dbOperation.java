package bean;
import java.sql.*;
public class dbOperation {
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
	// 定义JavaBean的五个变量，与数据库中五个字段对应
	// 为方便从前台接收数据，这里五个变量定义为String类型
	private String stuid;
	private String stuname;
	private String math;
	private String english;
	private String history;
	// 返回结果集的方法
	public ResultSet getRs() {
		return rs;
	}
	// 设置结果集的方法
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	// 设置stuid的方法
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	// 返回stuid的方法
	public String getStuid() {
		return stuid;
	}
	// 设置stuname的方法
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	// 返回stuname的方法
	public String getStuname() {
		return stuname;
	}
	// 设置math的方法
	public void setMath(String math) {
		this.math = math;
	}
	// 返回math的方法
	public String getMath() {
		return math;
	}
	// 设置english的方法
	public void setEnglish(String english) {
		this.english = english;
	}
	// 返回english的方法
	public String getEnglish() {
		return english;
	}
	// 设置history的方法
	public void setHistory(String history) {
		this.history = history;
	}
	// 返回history的方法
	public String getHistory() {
		return history;
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
	public dbOperation() {
		try {
			Class.forName(dbDriver);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	// 执行添加记录的方法
	public void executeInsert(String stuid, String stuname, String math,
			String english, String history) {
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement
					("insert into stuinfo values(?,?,?,?,?)");
			stmt.setString(1, stuid);			
			stmt.setString(2, stuname);
			if(math == null)
				stmt.setDouble(3, 0);
			else
				stmt.setDouble(3, Double.parseDouble(math));
			if(english == null)
				stmt.setDouble(4, 0);
			else
				stmt.setDouble(4, Double.parseDouble(english));
			if(history == null)
				stmt.setDouble(5, 0);
			else
				stmt.setDouble(5, Double.parseDouble(history));
			stmt.executeUpdate();
		} 
		catch (SQLException ex) {
			System.err.println("aq.executeUpdate " + ex.getMessage());
		} 
		finally {
			CloseStmt();
			CloseConnection();
		}
	}
	// 执行多条件查询的方法
	public ResultSet executeQueryByCondition(String stuid, String stuname,
			String math, String english, String history) {
		try {
			String sql = "select * from stuinfo where stuid like ? and stuname like ?  "
					+ "and math like ?  and english like ?  and history like ? ";
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement(sql);
			if(stuid == null)
				stmt.setString(1, "%");
			else
				stmt.setString(1, "%" + stuid + "%");
			if(stuname == null)
				stmt.setString(2, "%");
			else
				stmt.setString(2, "%" + stuname + "%");
			if (math == null)
				stmt.setString(3, "%");
			else
				stmt.setString(3, math);
			if (english == null)
				stmt.setString(4, "%");
			else
				stmt.setString(4, english);
			if (history == null)
				stmt.setString(5, "%");
			else
				stmt.setString(5, history);
			rs = stmt.executeQuery();
		} 
		catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} 		
		return rs;
	}
	// 执行删除记录的方法
	public void executeDelete(String DeleteID) {
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement("delete from stuinfo where stuid = ?");
			stmt.setString(1, DeleteID);
			stmt.executeUpdate();
		} 
		catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			CloseStmt();
			CloseConnection();
		}
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
		} 
		catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} 
		finally {
			CloseStmt();
			CloseConnection();
		}
	}
}