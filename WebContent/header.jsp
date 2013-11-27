<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">
   <h3>Menu</h3>
	<ul>
		<li><a href="<c:url value="/calculator.jsp"/>">Calculator (Stateless Session Bean Client)</a></li>
		<li><a href="<c:url value="/shopping_cart.jsp"/>">Shopping Cart (Stateful Session Bean Client)</a></li>
		<li><a href="<c:url value="/message_sender.jsp"/>">Message Queue Sender (Message-Driven Bean Client)</a></li>
	</ul>
</div>
