package com.su.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.breacrumb.common.BreadcrumbUtil;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		BoardController bc = new BoardController();
		
		String view = "";
		
		switch(mapping) {
	    case "boards": 
	    	view = bc.boards(request, response); 
	    	BreadcrumbUtil.setBreadcrumb(request, "boards");
	    	break;
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
