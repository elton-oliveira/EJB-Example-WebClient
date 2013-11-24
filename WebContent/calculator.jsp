<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp" />
	
	<form action="applicationServlet?controller=br.com.fluentcode.controller.SumController" method="POST">
		Value 1: <input type="text" name="value1" /><br /> 
		Value 2: <input	type="text" name="value2" /><br /> 
		<input type="submit" value="Sum" />
	</form>
	
	<p>${result}</p>
		
	<c:import url="footer.jsp" />
</body>
</html>