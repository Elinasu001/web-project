package com.su.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.su.member.model.service.MemberService;
import com.su.member.model.vo.Member;

public class MemberController {

    public String loginForm(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/member/login.jsp";
    }
    
    public String login(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		// 인코딩 설정
    		// 1) request 객체로부터 요청 값 받기
    		String userId = request.getParameter("userId");
    		String userPwd = request.getParameter("userPwd");
    		// 2) 데이터 가공
    		Member member = new Member();
    		member.setUserId(userId);
    		member.setUserPwd(userPwd);
    		// 3) 요청 처리
    		Member loginMember = new MemberService().login(member);
    		System.out.println(loginMember);
    		// 5) 응답화면 지정 : 로그인 성공 / 실패
    		if(loginMember != null) {
    			HttpSession session = request.getSession();
    			session.setAttribute("userInfo", loginMember);
    			session.setAttribute("alertMsg", "로그인성공");
    			return "redirect:/";
    		} else {
    			request.setAttribute("msg", "로그인 실패");
    			return "/WEB-INF/views/common/result_page.jsp";
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("msg", "로그인 중 오류가 발생했습니다.");
    		return "/WEB-INF/views/common/error.jsp";
    	}
    }
    
    
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	try {
            // 1️)기존 세션 가져오기
            HttpSession session = request.getSession();
            // 2️)로그아웃 메시지 저장 (invalidate 전에)
            session.setAttribute("alertMsg", "로그아웃되었습니다~!!");
            // 3️)세션 무효화
            session.invalidate();
            // 4️)메인 화면으로 리다이렉트
            // 5️) redirect 후 forward 하지 않도록 null 반환
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "로그아웃 중 오류가 발생했습니다.");
            return "/WEB-INF/views/common/error.jsp";
        }
    }
    
    public String signUpForm(HttpServletRequest request, HttpServletResponse response) {
    	return "/WEB-INF/views/member/enroll_form.jsp";
    }
    		
    public String signUp(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		// 인코딩설정
    		// 1) request 객체로부터 요청 값 받기
    		String userId = request.getParameter("userId");
    		String userPwd = request.getParameter("userPwd");
    		String userName = request.getParameter("userName");
    		String email = request.getParameter("email");
    		
    		// 2) Member 객체 담기
    		Member member = new Member();
    		member.setUserId(userId);
    		member.setUserPwd(userPwd);
    		member.setUserName(userName);
    		member.setEmail(email);
    		
    		// 3) 요청 처리
    		int result = new MemberService().signUp(member);
    		
    		if(result > 0) {
    			// 성공
    			// 1️)기존 세션 가져오기
                HttpSession session = request.getSession();
                // 2️)메시지 저장
                session.setAttribute("alertMsg", "회원가입 성공~!!");
                return "redirect:/";
    		} else{
    			// 실패
	            request.setAttribute("msg", "회원가입에 실패했습니다.");
	            return "/WEB-INF/views/common/result_page.jsp";
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
	        request.setAttribute("msg", "처리 중 오류가 발생했습니다");
	        return "/WEB-INF/views/common/error.jsp";
    	}
    }
}
