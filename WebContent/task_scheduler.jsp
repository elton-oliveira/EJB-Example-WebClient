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
	
	<h3>Task Scheduler</h3>
	
	<form action="br.com.fluentcode.controller.TaskSchedulerController.do?operation=scheduleTask" method="POST">
		Task: <input type="text" name="info" /><br />
		Seconds: <input type="text" name="seconds" /><br /> 
		<input type="submit" value="Schedule Task" />
	</form>
	<form action="br.com.fluentcode.controller.TaskSchedulerController.do" method="POST">
		<input type="hidden" name="operation" value="cancelTask"/>
		<input type="submit" value="Cancel Task" />
	</form>
	
	<p>${result}</p>
		
	<c:import url="footer.jsp" />
</body>
</html>