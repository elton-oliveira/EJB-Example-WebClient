package br.com.fluentcode.controller;

import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.ejb.remote.MessageSenderRemote;
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

	private void senderJmsMessage(String message) throws NamingException, JMSException {
		Context ctx = new InitialContextFactory().getContext();
		MessageSenderRemote sender =  (MessageSenderRemote) ctx.lookup("EJB-Example/MessageSenderBean!br.com.fluentcode.ejb.remote.MessageSenderRemote");
		sender.sendMessage(message);
	}

}
