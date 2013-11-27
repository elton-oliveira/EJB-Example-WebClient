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
	
	<h3>Message Queue Sender (Message-Driven Bean Client)</h3>
	
	<form action="br.com.fluentcode.controller.MessageSenderController.do" method="POST">
		Message: <input type="text" name="message" /><br /> 
		<input type="submit" value="Send" />
	</form>
	
	<p>${result}</p>
		
	<c:import url="footer.jsp" />
</body>
</html>