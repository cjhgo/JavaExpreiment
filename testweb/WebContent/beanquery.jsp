<%@ page contentType="text/html; charset=gbk" language="java" import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="bean.student"%>
<%-- xyz为student的实例对象 --%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO"/>
<html>
        <head>
                <title>使用JavaBean查询数据库</title>
        </head>
<body>
<%
	String x = request.getParameter("math");
	String y = request.getParameter("english");
	String z = request.getParameter("history");	
%>
<%--从前台页面中获取数据并设置到def的变量中--%>
<jsp:setProperty name="xyz" property="stuid" param="stuid"/>
<jsp:setProperty name="xyz" property="stuname" param="stuname"/>
<jsp:setProperty name="xyz" property="math" value="<%=(x.length()>0)?Double.parseDouble(x):(-1)%>"/>
<jsp:setProperty name="xyz" property="english" value="<%=(y.length()>0)?Double.parseDouble(y):(-1)%>"/>
<jsp:setProperty name="xyz" property="history" value="<%=(z.length()>0)?Double.parseDouble(z):(-1)%>"/>
数据库查询结果如下
<table border='1' cellspacing='0' bordercolor='#000000'><tr><th>学号</th><th>姓名</th><th>数学成绩</th><th>
英语成绩</th><th>历史成绩</th><th>修改记录</th><th>删除记录</th></tr>
<%	List <student>list = new ArrayList<student>();
	// 如果姓名为空则不进行姓名转码操作，直接查询
	if(xyz.getStuname() != null)
		xyz.setStuname(new String(xyz.getStuname().
  						getBytes("ISO-8859-1"),"gbk"));	
	list = def.executeQueryByCondition(xyz);
	int count = 0;
Iterator<student> it = list.iterator();
while(it.hasNext()) {
	count++;
	student sr = it.next();  
  	String a = sr.getStuid(); 
  	String b = sr.getStuname();
  	double c = sr.getMath();
  	double d = sr.getEnglish();
  	double e = sr.getHistory(); 
  %>
  <tr align='center'>
  <td><%=a%></td>
  <td><%=b%></td>
  <td><%=c%></td>
  <td><%=d%></td>
  <td><%=e%></td>
  <%-- 将学号的值传递给xiugai.jsp和删除.jsp，用于修改和删除操作 --%>
  <td><a href = "beanupdate.jsp?stuid=<%=a%>">修改记录</a></td>
  <td><a href = "beandelete.jsp?stuid=<%=a%>">删除记录</a></td>  
  </tr>
<%}%>
</table>
<br>
共查询出<%=count%>条记录
<%def.CloseRS();
  def.CloseStmt();
  def.CloseConnection();
%>
</body>
<a href = "beaninsert.htm">添加记录</a>
</html>