<%@ page contentType="text/html;charset=GBK"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO"/>
<html>
        <head>
                <title>通过JavaBean向数据库添加记录</title>
        </head>
<body>
<%
	String x = request.getParameter("math");
	String y = request.getParameter("english");
	String z = request.getParameter("history");	
%>
<jsp:setProperty name="xyz" property="stuid" param="stuid"/>
<jsp:setProperty name="xyz" property="stuname" param="stuname"/>
<jsp:setProperty name="xyz" property="math" value="<%=(x.length()>0)?Double.parseDouble(x):(-1)%>"/>
<jsp:setProperty name="xyz" property="english" value="<%=(y.length()>0)?Double.parseDouble(y):(-1)%>"/>
<jsp:setProperty name="xyz" property="history" value="<%=(z.length()>0)?Double.parseDouble(z):(-1)%>"/>
<%	
	if(xyz.getStuname() != null)
			xyz.setStuname(new String(xyz.getStuname().
  						getBytes("ISO-8859-1"),"gbk"));	
	else
			xyz.setStuname("名字未知");	
	// 如果已有该记录则不能添加
	if (def.executeQueryByStuid(xyz.getStuid()).size() > 0) {
		out.println("已有记录，不能插入");
		out.println("<a href = 'beaninsert.htm'>返回重填</a>");
		}
	// 如果没有记录则可以添加
	else {		
		def.executeInsert(xyz);
		out.println("记录插入成功");
	}	
%>
</body>
</html>
<BR>
<a href = "beanquery.htm">查询</a>