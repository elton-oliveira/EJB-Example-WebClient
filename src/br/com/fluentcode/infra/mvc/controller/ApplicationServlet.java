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
 * According to the servlet specification, by default, "a servlet container may send 
 * concurrent requests through the service method of the servlet". In other words 
 * servlet is multithread. Arriving a request to servlet, a new thread can be opened
 * on that instance that already exists. So when we talk about servlets, blueprint 
 * says to avoid using shared attributes.
 * 
 */
@WebServlet("*.do")
public class ApplicationServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String page = null;
			Class clazz = Class.forName(getClassName(request));
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
	
	private String getClassName(HttpServletRequest request){
		String str = request.getServletPath().replace("/","");
		return str.substring(0, str.lastIndexOf(".do"));
	}
	
}
