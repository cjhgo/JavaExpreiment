<%@ page contentType="text/html; charset=gbk" language="java"
	import="java.sql.*"%>
<html>
<head>
<Script language="javascript">
	function check() {
		if (form1.updateOption.value != "stuname") {
			if (isNaN(form1.updateContent.value)) {
				alert("�ɼ�����Ϊ���֣�");
				form1.updateContent.focus();
				return false;
			}
		}		
	}
</Script>
<title>ʹ��JavaBean�������ݿ��¼</title>
</head>
<body>
	<%--��beanquery.jsp�õ�ѧ��ֵ��������abc��--%>
        <%--��ҳ��ʵ����ִ�����Σ�����abc�ķ�ΧΪsession--%>
	<jsp:useBean id="abc" scope="session" class="bean.student" />
	<jsp:useBean id="def" scope="page" class="bean.DBO"/>
	<jsp:setProperty name="abc" property="stuid" param="stuid" />
	<form name="form1" method="get" action="">
		<select name="updateOption">
			<option value="stuname">����</option>
			<option value="math">��ѧ�ɼ�</option>
			<option value="english">Ӣ��ɼ�</option>
			<option value="history">��ʷ�ɼ�</option>
		</select> &nbsp;&nbsp;&nbsp;&nbsp; ����Ҫ���µ����� <input type="text"
			name="updateContent"> <BR>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="����" onClick="return check()">
	</form>
	<%
		if (request.getParameter("updateOption") != null) {
			if (request.getParameter("updateOption").equals("stuname"))
					def.executeUpdate(abc.getStuid(), request
							.getParameter("updateOption"),
							new String(request
									.getParameter("updateContent")
									.getBytes("ISO-8859-1"), "gbk"));
			else
				def.executeUpdate(abc.getStuid(),
							request.getParameter("updateOption"),
							request.getParameter("updateContent"));
				out.println("���³ɹ�");
				out.println("<br><a href = 'beanquery.htm'>��ѯ</a>");
		}	 			
		
	%>
	</form>
</body>
</html>