package br.com.fluentcode.controller;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.ejb.remote.CalculatorRemote;
import br.com.fluentcode.infra.mvc.controller.Controller;
import br.com.fluentcode.util.InitialContextFactory;


public class SumController extends Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws NamingException {
		
		CalculatorRemote calculator = calculatorRemoteLookup();

		int value1 = Integer.parseInt(request.getParameter("value1"));
		int value2 = Integer.parseInt(request.getParameter("value2"));
		int sum = calculator.add(value1, value2);

		request.setAttribute("result", value1+" + " + value2 +" = "+sum);
		
		return "/calculator.jsp";
	}

	private CalculatorRemote calculatorRemoteLookup() throws NamingException {
		Context ctx = new InitialContextFactory().getContext();
		return (CalculatorRemote) ctx.lookup("EJB-Example/CalculatorBean!br.com.fluentcode.ejb.remote.CalculatorRemote");
	}

}
