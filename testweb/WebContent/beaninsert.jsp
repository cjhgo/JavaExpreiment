<%@ page contentType="text/html;charset=GBK"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO"/>
<html>
        <head>
                <title>ͨ��JavaBean�����ݿ���Ӽ�¼</title>
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
			xyz.setStuname("����δ֪");	
	// ������иü�¼�������
	if (def.executeQueryByStuid(xyz.getStuid()).size() > 0) {
		out.println("���м�¼�����ܲ���");
		out.println("<a href = 'beaninsert.htm'>��������</a>");
		}
	// ���û�м�¼��������
	else {		
		def.executeInsert(xyz);
		out.println("��¼����ɹ�");
	}	
%>
</body>
</html>
<BR>
<a href = "beanquery.htm">��ѯ</a>