package br.com.fluentcode.controller;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fluentcode.ejb.remote.ShoppingCartRemote;
import br.com.fluentcode.infra.mvc.controller.Controller;
import br.com.fluentcode.util.InitialContextFactory;

public class ShoppingCartController extends Controller {

	public String addItem(HttpServletRequest request,
			HttpServletResponse response) throws NamingException {

		ShoppingCartRemote cart = getShoppingCartRemote(request.getSession());
		String item = request.getParameter("item");
		cart.addItem(item);

		return "/shopping_cart.jsp";
	}

	public String finishShopping(HttpServletRequest request,
			HttpServletResponse response) throws NamingException {
		
		ShoppingCartRemote cart = getShoppingCartRemote(request.getSession());
		request.setAttribute("items", cart.getItems());
		cart.finishShopping();
		request.getSession().removeAttribute("shoppingCartRemote");
		
		return "/shopping_cart.jsp";
	}

	private ShoppingCartRemote getShoppingCartRemote(HttpSession session)
			throws NamingException {
		Object shoppingCart = session.getAttribute("shoppingCartRemote");
		if (shoppingCart == null) {
			shoppingCart = shoppingCartRemoteLookup();
			session.setAttribute("shoppingCartRemote", shoppingCart);
		}
		return (ShoppingCartRemote) shoppingCart;
	}

	private ShoppingCartRemote shoppingCartRemoteLookup() throws NamingException {
		Context ctx = new InitialContextFactory().getContext();
		return (ShoppingCartRemote) ctx.lookup("EJB-Example/ShoppingCartBean!br.com.fluentcode.ejb.remote.ShoppingCartRemote");
	}

}
