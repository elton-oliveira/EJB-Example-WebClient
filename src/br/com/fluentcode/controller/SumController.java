package br.com.fluentcode.controller;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.ejb.remote.CalculatorRemote;
import br.com.fluentcode.infra.mvc.controller.Controller;


public class SumController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, NamingException {
		
		CalculatorRemote calculator = lookupCalculatorRemote();

		int value1 = Integer.parseInt(request.getParameter("value1"));
		int value2 = Integer.parseInt(request.getParameter("value2"));
		int sum = calculator.add(value1, value2);

		request.setAttribute("result", value1+" + " + value2 +" = "+sum);
		
		return "/calculator.jsp";
	}

	private CalculatorRemote lookupCalculatorRemote() throws NamingException {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(Context.SECURITY_PRINCIPAL, "elton");
		p.put(Context.SECURITY_CREDENTIALS, "123");
		InitialContext ctx = new InitialContext(p);
		return (CalculatorRemote) ctx.lookup("EJB-Example/CalculatorBean!br.com.fluentcode.ejb.remote.CalculatorRemote");
	}

}
