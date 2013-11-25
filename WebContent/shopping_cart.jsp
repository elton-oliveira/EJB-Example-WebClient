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
	
	<form action="br.com.fluentcode.controller.ShoppingCartController.do" method="POST">
		Item: <input type="text" name="item" /><br /> 
		<input type="submit" value="Add" />
	</form>
	<form action="br.com.fluentcode.controller.ShoppingCartController.do" method="POST">
		<input type="hidden" name="operation" value="finishShopping"/>
		<input type="submit" value="Finish shopping" />
	</form>
	
	<p>${items}</p>
		
	<c:import url="footer.jsp" />
</body>
</html>