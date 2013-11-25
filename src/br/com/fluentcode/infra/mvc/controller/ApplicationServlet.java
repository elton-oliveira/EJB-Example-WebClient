package br.com.fluentcode.infra.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * A curiosity about servlets: according to the servlet specification, by
 * default, exists a single instance of each servlet class. Arriving a request to
 * servlet, a new thread is open on that instance that already exists. So when
 * we talk about servlets, blueprint says to avoid using shared attributes.
 * 
 */
@WebServlet("/applicationServlet")
public class ApplicationServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String page = null;
			String controllerClassName = request.getParameter("controller");
			Class clazz = Class.forName(controllerClassName);
			Controller instance = (Controller) clazz.newInstance();
			String methodName = request.getParameter("operation");
			if(methodName == null){
				page = instance.execute(request, response);
			}else{
				Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				page = (String) method.invoke(instance, request, response);
			}
			if(page != null){
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		}catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
