package com.su.member.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 방법 1: session 지우기 (개별 속성만 삭제)
		// 방법 2: session 만료
		request.getSession().invalidate();
		
		HttpSession newSession = request.getSession();
	    newSession.setAttribute("alertMsg", "로그아웃되었습니다");
		
		response.sendRedirect(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

/*
 * [세션 종료 방법]
 * 개별 삭제 vs invalidate
 * 
 * 방법 1. session 지우기 (개별 속성만 삭제)
 * 코드 [
 * 
 * 	1_1) 기존 세션 가져오기 (있으면 반환, 없으면 새로 만들지 않게 false)
 * 	HttpSession session = request.getSession(false);
 * 
 * 	if(session != null){
 * 		1_2) 로그인 정보만 제거
 * 		session.removeAttribute("userInfo");
 * 	
 *  	1_3) alert 메시지는 유지 가능(또는 새로 설정 가능)
 *  	session.setAttribute("alertMsg", "로그아웃되었습니다.");
 *  
 * 	}
 * 
 * ]
 * - 결과 : "userInfo"만 삭제 -> 로그인만 해제됨
 * 			세션(alertMsg, 장바구니 등)은 그대로 유지
 * 			사용자 맞춤 설정이나 쿠키는 유지 가능
 * - 언제 사용 하는가 : 로그인만 해제하고,
 * 					나머지는 세션 정보(예: 방문기록, 테마 색상 등)는 유지하고 싶을 때
 * 					예) "비회원으로 계속 이용하기"
 *  
 * ---------------------------------------------------------------
 * 방법 2. 세션 자체 만료(invalidate) [v]
 * 
 * 코드 [
 * 
 * 	2_1) 기존 세션을 완전히 만료
 *  request.getSession().invalidate();
 *  
 *  2_2) invalidate() 후에는 새 세션이 필요함
 *  HttpSession newSession = request.getSession(); // request.getSession().invalidate(); 다음 줄에서 바로 getSession()을 새로 호출하는 부분은 의도상 맞지만, 
 *  											   // 가독성을 위해 새 세션을 명시적으로 변수에 담는 게 좋습니다.
 *  newSession.setAttribute("alertMsg", "로그아웃되었습니다.");
 * 
 * ]
 * 
 * - 결과 :
 * 기존의 세션의 모든 속성(userInfo, alertMsg, 기타 모든 데이터)이 완전히 삭제
 * JSESSIONID가 새로 발급됨(보안상 더 안전)
 * 새로운 세션 만들고 alertMsg를 다시 설정
 * 
 * - 언제 사용 하는가 : 로그아웃 시 거의 항상 사용 (실무 표준)
 * 					보안상 쿠키, 세션, 재사용 방지 필요할 때
 * 					로그인 사용자 간 정보가 섞이지 않게 확실히 차단하고 싶을 때
 * 
 * 
 */
