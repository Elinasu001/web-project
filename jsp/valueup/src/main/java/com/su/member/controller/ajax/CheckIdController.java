package com.su.member.controller.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.member.model.service.MemberService;

@WebServlet("/checkId")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String result = new MemberService().checkId(id);
		
		// 1) 무슨 데이터인지 ?
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
