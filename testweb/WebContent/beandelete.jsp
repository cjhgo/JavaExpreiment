<%@ page contentType="text/html;charset=GBK"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO" />
<html>
<head>
<title>通过JavaBean删除数据库记录</title>
</head>
<body>
	<%-- 从beanquery.jsp页面中得到传递来的stuid的值--%>
	<jsp:setProperty name="xyz" property="stuid" param="stuid" />
	<%	
	int x = def.executeDelete(xyz.getStuid());
	out.println("记录删除成功");				
	%>
</body>
</html>
<BR>
<a href="beanquery.htm">查询</a>