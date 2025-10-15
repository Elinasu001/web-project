package com.su.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mb")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		MemberController mc = new MemberController();
		
		String view = "";
		switch(mapping) {
	    case "loginForm": view = mc.loginForm(request, response); break;
	    case "login": view = mc.login(request, response); break;
	    case "logout": view = mc.logout(request, response); break;
	    case "signUpForm": view = mc.signUpForm(request, response); break;
	    case "signUp": view = mc.signUp(request, response); break;
		}
		
	    if (view != null) {
	        // redirect 형식이 아닌 경우에만 forward
	        if (!view.startsWith("redirect:")) {
	            request.getRequestDispatcher(view).forward(request, response);
	        } else {
	            // redirect 요청이 있으면 여기서 직접 redirect
	            String redirectPath = view.substring("redirect:".length());
	            response.sendRedirect(request.getContextPath() + redirectPath);
	        }
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
