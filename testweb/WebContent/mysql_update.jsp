<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*"
    pageEncoding="utf-8"%>
    <%
    String dburl="jdbc:mysql://localhost:3306/student";
    String stuid="1901208";
    String sname="改名";
    double math=88;
    double english=43;
    double history=96;
    Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
    int count=0;
    try{
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection(dburl,"root","");
    	String sql="select * from stuinfo";
    	stmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	rs=stmt.executeQuery();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<p>更新数据库中记录:1901208	张三	112	110	80为:1901208	改名	77	150	80</p>
	<p>更新记录前,数据库中记录为:</p>
	<table>
	<th>stuid</th><th>stuname</th><th>math</th><th>english</th><th>history</th>
	<%
		while(rs.next())
		{%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getDouble(3)%></td>
		<td><%=rs.getDouble(4)%></td>
		<td><%=rs.getDouble(5)%></td>
		<%} %>
	</tr>
	</table>
	<%
	sql="update stuinfo set stuid=?,stuname=?,math=?,english=?,history=? where stuid=?";
	stmt=conn.prepareStatement(sql);
	stmt.setString(1,stuid);
	stmt.setString(2,sname);
	stmt.setDouble(3,math);
	stmt.setDouble(4,english);
	stmt.setDouble(5,history);
	stmt.setString(6,stuid);
	stmt.executeUpdate();
	stmt.close();
	out.println("记录已经更新");
	sql="select * from stuinfo";
	stmt=conn.prepareStatement(sql);
	rs=stmt.executeQuery();
	%>
	<p>更新记录后,数据库中数据为:</p>
	<table>
	<th>stuid</th><th>stuname</th><th>math</th><th>english</th><th>history</th>
	<%
		while(rs.next())
		{%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getDouble(3)%></td>
		<td><%=rs.getDouble(4)%></td>
		<td><%=rs.getDouble(5)%></td>
		<%} %>
	</tr>
	</table>
	<%}
	catch(Exception e)
	{
		out.print(e.getMessage());	
		//out.print("gun!");
	}
	finally
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(conn!=null)
			conn.close();
	}
	%>
	</body>
</html>