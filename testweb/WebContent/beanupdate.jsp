<%@ page contentType="text/html; charset=gbk" language="java"
	import="java.sql.*"%>
<html>
<head>
<Script language="javascript">
	function check() {
		if (form1.updateOption.value != "stuname") {
			if (isNaN(form1.updateContent.value)) {
				alert("成绩必须为数字！");
				form1.updateContent.focus();
				return false;
			}
		}		
	}
</Script>
<title>使用JavaBean更新数据库记录</title>
</head>
<body>
	<%--从beanquery.jsp得到学号值，设置在abc中--%>
        <%--该页面实际是执行两次，所以abc的范围为session--%>
	<jsp:useBean id="abc" scope="session" class="bean.student" />
	<jsp:useBean id="def" scope="page" class="bean.DBO"/>
	<jsp:setProperty name="abc" property="stuid" param="stuid" />
	<form name="form1" method="get" action="">
		<select name="updateOption">
			<option value="stuname">姓名</option>
			<option value="math">数学成绩</option>
			<option value="english">英语成绩</option>
			<option value="history">历史成绩</option>
		</select> &nbsp;&nbsp;&nbsp;&nbsp; 输入要更新的内容 <input type="text"
			name="updateContent"> <BR>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="更新" onClick="return check()">
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
				out.println("更新成功");
				out.println("<br><a href = 'beanquery.htm'>查询</a>");
		}	 			
		
	%>
	</form>
</body>
</html>