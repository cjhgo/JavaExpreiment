<%@ page contentType="text/html; charset=gbk" language="java" import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="bean.student"%>
<%-- xyzΪstudent��ʵ������ --%>
<jsp:useBean id="xyz" scope="page" class="bean.student"/>
<jsp:useBean id="def" scope="page" class="bean.DBO"/>
<html>
        <head>
                <title>ʹ��JavaBean��ѯ���ݿ�</title>
        </head>
<body>
<%
	String x = request.getParameter("math");
	String y = request.getParameter("english");
	String z = request.getParameter("history");	
%>
<%--��ǰ̨ҳ���л�ȡ���ݲ����õ�def�ı�����--%>
<jsp:setProperty name="xyz" property="stuid" param="stuid"/>
<jsp:setProperty name="xyz" property="stuname" param="stuname"/>
<jsp:setProperty name="xyz" property="math" value="<%=(x.length()>0)?Double.parseDouble(x):(-1)%>"/>
<jsp:setProperty name="xyz" property="english" value="<%=(y.length()>0)?Double.parseDouble(y):(-1)%>"/>
<jsp:setProperty name="xyz" property="history" value="<%=(z.length()>0)?Double.parseDouble(z):(-1)%>"/>
���ݿ��ѯ�������
<table border='1' cellspacing='0' bordercolor='#000000'><tr><th>ѧ��</th><th>����</th><th>��ѧ�ɼ�</th><th>
Ӣ��ɼ�</th><th>��ʷ�ɼ�</th><th>�޸ļ�¼</th><th>ɾ����¼</th></tr>
<%	List <student>list = new ArrayList<student>();
	// �������Ϊ���򲻽�������ת�������ֱ�Ӳ�ѯ
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
  <%-- ��ѧ�ŵ�ֵ���ݸ�xiugai.jsp��ɾ��.jsp�������޸ĺ�ɾ������ --%>
  <td><a href = "beanupdate.jsp?stuid=<%=a%>">�޸ļ�¼</a></td>
  <td><a href = "beandelete.jsp?stuid=<%=a%>">ɾ����¼</a></td>  
  </tr>
<%}%>
</table>
<br>
����ѯ��<%=count%>����¼
<%def.CloseRS();
  def.CloseStmt();
  def.CloseConnection();
%>
</body>
<a href = "beaninsert.htm">��Ӽ�¼</a>
</html>