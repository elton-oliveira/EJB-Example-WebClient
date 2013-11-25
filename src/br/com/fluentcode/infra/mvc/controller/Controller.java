package br.com.fluentcode.infra.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}
