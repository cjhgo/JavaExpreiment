package bean;
import java.sql.*;
public class dbOperation {
	// �������ݿ�����
	private String dbDriver = "com.mysql.jdbc.Driver";
	// �������ݿ�·��
	private String dbUrl = "jdbc:mysql://localhost:3306/student";
	// �������ݿ��û���������
	private String dbUser = "root";
	private String dbPassword = "";
	// �������ӡ�״̬�ͽ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// ����JavaBean����������������ݿ�������ֶζ�Ӧ
	// Ϊ�����ǰ̨�������ݣ����������������ΪString����
	private String stuid;
	private String stuname;
	private String math;
	private String english;
	private String history;
	// ���ؽ�����ķ���
	public ResultSet getRs() {
		return rs;
	}
	// ���ý�����ķ���
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	// ����stuid�ķ���
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	// ����stuid�ķ���
	public String getStuid() {
		return stuid;
	}
	// ����stuname�ķ���
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	// ����stuname�ķ���
	public String getStuname() {
		return stuname;
	}
	// ����math�ķ���
	public void setMath(String math) {
		this.math = math;
	}
	// ����math�ķ���
	public String getMath() {
		return math;
	}
	// ����english�ķ���
	public void setEnglish(String english) {
		this.english = english;
	}
	// ����english�ķ���
	public String getEnglish() {
		return english;
	}
	// ����history�ķ���
	public void setHistory(String history) {
		this.history = history;
	}
	// ����history�ķ���
	public String getHistory() {
		return history;
	}
	// �رս�����ķ���
	public void CloseRS() {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("�رս����ʱ��������");
		}
	}
	// �ر�״̬�ķ���
	public void CloseStmt() {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("�ر�״̬ʱ��������");
		}
	}
	// �ر����ӵķ���
	public void CloseConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("�ر�����ʱ��������");
		}
	}
	// ���췽�������ڼ������ݿ�����
	public dbOperation() {
		try {
			Class.forName(dbDriver);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	// ִ����Ӽ�¼�ķ���
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
	// ִ�ж�������ѯ�ķ���
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
	// ִ��ɾ����¼�ķ���
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
	// ִ�и��¼�¼�ķ���
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