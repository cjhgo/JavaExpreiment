<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>this is a jsp sample</title>
</head>
<body>
	<h2>现在时间是:</h2>
	<%Calendar now = Calendar.getInstance();
		out.println(now.get(Calendar.YEAR)+"年"+
		(now.get(Calendar.MONTH)+1)+"月"+
		now.get(Calendar.DAY_OF_MONTH)+"日");
	%>
</body>
</html>