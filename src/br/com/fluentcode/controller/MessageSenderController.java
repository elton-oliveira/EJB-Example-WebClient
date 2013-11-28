package br.com.fluentcode.controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.infra.mvc.controller.Controller;
import br.com.fluentcode.util.InitialContextFactory;


public class MessageSenderController extends Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws NamingException, JMSException {
		
		String message = request.getParameter("message");
		
		senderJmsMessage(message);

		request.setAttribute("result", "Message '"+message+"' sent");
		
		return "/message_sender.jsp";
	}

	private void senderJmsMessage(String message) throws NamingException,
			JMSException {
		Context context = new InitialContextFactory().getContext();
		Destination destination = (Destination) context.lookup("FluentCodeQueue");
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
		Connection connection = connectionFactory.createConnection("elton","123");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(destination);
		TextMessage textMessage = session.createTextMessage();
		textMessage.setText(message);
		messageProducer.send(textMessage);
		connection.close();
	}

}
