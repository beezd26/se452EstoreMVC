package com.estoremvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.estore.domain.order.Cart;
import com.estore.service.order.ICart;

//This interceptor method is called when HandlerAdapter has invoked the handler but DispatcherServlet is yet to render the view.
//Allows addition of global model elements to all views specifically around cart and user.
public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ICart cart = (ICart)session.getAttribute("cart");
        if (modelAndView != null) {
        	if (cart == null)
    			cart = new Cart();
        	modelAndView.addObject("cart", cart);
        }
    }
}
