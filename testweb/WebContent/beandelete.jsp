<%@ page contentType="text/html;charset=GBK"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO" />
<html>
<head>
<title>ͨ��JavaBeanɾ�����ݿ��¼</title>
</head>
<body>
	<%-- ��beanquery.jspҳ���еõ���������stuid��ֵ--%>
	<jsp:setProperty name="xyz" property="stuid" param="stuid" />
	<%	
	int x = def.executeDelete(xyz.getStuid());
	out.println("��¼ɾ���ɹ�");				
	%>
</body>
</html>
<BR>
<a href="beanquery.htm">��ѯ</a>