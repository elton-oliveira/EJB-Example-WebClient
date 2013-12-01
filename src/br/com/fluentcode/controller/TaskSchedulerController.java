package br.com.fluentcode.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fluentcode.ejb.remote.TaskSchedulerRemote;
import br.com.fluentcode.infra.mvc.controller.Controller;
import br.com.fluentcode.util.InitialContextFactory;

public class TaskSchedulerController extends Controller{
	
	public String scheduleTask(HttpServletRequest request,
			HttpServletResponse response) throws NamingException {
		
		String info = request.getParameter("info");
		int seconds = Integer.valueOf(request.getParameter("seconds"));
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, seconds);
		Date date = calendar.getTime();
		
		TaskSchedulerRemote scheduler = taskSchedulerRemoteLookup();
		scheduler.scheduleTask(date, info);
		
		request.setAttribute("result", "Task '"+info+"' scheduled");
		
		return "/task_scheduler.jsp";
	}
	
	public String cancelTask(HttpServletRequest request,
			HttpServletResponse response) throws NamingException {
		
		TaskSchedulerRemote scheduler = taskSchedulerRemoteLookup();
		List<String> messages = scheduler.cancelTask();
		
		request.setAttribute("result", messages);
		
		return "/task_scheduler.jsp";
	}
	
	private TaskSchedulerRemote taskSchedulerRemoteLookup() throws NamingException {
		Context ctx = new InitialContextFactory().getContext();
		return  (TaskSchedulerRemote) ctx.lookup("EJB-Example/TaskSchedulerBean!br.com.fluentcode.ejb.remote.TaskSchedulerRemote");
	}

}
