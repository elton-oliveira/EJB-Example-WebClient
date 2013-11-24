package br.com.fluentcode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.infra.mvc.controller.Controller;


public class SumController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int value1 = Integer.parseInt(request.getParameter("value1"));
		int value2 = Integer.parseInt(request.getParameter("value2"));
		int sum = value1 + value2;

		request.setAttribute("result", value1+" + " + value2 +" = "+sum);
		
		return "/calculator.jsp";
	}

}
