<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*"
    pageEncoding="utf-8"%>
    <%
    String dburl="jdbc:mysql://localhost:3306/student";
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
	<h1>数据库查询结果为:</h1>
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
		rs.previous();
		count=rs.getRow();
	%>
	<br>
	共检索出<%=count%>条记录;
	<%
	}
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